package game;

import game.deck.Card;
import game.deck.DeckofCards;
import game.players.Player;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * The main game instance.
 */
public class ThreeKingdoms {
  private Player me;
  private Player opponent;
  private DeckofCards deck;


  ThreeKingdoms(Player me, Player opponent, DeckofCards deck) {
    this.me = me;
    this.opponent = opponent;
    this.deck = deck;
  }

  /**
   * Starts a new game with a new deck of cards (and empty discarded pile).
   * @param me the main player instance
   * @param opponent the opponent player instance
   * @return a new game instance with the players and an initialized deck
   */
  public static ThreeKingdoms startNewGame(Player me, Player opponent) {
    return new ThreeKingdoms(me, opponent, DeckofCards.makeNewDeck());
  }


  /**
   * Gets the main player of the game.
   * @return an instance of player
   */
  public Player getMainPlayer() {
    return me;
  }

  /**
   * Gets the opponent player of the game.
   * @return an instance of player
   */
  public Player getOpponent() {
    return opponent;
  }

  /**
   * Updates the main player of the game.
   * @param me the new main player
   * @return a new game instance with updated main player
   */
  public ThreeKingdoms updateMainPlayer(Player me) {
    return new ThreeKingdoms(me, opponent, deck);
  }

  /**
   * Updates the opponent player of the game.
   * @param opponent the new opponent player
   * @return a new game instance with updated opponent
   */
  public ThreeKingdoms updateOpponent(Player opponent) {
    return new ThreeKingdoms(me, opponent, deck);
  }

  /**
   * Gets all the cards that players can draw in the game.
   * @return an arraylist of current cards
   */
  public ArrayList<Card> getCards() {
    return deck.getCards();
  }

  /**
   * Gets all cards that have been played in the current turn.
   * @return an arraylist of cards in the current turn
   */
  public ArrayList<Card> getTableTop() {
    return deck.getTableTop();
  }

  /**
   * Gets all cards in the discarded pile.
   * @return an arraylist of discarded cards.
   */
  public ArrayList<Card> getDiscardedPile() {
    return deck.getDiscardedPile();
  }

  /**
   * Updates the deck of the game.
   * @param newCards arraylist of new cards to be drawn
   * @param newTable arraylist of new cards played in the current turn
   * @param newDiscarded arraylist of new discarded cards
   * @return a new game instance with updated deck
   */
  public ThreeKingdoms updateDeck(ArrayList<Card> newCards, ArrayList<Card> newTable, ArrayList<Card> newDiscarded) {
    return new ThreeKingdoms(me, opponent, new DeckofCards(newCards, newTable, newDiscarded));
  }

  /**
   * Updates the deck of the game.
   * @param newDeck new deck of the game
   * @return a new game instance with updated deck
   */
  public ThreeKingdoms updateDeck(DeckofCards newDeck) {
    return new ThreeKingdoms(me, opponent, newDeck);
  }

  /**
   * Draw n cards for the main player.
   * @param n the number of cards to be drawn
   * @return a new game instance with updated main player and deck
   */
  public ThreeKingdoms draw(int n) {
    int count = n;
    ArrayList<Card> remainingCards = getCards();
    ArrayList<Card> newHand = me.getHand();
    while (count > 0) {
      Card card = remainingCards.remove(0);
      newHand.add(card);
      count--;
    }
    return updateMainPlayer(me.updateHand(newHand)).updateDeck(remainingCards, getTableTop(), getDiscardedPile());
  }

  /**
   * Ends the current turn. Move all cards on table top to discarded pile.
   * @return a new game instance with updated tableTop and discardedPile
   */
  public ThreeKingdoms endTurn() {
    ArrayList<Card> newDiscarded = getDiscardedPile();
    newDiscarded.addAll(getTableTop());
    return updateDeck(getCards(), new ArrayList<>(), newDiscarded);
  }


