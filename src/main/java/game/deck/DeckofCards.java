package game.deck;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

import game.deck.Basic.*;
import game.deck.Armor.*;
import game.deck.Weapon.*;
import game.deck.DelayTactics.*;
import game.deck.Tactics.*;
import static game.deck.Card.Suit.*;

public class DeckofCards {
  private ArrayList<Card> cards;
  private ArrayList<Card> discardedPile;
  private ArrayList<Card> tableTop;

  private DeckofCards() {
    // The pile of cards from which players draw
    this.cards = new ArrayList<>();

    // The pile of cards that are played in the current turn
    this.tableTop = new ArrayList<>();

    // The pile of discarded cards. Cards on table top go here after each turn ends
    this.discardedPile = new ArrayList<>();

    // The discarded pile and table top are initially empty.
    // We manually add all cards to the "cards" array

    // Spade cards
    cards.add(new Duel(1, SPADE));

    cards.add(new EightTrigrams(2, SPADE));

    cards.add(new BurnBridges(3, SPADE));

    for (int rank : new int[] {4, 11}) {
      cards.add(new Pilfer(rank, SPADE));
    }

    for (int rank : new int[] {5, 7, 8, 10}) {
      cards.add(new Attack(rank, SPADE));
    }

    cards.add(new SwordofBlueSteel(6, SPADE));

    cards.add(new FrostBlade(9, SPADE));

    cards.add(new SerpentSpear(12, SPADE));

    cards.add(new BarbariansAssault(13, SPADE));




    // Heart cards
    cards.add(new HailofArrows(1, HEART));

    for (int rank : new int[] {2, 10, 11}) {
      cards.add(new Attack(rank, HEART));
    }

    for (int rank : new int[] {3, 4, 9}) {
      cards.add(new Peach(rank, HEART));
    }

    cards.add(new Dodge(5, HEART));

    cards.add(new Acedia(6, HEART));

    for (int rank : new int[] {7, 8}) {
      cards.add(new SleightofHand(rank, HEART));
    }

    cards.add(new BurnBridges(12, HEART));

    cards.add(new ImpeccablePlan(13, HEART));




    // Club cards
    cards.add(new Duel(1, CLUB));

    cards.add(new ShieldofRenWang(2, CLUB));

    cards.add(new BurnBridges(3, CLUB));

    for (int rank : new int[] {4, 5, 6, 8, 9, 10, 11}) {
      cards.add(new Attack(rank, CLUB));
    }

    cards.add(new Drowning(7, CLUB));

    cards.add(new RationsDepleted(12, CLUB));

    cards.add(new ImpeccablePlan(13, CLUB));




    // Diamond cards
    cards.add(new ZhugeCrossbow(1, DIAMOND));

    for (int rank : new int[] {2, 3, 7, 8, 10, 11}) {
      cards.add(new Dodge(rank, DIAMOND));
    }

    cards.add(new Pilfer(4, DIAMOND));

    cards.add(new RockCleavingAxe(5, DIAMOND));

    for (int rank : new int[] {6, 9, 13}) {
      cards.add(new Attack(rank, DIAMOND));
    }

    cards.add(new Peach(12, DIAMOND));
  }

  public DeckofCards(ArrayList<Card> cards, ArrayList<Card> tableTop, ArrayList<Card> discardedPile) {
    this.cards = cards;
    this.tableTop = tableTop;
    this.discardedPile = discardedPile;
  }


  /**
   * Constructs a new deck of 52 cards.
   * @return an instance of DeckofCard
   */
  public static DeckofCards makeNewDeck() {
    return new DeckofCards().shuffle();
  }


  /**
   * Gets all the cards that player can draw.
   * @return an arraylist of cards
   */
  public ArrayList<Card> getCards() {
    return cards;
  }


  /**
   * Gets all cards that have been played in the current turn.
   * @return an arraylist of cards
   */
  public ArrayList<Card> getTableTop() {
    return tableTop;
  }

  /**
   * Gets all the cards in the discarded pile.
   * @return an arraylist of discarded cards
   */
  public ArrayList<Card> getDiscardedPile() {
    return discardedPile;
  }


  /**
   * Counts the number of remaining cards in the deck.
   * @return an integer <= 52.
   */
  public int count() {
    return cards.size();
  }


  /**
   * Shuffles the remaining cards inside the deck.
   * @return the shuffled deck
   */
  public DeckofCards shuffle() {
    ArrayList<Card> newCards = getCards();
    Collections.shuffle(newCards);
    return new DeckofCards(newCards, getTableTop(), getDiscardedPile());
  }


  /**
   * If the main "cards" array is empty, shuffle cards in the discarded pile and move to main "cards".
   * Cards on the table top remains unchanged.
   * @return the new deck
   */
  public DeckofCards reset() {
    if (!getCards().isEmpty()) {
      // Delete one message after testing!
      System.out.println("错误：牌堆未空时重置，导致丢失卡牌");
      System.err.println("错误：牌堆未空时重置，导致丢失卡牌");
    }
    return new DeckofCards(getDiscardedPile(), getTableTop(), new ArrayList<>()).shuffle();
  }

}


