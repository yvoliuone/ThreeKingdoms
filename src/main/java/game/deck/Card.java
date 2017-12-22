package game.deck;

import game.ThreeKingdoms;

import java.io.Serializable;

public abstract class Card implements Serializable {
  Integer rank;
  Suit suit;

  Card(int rank, Suit suit) {
    this.suit = suit;
    this.rank = rank;
  }

  public enum Suit {
    SPADE,
    HEART,
    DIAMOND,
    CLUB
  }

  /**
   * Get the suit of the card.
   * @return the suit of the card as in the enum Suit.
   */
  public Suit getSuit() {
    return suit;
  }


  /**
   * Get the rank of the card.
   * @return integer rank
   */
  public int getRank() {
    return rank;
  }


  /**
   * Play a particular card. Do the appropriate changes to the game instance.
   * @return the new game instance.
   */
  abstract ThreeKingdoms play();


  /**
   * Check whether the card is of black color (spade/club).
   * @return a boolean
   */
  public boolean isBlack() {
    return getSuit().equals(Suit.CLUB) || getSuit().equals(Suit.SPADE);
  }

  /**
   * Check whether the card is of red color (heart/diamond).
   * @return a boolean
   */
  public boolean isRed() {
    return getSuit().equals(Suit.DIAMOND) || getSuit().equals(Suit.HEART);
  }


  public boolean isBasic() {
    //TODO: do I need this method?
    return this instanceof Basic;
  }
}


// 基本牌
interface Basic {

  // 杀
  class Attack extends Card implements Basic {
    public Attack(int rank, Suit suit) {
      super(rank, suit);
    }

    @Override
    public ThreeKingdoms play() {
      //TODO: IMPLEMENT FOR Attack
      throw new UnsupportedOperationException("The method or operation is not implemented");
    }
  }


  // 闪
  class Dodge extends Card implements Basic {
    public Dodge(int rank, Suit suit) {
      super(rank, suit);
    }

    @Override
    public ThreeKingdoms play() {
      //TODO: IMPLEMENT FOR DODGE
      throw new UnsupportedOperationException("The method or operation is not implemented");
    }
  }


  // 桃
  class Peach extends Card implements Basic {
    public Peach(int rank, Suit suit) {
      super(rank, suit);
    }

    @Override
    public ThreeKingdoms play() {
      //TODO: IMPLEMENT FOR PEACH
      throw new UnsupportedOperationException("The method or operation is not implemented");
    }
  }

}


// 武器牌
interface Weapon {

  /**
   * Get the attack range of the weapon.
   * @return an integer representing the range
   */
  int getAttackRange();


  //TODO: 考虑把所有weapon的play()直接写在interface里 -- 把牌放入角色装备区


  // 诸葛连弩
  class ZhugeCrossbow extends Card implements Weapon {
    public ZhugeCrossbow(int rank, Suit suit) {
      super(rank, suit);
    }

    @Override
    public int getAttackRange() {
      return 1;
    }

    @Override
    public ThreeKingdoms play() {
      //TODO: IMPLEMENT FOR CROSSBOW
      throw new UnsupportedOperationException("The method or operation is not implemented");
    }
  }


  // 青釭剑
  class SwordofBlueSteel extends Card implements Weapon {
    public SwordofBlueSteel(int rank, Suit suit) {
      super(rank, suit);
    }

    @Override
    public int getAttackRange() {
      return 2;
    }

    @Override
    public ThreeKingdoms play() {
      //TODO: IMPLEMENT
      throw new UnsupportedOperationException("The method or operation is not implemented");
    }
  }


  // 寒冰剑
  class FrostBlade extends Card implements Weapon {
    public FrostBlade(int rank, Suit suit) {
      super(rank, suit);
    }

    @Override
    public int getAttackRange() {
      return 2;
    }

    @Override
    public ThreeKingdoms play() {
      //TODO: IMPLEMENT
      throw new UnsupportedOperationException("The method or operation is not implemented");
    }
  }


  // 丈八蛇矛
  class SerpentSpear extends Card implements Weapon {
    public SerpentSpear(int rank, Suit suit) {
      super(rank, suit);
    }

    @Override
    public int getAttackRange() {
      return 3;
    }

    @Override
    public ThreeKingdoms play() {
      //TODO: IMPLEMENT
      throw new UnsupportedOperationException("The method or operation is not implemented");
    }
  }


  // 贯石斧
  class RockCleavingAxe extends Card implements Weapon {
    public RockCleavingAxe(int rank, Suit suit) {
      super(rank, suit);
    }