  //
//  // used to read text from the user
//  private static Scanner cin = new Scanner(System.in, UTF_8.name());
//
//  public static String getAnswer() {
//    return cin.nextLine();
//  }
//
//  public void changePlayer() {
//    if (currentPlayer == player1) {
//      currentPlayer = player2;
//    } else {
//      currentPlayer = player1;
//    }
//  }
//
//  public void draw(int n) {
//    deck.d(numofCards, currentPlayer, discardedCards);
//    System.out.println("你好， " +
//            currentPlayer.getName() +
//            ", 你目前的手牌为 " +
//            currentPlayer.getHand());
//  }
//
//  private void instructions() {
//    System.out.println(currentPlayer.getName() + ", 你目前的手牌为 " + currentPlayer.getHand());
//    System.out.println("请输入你要打出的卡牌的序号");
//    System.out.println("1为最左边的卡");
//    System.out.println(currentPlayer.getHand().size() + " 为最右边的卡");
//  }
//
//  public Card.Type playACard() {
//    System.out.println(currentPlayer.getName() + ", 目前是你的回合，请问你是否需要打出卡牌（是／否）");
//    if (getAnswer().charAt(0) == '是') {
//      instructions();
//      String index = getAnswer();
//      if (!(currentPlayer.check(index) == Card.Type.DODGE)) {
//        return currentPlayer.play(getAnswer());
//      } else {
//        System.out.println("请勿在不需要时打出闪");
//        System.out.println("你需要打出其他的卡牌吗（是／否）");
//        char again = getAnswer().charAt(0);
//        if (again == '是') {
//          playACard();
//        }
//        return null;
//      }
//    } else {
//      return null;
//    }
//  }
//
//  public boolean playACard(String type) {
//    instructions();
//    String answer = getAnswer();
//    String expected = currentPlayer.getHand().get(Integer.parseInt(answer) - 1).getType().toString();
//    if (expected == type) {
//      currentPlayer.play(getAnswer());
//      return true;
//    } else {
//      System.out.println("请打出一张" + expected);
//      System.out.println("你需要打出其他的卡牌吗（是／否）");
//      char again = getAnswer().charAt(0);
//      if (again == '是') {
//        playACard(type);
//      }
//      return false;
//    }
//  }
//
//  public boolean death() {
//    System.out.println(currentPlayer.getName() + "处于濒死状态");
//    changePlayer();
//    System.out.println(currentPlayer.getName() + "你是否使用一个桃?");
//    System.out.println("(1)--确定");
//    System.out.println("(2)--取消");
//    int selection = Integer.parseInt(getAnswer());
//    if (selection == 1) {
//      if (currentPlayer.hasCard(Card.Type.PEACH)) {
//        changePlayer();
//        currentPlayer.heal();
//        System.out.println(currentPlayer.getName() + "脱离濒死状态");
//        return false;
//      } else {
//        System.out.println("你没有桃");
//        changePlayer();
//        System.out.println(currentPlayer.getName() + "死亡");
//        changePlayer();
//        return true;
//      }
//    } else {
//      changePlayer();
//      System.out.println(currentPlayer.getName() + "死亡");
//      changePlayer();
//      return true;
//    }
//  }
//
//  public void discard(int index) {
//    discardedCards.add(currentPlayer.getHand().remove(index - 1));
//  }


  /**
   * The main program for the Three Kingdoms game.
   */
  public static void main(String[] args) {
//    // start game
//    ThreeKingdoms game = new ThreeKingdoms();
//    System.out.println("欢迎来到三国杀");
//
//    // input names
//    System.out.println("请输入第一位玩家名字 ");
//    game.player1.setName(getAnswer());
//    System.out.println("谢谢！请输入第二位玩家名字 ");
//    game.player2.setName(getAnswer());
//    System.out.println("游戏开始");
//
//    // deal 4 cards to each player
//    game.deck.shuffle();
//    game.draw(4);
//    game.changePlayer();
//    game.draw(4);
//    game.changePlayer();
//
//
//    while (true) {
//      // draw 2 cards
//      game.draw(2);
//
//      // play a card
//      Card.Type card = game.playACard();
//
//      // kill
//      if (card == Card.Type.KILL) {
//        game.changePlayer();
//        System.out.println("\n\n" +
//                game.currentPlayer.getName() +
//                ", 另一位玩家对您使用了一张杀，请问您是否打出一张闪（是／否）");
//        if (getAnswer().charAt(0) == '是') {
//          if (!game.playACard("DODGE")) {
//            game.currentPlayer.harm();
//            if (game.currentPlayer.getHp() == 0) {
//              if (game.death()) {
//                break;
//              }
//            }
//          } else {
//            System.out.println("You've successfully dodged the KILL!");
//          }
//        } else {
//          System.out.println("你选择了不打出闪");
//          game.currentPlayer.harm();
//          if (game.currentPlayer.getHp() == 0) {
//            if (game.death()) {
//              break;
//            }
//          }
//        }
//        game.changePlayer();
//      } else if (card == Card.Type.PEACH) {
//        // peach
//        game.currentPlayer.heal();
//        game.playACard();
//      } else {
//        System.out.println(game.currentPlayer.getName() + "选择不打出卡牌");
//      }
//
//      // Discard cards
//      while (game.currentPlayer.getHand().size() > game.currentPlayer.getHandLimit()) {
//        System.out.println(game.currentPlayer.getName() + ", 你有 " + game.currentPlayer.getHand().size() + " 张卡牌 " +
//                "而手牌上限是 " + game.currentPlayer.getHandLimit() + ", 所以请弃置 " +
//                (game.currentPlayer.getHand().size() - game.currentPlayer.getHandLimit()) + " 张卡牌。");
//        System.out.println("你现在有卡牌 " + game.currentPlayer.getHand());
//        System.out.println("请选择你需要弃置的卡牌的序号");
//        game.discard(Integer.parseInt(getAnswer()));
//      }
//      game.changePlayer();
//    }
//
//    // game over, ask if play again
//    System.out.println("游戏结束" + game.currentPlayer.getName() + "取得了胜利");

  }
}