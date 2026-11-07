# Egyptian Rat Screw Simulator

A Java program that simulates a full game of Egyptian Rat Screw. There's no user input. It just plays itself and prints everything to the terminal.

## How to run

```
javac *.java
java Driver
```

## How it works

- The deck is dealt out evenly (2 players by default, 26 cards each)
- Each player gets a random slap pattern: top bottom, doubles, or sandwich
- Players take turns playing cards onto the pile
- Face cards make the next player try to answer with a face card (Jack = 1 chance, Queen = 2, King = 3, Ace = 4). If they can't, the person who played the face card takes the pile
- If a player's pattern shows up after a number card, they slap and take the pile (if more than one player can slap, it picks one randomly)
- When a player runs out of cards they're out. Last one left wins

## Files

- `Card.java` - one card (rank and suit)
- `Deck.java` - 52 cards, deals them randomly
- `Dealer.java` - deals cards out of a deck
- `Player.java` - a player's hand and slap pattern
- `Game.java` - the game logic
- `Driver.java` - tests the Card class, then runs a game

## Changing the number of players

```java
Game game = new Game(4);
```

