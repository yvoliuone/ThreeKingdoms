package game.players;

import game.deck.Card;

import java.io.Serializable;
import java.util.ArrayList;


public class Player implements Serializable {
  private String name;
  private int hp;
  private int handLimit;
  private ArrayList<Card> hand;
  private ArrayList<Card> equipment;
  private ArrayList<Card> judge;

  private Player(Character character) {
    this.name = character.getName();
    this.hp = character.getHp();
    this.handLimit = character.getHp();
    this.hand = new ArrayList<>();
    this.equipment = new ArrayList<>(4);
    this.judge = new ArrayList<>();
  }

  private Player(String name, int hp, int handLimit, ArrayList<Card> hand,
                 ArrayList<Card> equipment, ArrayList<Card> judge) {
    this.name = name;
    this.hp = hp;
    this.handLimit = handLimit;
    this.hand = hand;
    this.equipment = equipment;
    this.judge = judge;
  }

  /**
   * Gets the name of the player's hero.
   * @return the hero's name
   */
  public String getName() {return name;}

  /**
   * Gets the maximum number of cards the player can hold.
   * @return the maximum number of cards
   */
  public int getHandLimit() {return handLimit;}

  /**
   * Gets the player's current HP.
   * @return current HP
   */
  public int getHP() {return hp;}

  /**
   * Updates the player's current HP, either heal or harm.
   * @param hpChange an integer, positive or negative, indicating the change in the player's current HP
   * @return a new player instance with updated HP
   */
  public Player updateHP(int hpChange) {
    return new Player(name, hp + hpChange, handLimit, hand, equipment, judge);
  }

  /**
   * Gets the player's current hand of cards.
   * @return the player's current hand as an arraylist
   */
  public ArrayList<Card> getHand() {
    return this.hand;
  }

  /**
   * Updates the player's current hand
   * @param newHand an arraylist representing the player's updated hand
   * @return a new player instance with updated hand
   */
  public Player updateHand(ArrayList<Card> newHand) {
    return new Player(name, hp, handLimit, newHand, equipment, judge);
  }

  /**
   * Gets the player's current equipments.
   * @return the player's equipments as an arraylist
   */
  public ArrayList<Card> getEquipment() {
    return equipment;
  }

  /**
   * Updates the player's current Equipment field.
   * @param newEquip an arraylist representing the player's updated equipments
   * @return a new player instance with updated equipments
   */
  public Player updateEquip(ArrayList<Card> newEquip) {
    return new Player(name, hp, handLimit, hand, newEquip, judge);
  }

  /**
   * Gets the cards in the player's Judge field.
   * @return the judge cards as an arraylist
   */
  public ArrayList<Card> getJudge() {
    return judge;
  }

  /**
   * Updates the player's current Judge field.
   * @param newJudge an arraylist representing the player's updated judge cards
   * @return a new player instance with updated judge
   */
  public Player udpateJudge(ArrayList<Card> newJudge) {
    return new Player(name, hp, handLimit, hand, equipment, newJudge);
  }


  /**
   * Checks whether the player's current HP is below (less than or equal to) 0.
   * If so, enter dying phase.
   * @return the current player if HP > 0, a new player instance with restored HP is HP = 0 and player has peach.
   * Otherwise end game.
   */
  Player checkDeath () {
    if (hp > 0) {
      return this;
    }
    // TODO: IMPLEMENT 濒死求桃
    throw new UnsupportedOperationException("Unimplemented");
  }

//
//  public void harm() {
//    hp--;
//    System.out.println(this.name + "受到1点伤害，体力值为" + hp);
//  }
//
//  public void heal() {
//    if (hp < handLimit) {
//      hp++;
//      System.out.println(this.name + "回复一点体力，体力值为" + hp);
//    } else {
//      System.out.println(this.name + "体力值为满值" + hp);
//    }
//  }
//
//  public Card.Type check(String i) {
//    int index = Integer.parseInt(i);
//    Card card = hand.get(index - 1);
//    return card.getType();
//  }
//
//  public Card.Type play(String i) {
//    int index = Integer.parseInt(i);
//    Card card = hand.get(index - 1);
//    System.out.println("You've played a " + card.getType());
//    hand.remove(card);
//    return card.getType();
//  }

}
