
/* Full Name: Gregorio Salgado
   Worked in partnership with: N/A
   Student ID: 2488680
   Email: gsalgado@chapman.edu
   Course: CPSC 231 - 04
   Assignment: Master Project 4A - Card Class
   Date: April 11, 2026
   Description: Creating a card class and testing its functionality with classes and objects.
*/

// testcard class to test the card class and its methods

import java.util.LinkedList;
public class Driver {
    public static void main(String[] args) {

            // creating 7 card objects with different constructors and values
        Card c1 = new Card();
        Card c2 = new Card(3, Card.DIAMONDS);
        Card c3 = new Card(c2);
        Card c4 = new Card(Card.QUEEN, Card.SPADES);
        Card c5 = new Card(11, Card.CLUBS );
        Card c6 = new Card(13, Card.HEARTS );
        Card c7 = new Card(14, Card.HEARTS );

        // dealer object
        Dealer d1 = new Dealer();

        // deal 5 cards
        LinkedList<Card> hand = d1.deals(5);
        System.out.println(hand);
          


        // print all out
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);
        System.out.println(c6);
        System.out.println(c7);

        // testing getters, setters, and equals method
        c1.getSuit();
        c4.getRank();

        System.out.println("getSuit on c1 :" + c1.getSuit());
        System.out.println("getRank on c4: " + c4.getRank());

        c2.setSuit(1);
        c2.setRank(Card.QUEEN);

        System.out.println("c2 equals c3: " + c2.equals(c3));
        System.out.println("c1 equals c2: " + c1.equals(c2));




        // create game
        Game game1 = new Game();
        int winner = game1.play();
        System.out.println("Congrats! Player Number " + winner + " is the winner!!!" );

    }
}