/* Full Name: Gregorio Salgado
   Worked in partnership with: N/A
   Student ID: 2488680
   Email: gsalgado@chapman.edu
   Course: CPSC 231 - 04
   Assignment: Master Project 4C - ERS
   Date: May 8, 2026
   Description: Built the Game and Player classes to be able to simulate a full game of Egyptian Rat Screw
*/

import java.util.LinkedList;
import java.util.Random;

/**
 * Represents the game of ERS
 * Managers players, rules, pile, all game logic
 */

public class Game{

    private LinkedList<Player> players = new LinkedList<Player>();
    private LinkedList<Card> pile = new LinkedList<Card>();
    private Dealer dealer = new Dealer();
    String[] patterns = {"top bottom", "doubles", "sandwich"};
    private int currentIndex = 0;
    private int chances = 0;
    private Random rand = new Random();
    String randomPattern = patterns[rand.nextInt(patterns.length)];

    // getters
     /**
     * Returns the list of players in the current game
     * @return LinkedList of Players
     */
    public LinkedList<Player> getPlayers() {
        return players;
    }

    /**
     * Returns the current pile of cards
     * @return LinkedList of Card objects 
     */
    public LinkedList<Card> getPile() {
        return pile;
    }

     /**
     * Returns Dealer object
     * @return the Dealer
     */
    public Dealer getDealer() {
        return dealer;
    }

        /**
     * Returns the array of slap options for the game
     * @return String array of pattern names
     */
    public String[] getPatterns() {
        return patterns;
    }

    public int getIndex() {
        return currentIndex;
    }

    public int getChances() {
        return chances;
    }

    // setters
    /**
     * All the setter methods
     * @param LinkedList<Player> linkedlist of players
     *  @param LinkedList<Card> linkedlist of cards
     *  @param Dealer Dealer object
     *  @param String[] string array of patterns
     * 
     */
    public void setPlayers(LinkedList<Player> players) {
        this.players = players;
    }

