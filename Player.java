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
/**
 * Player class, where player details are implemented
 */
public class Player {
    private int playerNum;
    private LinkedList<Card> hand = new LinkedList<Card>();
    private String pattern;

  
    // overloaded constructor
     /**
     * Overloaded constructor that takes a player ID, hand, and pattern
     * @param playerID player num ID
     * @param playerHand player's hand, LinkedList Cards
     * @param pattern player gets a slap pattern to look for
     */
    public Player(int playerID, LinkedList<Card> playerHand, String pattern) {
        playerNum = playerID;
        hand = playerHand;
        this.pattern = pattern;
    }

    // overloaded 2
    /** Overloaded constructor that only takes pattern
     * @param pattern the slap pattern player is given
     */
    public Player(String pattern) {
        this.pattern = pattern;
    }

    // getters
   
     /**
     * Returns the player's number ID
     * @return playerNum as an int
     */
    public int getPlayerNum() {
        return playerNum;
    }

    /**
     * Returns player's current hand
     * @return LinkedList of Cards, player's hand
     */

    public LinkedList<Card> getHand() {
        return hand;
    }


    public String getPattern() {
        return this.pattern;
    }


    // player plays a card
      /**
     * Returns the slap pattern player watches for
     * @return pattern as a String
     */
    
    public Card playCard() {
        return hand.removeFirst();
    }

    // player slap
     /**
     * Checks if the player can slap based on their pattern
     * @param pile the current pile to evaluate
     * @return true if the player's pattern is in the pile
     */
    public boolean slaps(LinkedList<Card> pile) {
        if (this.pattern.equals("top bottom")) {
            
            if (Game.topBottom(pile)) {
               System.out.println("Player # " + this.getPlayerNum() + " slaps! Top Bottom!");
                return true;
                
            }
            else {
                return false;
            }
        }
        else if (this.pattern.equals("doubles")) {
            
            if (Game.doubles(pile)) {
                System.out.println("Player # " + this.getPlayerNum() + " slaps! Doubles!");
                return true;
                
            }
            else {
                return false;
            }
        }
        else if (this.pattern.equals("sandwich")) {
            if (Game.sandwich(pile)) {
                System.out.println("Player # " + this.getPlayerNum() + " slaps! Sandwich!");
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }          
    }

     /**
     * adds all cards from the pile to the bottom of the player's hand
     * @param pile the pile to take
     */
    public void takeCards(LinkedList<Card> pile) {
        for (int k = 0; k < pile.size(); k++) {
            hand.addLast(pile.get(k));
        }
        pile.clear();
    }


    // toString method
      /**
     * Returns a string with the player's number, hand, and pattern
     * @return String of player info
     */
    public String toString() {
        String s = "";
        s += "Player Number: " + playerNum + "\n";
        s += "Hand: " + hand + "\n";
        s += "Pattern: " + pattern + "\n";
        return s;
    }
}