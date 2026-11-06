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
import java.util.Random;

public class Deck{
LinkedList<Card> m_cards = new LinkedList<>();
Random rand = new Random();

// default constructor
public Deck() {
    m_cards = new LinkedList<Card>();
    for (int suit = 0; suit <= 3; suit++) {
        for (int rank = 2; rank <= 14; rank++) {
            m_cards.add(new Card(rank, suit));
        }
    }
}

// deep copy constructor
public Deck(Deck otherDeck) {
    this.m_cards = new LinkedList<>();
    for (Card c : otherDeck.m_cards) {
        this.m_cards.add(c);
    }
}

// toString method
public String toString() {
    return m_cards.toString();

}

// return size method
public int size() {
   return m_cards.size();   
}

// deal method
public Card deal() {
    int randNum = rand.nextInt(m_cards.size());
    Card removedCard = m_cards.remove(randNum);
    return removedCard;
}

}