    @Override
    public int getAttackRange() {
      return 3;
    }

    @Override
    public ThreeKingdoms play() {
      //TODO: IMPLEMENT
      throw new UnsupportedOperationException("The method or operation is not implemented");
    }
  }

}


// 防具牌
interface Armor {

  //TODO: 同样考虑直接一个play()写在interface里

  // 八卦阵
  class EightTrigrams extends Card implements Armor {
    public EightTrigrams(int rank, Suit suit) {
      super(rank, suit);
    }

    @Override
    public ThreeKingdoms play() {
      //TODO: IMPLEMENT
      throw new UnsupportedOperationException("The method or operation is not implemented");
    }
  }


  // 仁王盾
  class ShieldofRenWang extends Card implements Armor {
    public ShieldofRenWang(int rank, Suit suit) {
      super(rank, suit);
    }

    @Override
    public ThreeKingdoms play() {
      //TODO: IMPLEMENT
      throw new UnsupportedOperationException("The method or operation is not implemented");
    }
  }

}


// 非延时类锦囊牌
interface Tactics {

  // 决斗
  class Duel extends Card implements Tactics {
    public Duel(int rank, Suit suit) {
      super(rank, suit);
    }

    @Override
    public ThreeKingdoms play() {
      //TODO: IMPLEMENT
      throw new UnsupportedOperationException("The method or operation is not implemented");
    }
  }


  // 过河拆桥
  class BurnBridges extends Card implements Tactics {
    public BurnBridges(int rank, Suit suit) {
      super(rank, suit);
    }

    @Override
    public ThreeKingdoms play() {
      //TODO: IMPLEMENT
      throw new UnsupportedOperationException("The method or operation is not implemented");
    }
  }


  // 顺手牵羊
  class Pilfer extends Card implements Tactics {
    public Pilfer(int rank, Suit suit) {
      super(rank, suit);
    }

    @Override
    public ThreeKingdoms play() {
      //TODO: IMPLEMENT
      throw new UnsupportedOperationException("The method or operation is not implemented");
    }
  }


  // 南蛮入侵
  class BarbariansAssault extends Card implements Tactics {
    public BarbariansAssault(int rank, Suit suit) {
      super(rank, suit);
    }

    @Override
    public ThreeKingdoms play() {
      //TODO: IMPLEMENT
      throw new UnsupportedOperationException("The method or operation is not implemented");
    }
  }


  // 万箭齐发
  class HailofArrows extends Card implements Tactics {
    public HailofArrows(int rank, Suit suit) {
      super(rank, suit);
    }

    @Override
    public ThreeKingdoms play() {
      //TODO: IMPLEMENT
      throw new UnsupportedOperationException("The method or operation is not implemented");
    }
  }


  // 无中生有
  class SleightofHand extends Card implements Tactics {
    public SleightofHand(int rank, Suit suit) {
      super(rank, suit);
    }

    @Override
    public ThreeKingdoms play() {
      //TODO: IMPLEMENT
      throw new UnsupportedOperationException("The method or operation is not implemented");
    }
  }


  // 无懈可击
  class ImpeccablePlan extends Card implements Tactics {
    public ImpeccablePlan(int rank, Suit suit) {
      super(rank, suit);
    }

    @Override
    public ThreeKingdoms play() {
      //TODO: IMPLEMENT
      throw new UnsupportedOperationException("The method or operation is not implemented");
    }
  }


  // 水淹七军
  class Drowning extends Card implements Tactics {
    public Drowning(int rank, Suit suit) {
      super(rank, suit);
    }

    @Override
    public ThreeKingdoms play() {
      //TODO: IMPLEMENT
      throw new UnsupportedOperationException("The method or operation is not implemented");
    }
  }
}


// 延时类锦囊牌
interface DelayTactics {

  // 乐不思蜀
  class Acedia extends Card implements DelayTactics {
    public Acedia(int rank, Suit suit) {
      super(rank, suit);
    }

    @Override
    public ThreeKingdoms play() {
      //TODO: IMPLEMENT
      throw new UnsupportedOperationException("The method or operation is not implemented");
    }
  }

  // 兵粮寸断
  class RationsDepleted extends Card implements DelayTactics {
    public RationsDepleted(int rank, Suit suit) {
      super(rank, suit);
    }

    @Override
    public ThreeKingdoms play() {
      //TODO: IMPLEMENT
      throw new UnsupportedOperationException("The method or operation is not implemented");
    }
  }

}