    public void setPile(LinkedList<Card> pile) {
        this.pile = pile;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public void setPatterns(String[] patterns) {
        this.patterns = patterns;
    }
    

    // default constructor
    /**
     * default constructor
     */
    public Game() { 
        this.players = new LinkedList<Player>();
        LinkedList<Card> hand1 = dealer.deals(26);
        LinkedList<Card> hand2 = dealer.deals(26);
        String playerPattern1 = patterns[rand.nextInt(3)];
        String playerPattern2 = patterns[rand.nextInt(3)];
        Player player1 = new Player(1, hand1, playerPattern1);
        Player player2 = new Player(2, hand2, playerPattern2); 
        this.players.add(player1);
        System.out.println("Player 1 Pattern: " + playerPattern1);
        this.players.add(player2);   
        System.out.println("Player 2 Pattern: " + playerPattern2);
                      
    }

    // overloaded constructor
    /**
     * Overloaded constructor, takes num of players as parameter
     * @param numPlayers num players to create
     */
    public Game(int numPlayers) { 
        this.players = new LinkedList<Player>();
        for (int g = 0; g < numPlayers; g++) {
            LinkedList<Card> playerHand = dealer.deals(52/numPlayers);
            String playerPatterns = patterns[rand.nextInt(3)];
            Player player = new Player(g + 1, playerHand, playerPatterns);
            this.players.add(player);
        }
    }

    // play method
   /**
     * runs full game until one player wins
     * @return player number of the winner
     */
    public int play() {

        while (players.size() > 1) {

           

            // players continue to play cards, played cards added to pile
            for (int i = 0; i < players.size(); i++) {

                Player current = players.get(i);
                if (current.getHand().size() == 0) {
                    continue;
                }

                Card cardPlayed = current.playCard();
                System.out.println("Player # " + current.getPlayerNum() + " plays: " + cardPlayed + "\n");
                pile.add(cardPlayed); 

                // if player can slap
                if (cardPlayed.getRank() <= 10) {
                    LinkedList<Player> slapList = new LinkedList<Player>();
                for (int s = 0; s < players.size(); s++) {
                  if (players.get(s).slaps(pile)) {
                    slapList.add(players.get(s));
                  }                        
                }
                if (slapList.size() > 0) {
                    Player slapper = slapList.get(rand.nextInt(slapList.size()));
                    slapper.takeCards(pile);
                    i = players.indexOf(slapper);
                  }
                     
                }
                

            // if face card is pulled
            if (cardPlayed.getRank() > 10) {
                currentIndex = i;
                Player next = this.nextPlayer();

                // jack
                if (cardPlayed.getRank() == 11) {
                    chances = 1;
                    System.out.println("Player # " + next.getPlayerNum() + " has " + chances + " chance(s) to pull a face card." + "\n");
                    for (int j = 0; j < chances; j++) {
                    if (next.getHand().size() == 0) {
                        System.out.println("Player # " + next.getPlayerNum() + " is eliminated! :( " + "\n");
                            break;
                        }
                    Card nextCard = next.playCard();
                    if (nextCard.getRank() < 11 ) {
                        current.takeCards(pile);
                        
                    } 
                    if (nextCard.getRank() > 10) {
                        if (nextCard.getRank() == 11) {
                            chances = 1;
                        }
                        if (nextCard.getRank() == 12) {
                            chances = 2;
                        }
                        if (nextCard.getRank() == 13) {
                            chances = 3;
                        }
                        if (nextCard.getRank() == 14) {
                            chances = 4;
                        }
                        Player newCurrent = next;
                        current = newCurrent;
                        currentIndex = players.indexOf(newCurrent);
                        next = this.nextPlayer();
                        j = -1;
                        System.out.println("Player # " + newCurrent.getPlayerNum() + " played a face card! Player # " + next.getPlayerNum() + " now has " + chances + " chances!");
                    }  
                    }
                      
                }

                // queen
                else if (cardPlayed.getRank() == 12) {
                    chances = 2;
                    System.out.println("Player # " + next.getPlayerNum() + " has " + chances + " chance(s) to pull a face card." + "\n");
                    for (int b = 0; b < chances; b++) {
                        if (next.getHand().size() == 0) {
                            break;
                        }
                        Card nextCard = next.playCard();
                        if (nextCard.getRank() < 11) {
                            current.takeCards(pile);
                            break;
                        }

                        if (nextCard.getRank() > 10) {
                        if (nextCard.getRank() == 11) {
                            chances = 1;
                        }
                        if (nextCard.getRank() == 12) {
                            chances = 2;
                        }
                        if (nextCard.getRank() == 13) {
                            chances = 3;
                        }
                        if (nextCard.getRank() == 14) {
                            chances = 4;
                        }
                        Player newCurrent = next;
                        current = newCurrent;
                        currentIndex = players.indexOf(newCurrent);
                        next = this.nextPlayer();
                        b = -1;
                        System.out.println("Player # " + newCurrent.getPlayerNum() + " played a face card! Player # " + next.getPlayerNum() + " now has " + chances + " chances!");
                    }  
                      
                        
                    }
                }
                // king
                else if (cardPlayed.getRank() == 13) {
                    chances = 3;
                    System.out.println("Player # " + next.getPlayerNum() + " has " + chances + " chance(s) to pull a face card." + "\n");
                    for (int a = 0; a < chances; a++) {
                        if (next.getHand().size() == 0) {
                            break;
                        }
                        Card nextCard = next.playCard();
                        if (nextCard.getRank() < 11) {
                            current.takeCards(pile);
                            break;
                        }

                        if (nextCard.getRank() > 10) {
                        if (nextCard.getRank() == 11) {
                            chances = 1;
                        }
                        if (nextCard.getRank() == 12) {
                            chances = 2;
                        }
                        if (nextCard.getRank() == 13) {
                            chances = 3;
                        }
                        if (nextCard.getRank() == 14) {
                            chances = 4;
                        }
                        Player newCurrent = next;
                        current = newCurrent;
                        currentIndex = players.indexOf(newCurrent);
                        next = this.nextPlayer();
                        a = -1;
                        System.out.println("Player # " + newCurrent.getPlayerNum() + " played a face card! Player # " + next.getPlayerNum() + " now has " + chances + " chances!");
                        }
                        
                    }
                }
                // ace 
                else if (cardPlayed.getRank() == 14) {
                    chances = 4;
                    System.out.println("Player # " + next.getPlayerNum() + " has " + chances + " chance(s) to pull a face card." + "\n");
                    for (int z = 0; z < chances; z++) {
                        if (next.getHand().size() == 0) {
                            break;
                        }
                        Card nextCard = next.playCard();
                        if (nextCard.getRank() < 11) {
                            current.takeCards(pile);
                            break;
                        }

                        if (nextCard.getRank() > 10) {
                        if (nextCard.getRank() == 11) {
                            chances = 1;
                        }
                        if (nextCard.getRank() == 12) {
                            chances = 2;
                        }
                        if (nextCard.getRank() == 13) {
                            chances = 3;
                        }
                        if (nextCard.getRank() == 14) {
                            chances = 4;
                        }
                        Player newCurrent = next;
                        current = newCurrent;
                        currentIndex = players.indexOf(newCurrent);
                        next = this.nextPlayer();
                        z = -1;
                        System.out.println("Player # " + newCurrent.getPlayerNum() + " played a face card! Player # " + next.getPlayerNum() + " now has " + chances + " chances!");
                    }  
                      
                        
                    }
                }
             }

             // if player has zero cards, they're out
             for (int m = 0; m < players.size(); m++) {
                Player eliminated = players.get(m);
                if (eliminated.getHand().size() == 0) {
                    players.remove(m);
                    m--;
                }
             }
            
            
        }
    
    }
    // return the winner at the end of the game
    Player winner = players.get(0);
    return winner.getPlayerNum();

 }
    


    // next player method
    /**
     * Returns next player in the circle after current player
     * @return next Player object
     */
   private Player nextPlayer() {
    currentIndex = (currentIndex + 1) % players.size();
    return players.get(currentIndex);
    }

    // top bottom methods
    /**
     * Checks if the top and bottom cards of pile are same rank
     * @param pile the current pile
     * @return true if top and bottom cards are same rank
     */
    static boolean topBottom(LinkedList<Card> pile) {
        if (pile.size() < 2) {
            return false;
        }
        if (pile.getFirst().getRank() == pile.getLast().getRank()) {
            return true;
        }
        else {
            return false;
        }
    }

    // doubles method
    /**
     * Checks if the top two cards are same
     * @param pile the current pile
     * @return true if last two cards match
     */
    static boolean doubles(LinkedList<Card> pile) {
       if (pile.size() < 2) {
        return false;
       }
       Card card1 = pile.getLast();
       int s = pile.size() - 2;
       Card card2 = pile.get(s);
       
       if (card1.getRank() == card2.getRank()) {
        return true;
       }
       else {
        return false;
       }
    }

  // sandwich method
   /**
     * Checks if top card is same as card two positions below it
     * @param pile current pile
     * @return true if a sandwich exists
     */
    static boolean sandwich (LinkedList<Card> pile) {
        if (pile.size() < 3) {
                return false;
            }
        int n = pile.size() - 2;
        Card cardNeeded = pile.get(n);
        
        if (pile.getLast().getRank() == cardNeeded.getRank()) {
            return true;
        }    
         else {
            return false;
        }
    }

    

    // last and first card methods for slap and game methods
    /**
     * Additional methods used in class
     */
    private Card lastCard() {
        return pile.getLast();
    }

    private Card firstCard() {
        return pile.getFirst();
    }








}