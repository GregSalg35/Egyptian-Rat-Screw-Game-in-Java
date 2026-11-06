/* Full Name: Gregorio Salgado
   Worked in partnership with: N/A
   Student ID: 2488680
   Email: gsalgado@chapman.edu
   Course: CPSC 231 - 04
   Assignment: Master Project 4B - Deck and Dealer Class
   Date: April 24, 2026
   Description: Creating a dealer and deck classes that create whole decks of cards, deal them, and can show number of total cards left, etc.
*/

import java.util.LinkedList;
public class Dealer {
    public static Deck m_deck;

    // default constructor
    public Dealer() {
         m_deck = new Deck();
    }

    // deal method
    public LinkedList<Card> deals(int n) {
        LinkedList<Card> dealtCards = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (m_deck.size() != 0) {
                dealtCards.add(m_deck.deal());
            }

        }
        return dealtCards;
    }
   
    // size method
    public int size() {
        return m_deck.size();
        
    }

    // toString method
    public String toString() {
        return m_deck.toString();
    }
}



