/* Full Name: Gregorio Salgado
   Worked in partnership with: N/A
   Student ID: 2488680
   Email: gsalgado@chapman.edu
   Course: CPSC 231 - 04
   Assignment: Master Project 4A - Test Card Class
   Date: March 31, 2026
   Description: Draws a card from a deck of cards and returns the card as a string
*/


public class Card{

    // Card suit definitions
    public static final int HEARTS = 0;
    public static final int SPADES = 1;
    public static final int CLUBS = 2;
    public static final int DIAMONDS = 3;

    // Number card ranks
    public static final int card2 = 2;
    public static final int card3 = 3;
    public static final int card4 = 4;
    public static final int card5 = 5;
    public static final int card6 = 6;
    public static final int card7 = 7;
    public static final int card8 = 8;
    public static final int card9 = 9;
    public static final int card10 = 10;


    // set values for non-number cards
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    public static final int ACE = 14;

    // result
    private int m_suit;
    private int m_rank;

    // default constructor
    public Card() {
        m_suit = SPADES;
        m_rank = ACE;
    }

    // overloaded constructor
    public Card(int rank, int suit) {
        m_rank = rank;
        m_suit = suit;
    }

    // copy constructor
    public Card(Card otherCard) {
        m_suit = otherCard.m_suit;
        m_rank = otherCard.m_rank;
    }

    // toString Method
    public String toString() {
        String rank = "";
        String suit = "";

        // converting int values for suits 
        if (m_suit == 0) {
            suit = "HEARTS";
        }
        else if (m_suit == 1) {
            suit = "SPADES";
        }
        else if (m_suit == 2) {
            suit = "CLUBS";
        }
        else if (m_suit ==3 ) {
            suit = "DIAMONDS";
        }

        // convert non number cards to string value
        if (m_rank == 11) {
            rank = "JACK";
        }
        else if (m_rank == 12) {
            rank = "QUEEN";
        }
        else if (m_rank == 13) {
            rank = "KING";
        }
        else if (m_rank == 14) {
            rank = "ACE";
        }
        else {
            rank = String.valueOf(m_rank);  
        }
        return rank + " of " + suit;
    }

    // getters
    public int getSuit() {
        return m_suit;
    }

    public int getRank() {
        return m_rank;
    }

    // setters

    public void setSuit(int cardSuit) {
        m_suit = cardSuit;
    }

    public void setRank(int rank) {
        m_rank = rank;
    }

    // equals method
    public boolean equals(Card c) {
        return (getRank() == c.getRank());
    }

}






