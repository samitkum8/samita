package service;

import comparator.SortCombinationByRank;
import enumtype.CardCombination;
import enumtype.CardValue;
import model.Combination;
import model.Hand;
import model.HandCombinations;

public class PokerCombinationService
{
  /**
   *
   * @param hand
   * @return HandCombinations
   */
  public HandCombinations getHandCombination(Hand hand) {
    hand = PlayerHandService.sortHand(hand);
    HandCombinations handCombinations =  new HandCombinations();
    if (isRoyalFlush(hand,handCombinations)) {
      return sortCombination(handCombinations);
    }else if (isStraightFlush(hand,handCombinations)) {
      return sortCombination(handCombinations);
    }else if (isFourOfAKind(hand,handCombinations)) {
      return sortCombination(handCombinations);
    }else if (isFullHouse(hand,handCombinations)) {
      return sortCombination(handCombinations);
    }else if (isFlush(hand,handCombinations)) {
      return sortCombination(handCombinations);
    }else if (isStraight(hand,handCombinations)) {
      return sortCombination(handCombinations);
    }else if (isThreeOfKind(hand,handCombinations)) {
      return sortCombination(handCombinations);
    }else if (isTwoPair(hand,handCombinations)) {
      return sortCombination(handCombinations);
    }else if (isPair(hand,handCombinations)) {
      return sortCombination(handCombinations);
    }else if (isHighCard(hand,handCombinations)) {
      return sortCombination(handCombinations);
    }
    return sortCombination(handCombinations);
  }

  /**
   *
   * @param handCombinations
   * @return
   */
  public HandCombinations sortCombination(HandCombinations handCombinations) {
    handCombinations.getListCombination().sort( new SortCombinationByRank() );
    return handCombinations;
  }

  /**
   *
   * @param hand
   * @param handCombinations
   * @return
   */
  private Boolean isRoyalFlush(Hand hand, HandCombinations handCombinations) {
    if (hand.getCards().get(0).getValue().equals( CardValue.TEN) &&
            hand.getCards().get(1).getValue().equals( CardValue.JACK) &&
            hand.getCards().get(2).getValue().equals( CardValue.QUEEN) &&
            hand.getCards().get(3).getValue().equals( CardValue.KING) &&
            hand.getCards().get(4).getValue().equals( CardValue.ACE)) {
      handCombinations.getListCombination().add(new Combination( CardCombination.ROYAL_FLUSH, CardValue.ACE));
      return true;
    } else {
      return false;
    }
  }

  /**
   *
   * @param hand
   * @param handCombinations
   * @return
   */
  private Boolean isStraightFlush(Hand hand, HandCombinations handCombinations) {
    if (isStraight(hand, handCombinations) && isFlush(hand, handCombinations)) {
      handCombinations.getListCombination().clear();
      handCombinations.getListCombination().add(new Combination( CardCombination.STRAIGHT_FLUSH, hand.getCards().get(4).getValue()));
      return true;
    } else {
      return false;
    }
  }

  /**
   *
   * @param hand
   * @param handCombinations
   * @return
   */
  private Boolean isFourOfAKind(Hand hand, HandCombinations handCombinations) {
    if (hand.getCards().get(0).getValue().getVal().equals(hand.getCards().get(1).getValue().getVal()) &&
            hand.getCards().get(1).getValue().getVal().equals(hand.getCards().get(2).getValue().getVal()) &&
            hand.getCards().get(2).getValue().getVal().equals(hand.getCards().get(3).getValue().getVal())) {
      handCombinations.getListCombination().add(new Combination( CardCombination.FOUR_OF_A_KIND, hand.getCards().get(0).getValue()));
      handCombinations.getListCombination().add(new Combination( CardCombination.HIGH_CARD, hand.getCards().get(4).getValue()));
      return true;
    } else if (hand.getCards().get(1).getValue().getVal().equals(hand.getCards().get(2).getValue().getVal()) &&
            hand.getCards().get(2).getValue().getVal().equals(hand.getCards().get(3).getValue().getVal()) &&
            hand.getCards().get(3).getValue().getVal().equals(hand.getCards().get(4).getValue().getVal())) {
      handCombinations.getListCombination().add(new Combination( CardCombination.FOUR_OF_A_KIND, hand.getCards().get(4).getValue()));
      handCombinations.getListCombination().add(new Combination( CardCombination.HIGH_CARD, hand.getCards().get(0).getValue()));
      return true;
    } else {
      return false;
    }

  }

  /**
   *
   * @param hand
   * @param handCombinations
   * @return
   */
  private Boolean isFullHouse(Hand hand, HandCombinations handCombinations) {
    if (hand.getCards().get(0).getValue().getVal().equals(hand.getCards().get(1).getValue().getVal()) &&
            hand.getCards().get(2).getValue().getVal().equals(hand.getCards().get(3).getValue().getVal()) &&
            hand.getCards().get(3).getValue().getVal().equals(hand.getCards().get(4).getValue().getVal())) {
      handCombinations.getListCombination().add(new Combination( CardCombination.FULL_HOUSE, hand.getCards().get(4).getValue()));
      return true;
    } else if (hand.getCards().get(0).getValue().getVal().equals(hand.getCards().get(1).getValue().getVal()) &&
            hand.getCards().get(1).getValue().getVal().equals(hand.getCards().get(2).getValue().getVal()) &&
            hand.getCards().get(3).getValue().getVal().equals(hand.getCards().get(4).getValue().getVal())) {
      handCombinations.getListCombination().add(new Combination( CardCombination.FULL_HOUSE, hand.getCards().get(0).getValue()));
      return true;
    } else {
      return false;
    }
  }

  /**
   *
   * @param hand
   * @param handCombinations
   * @return
   */
  private Boolean isFlush(Hand hand, HandCombinations handCombinations) {
    if (hand.getCards().get(0).getValue().getVal().equals(hand.getCards().get(1).getValue().getVal() - 1) &&
            hand.getCards().get(1).getValue().getVal().equals(hand.getCards().get(2).getValue().getVal() - 1) &&
            hand.getCards().get(2).getValue().getVal().equals(hand.getCards().get(3).getValue().getVal() - 1) &&
            hand.getCards().get(3).getValue().getVal().equals(hand.getCards().get(4).getValue().getVal() - 1)) {
      handCombinations.getListCombination().add(new Combination( CardCombination.FLUSH, hand.getCards().get(4).getValue()));
      return true;
    } else {
      return false;
    }
  }

  /**
   *
   * @param hand
   * @param handCombinations
   * @return
   */
  private Boolean isStraight( Hand hand, HandCombinations handCombinations) {
    if (hand.getCards().get(0).getSuits().equals(hand.getCards().get(1).getSuits()) &&
            hand.getCards().get(1).getSuits().equals(hand.getCards().get(2).getSuits()) &&
            hand.getCards().get(2).getSuits().equals(hand.getCards().get(3).getSuits()) &&
            hand.getCards().get(3).getSuits().equals(hand.getCards().get(4).getSuits())) {
      handCombinations.getListCombination().add(new Combination( CardCombination.STRAIGHT, hand.getCards().get(4).getValue()));
      return true;
    } else {
      return false;
    }
  }

  /**
   *
   * @param hand
   * @param handCombinations
   * @return
   */
  private Boolean isThreeOfKind(Hand hand, HandCombinations handCombinations) {
    if (hand.getCards().get(2).getValue().getVal().equals(hand.getCards().get(3).getValue().getVal()) &&
            hand.getCards().get(3).getValue().getVal().equals(hand.getCards().get(4).getValue().getVal())) {
      handCombinations.getListCombination().add(new Combination( CardCombination.THREE_OF_A_KING, hand.getCards().get(4).getValue()));
      handCombinations.getListCombination().add(new Combination( CardCombination.HIGH_CARD, hand.getCards().get(0).getValue()));
      handCombinations.getListCombination().add(new Combination( CardCombination.HIGH_CARD, hand.getCards().get(1).getValue()));
      return true;

    } else if (hand.getCards().get(0).getValue().getVal().equals(hand.getCards().get(1).getValue().getVal()) &&
            hand.getCards().get(1).getValue().getVal().equals(hand.getCards().get(2).getValue().getVal())) {
      handCombinations.getListCombination().add(new Combination( CardCombination.THREE_OF_A_KING, hand.getCards().get(0).getValue()));
      handCombinations.getListCombination().add(new Combination( CardCombination.HIGH_CARD, hand.getCards().get(3).getValue()));
      handCombinations.getListCombination().add(new Combination( CardCombination.HIGH_CARD, hand.getCards().get(4).getValue()));
      return true;
    } else {
      return false;
    }
  }

  private Boolean isTwoPair(Hand hand, HandCombinations handCombinations) {
    if (hand.getCards().get(0).getValue().getVal().equals(hand.getCards().get(1).getValue().getVal()) &&
            hand.getCards().get(2).getValue().getVal().equals(hand.getCards().get(3).getValue().getVal())) {
      handCombinations.getListCombination().add(new Combination( CardCombination.TWO_PAIRS, hand.getCards().get(0).getValue()));
      handCombinations.getListCombination().add(new Combination( CardCombination.TWO_PAIRS, hand.getCards().get(2).getValue()));
      handCombinations.getListCombination().add(new Combination( CardCombination.HIGH_CARD, hand.getCards().get(4).getValue()));
      return true;
    } else if (hand.getCards().get(1).getValue().getVal().equals(hand.getCards().get(2).getValue().getVal()) &&
            hand.getCards().get(3).getValue().getVal().equals(hand.getCards().get(4).getValue().getVal())) {
      handCombinations.getListCombination().add(new Combination( CardCombination.TWO_PAIRS, hand.getCards().get(1).getValue()));
      handCombinations.getListCombination().add(new Combination( CardCombination.TWO_PAIRS, hand.getCards().get(3).getValue()));
      handCombinations.getListCombination().add(new Combination( CardCombination.HIGH_CARD, hand.getCards().get(0).getValue()));
      return true;
    } else if (hand.getCards().get(0).getValue().getVal().equals(hand.getCards().get(1).getValue().getVal()) &&
            hand.getCards().get(3).getValue().getVal().equals(hand.getCards().get(4).getValue().getVal())) {
      handCombinations.getListCombination().add(new Combination( CardCombination.TWO_PAIRS, hand.getCards().get(0).getValue()));
      handCombinations.getListCombination().add(new Combination( CardCombination.TWO_PAIRS, hand.getCards().get(3).getValue()));
      handCombinations.getListCombination().add(new Combination( CardCombination.HIGH_CARD, hand.getCards().get(2).getValue()));
      return true;
    } else {
      return false;
    }
  }

  private Boolean isPair(Hand hand, HandCombinations handCombinations) {
    if (hand.getCards().get(0).getValue().getVal().equals(hand.getCards().get(1).getValue().getVal())) {
      handCombinations.getListCombination().add(new Combination( CardCombination.PAIR, hand.getCards().get(0).getValue()));
      handCombinations.getListCombination().add(new Combination( CardCombination.HIGH_CARD, hand.getCards().get(2).getValue()));
      handCombinations.getListCombination().add(new Combination( CardCombination.HIGH_CARD, hand.getCards().get(3).getValue()));
      handCombinations.getListCombination().add(new Combination( CardCombination.HIGH_CARD, hand.getCards().get(4).getValue()));
      return true;
    } else if (hand.getCards().get(1).getValue().getVal().equals(hand.getCards().get(2).getValue().getVal())) {
      handCombinations.getListCombination().add(new Combination( CardCombination.PAIR, hand.getCards().get(1).getValue()));
      handCombinations.getListCombination().add(new Combination( CardCombination.HIGH_CARD, hand.getCards().get(0).getValue()));
      handCombinations.getListCombination().add(new Combination( CardCombination.HIGH_CARD, hand.getCards().get(3).getValue()));
      handCombinations.getListCombination().add(new Combination( CardCombination.HIGH_CARD, hand.getCards().get(4).getValue()));
      return true;
    } else if (hand.getCards().get(2).getValue().getVal().equals(hand.getCards().get(3).getValue().getVal())) {
      handCombinations.getListCombination().add(new Combination( CardCombination.PAIR, hand.getCards().get(2).getValue()));
      handCombinations.getListCombination().add(new Combination( CardCombination.HIGH_CARD, hand.getCards().get(0).getValue()));
      handCombinations.getListCombination().add(new Combination( CardCombination.HIGH_CARD, hand.getCards().get(1).getValue()));
      handCombinations.getListCombination().add(new Combination( CardCombination.HIGH_CARD, hand.getCards().get(4).getValue()));
      return true;
    } else if (hand.getCards().get(3).getValue().getVal().equals(hand.getCards().get(4).getValue().getVal())) {
      handCombinations.getListCombination().add(new Combination( CardCombination.PAIR, hand.getCards().get(3).getValue()));
      handCombinations.getListCombination().add(new Combination( CardCombination.HIGH_CARD, hand.getCards().get(0).getValue()));
      handCombinations.getListCombination().add(new Combination( CardCombination.HIGH_CARD, hand.getCards().get(1).getValue()));
      handCombinations.getListCombination().add(new Combination( CardCombination.HIGH_CARD, hand.getCards().get(2).getValue()));
      return true;
    } else {
      return false;
    }
  }

  private Boolean isHighCard(Hand hand, HandCombinations handCombinations) {
    handCombinations.getListCombination().add(new Combination( CardCombination.HIGH_CARD, hand.getCards().get(0).getValue()));
    handCombinations.getListCombination().add(new Combination( CardCombination.HIGH_CARD, hand.getCards().get(1).getValue()));
    handCombinations.getListCombination().add(new Combination( CardCombination.HIGH_CARD, hand.getCards().get(2).getValue()));
    handCombinations.getListCombination().add(new Combination( CardCombination.HIGH_CARD, hand.getCards().get(3).getValue()));
    handCombinations.getListCombination().add(new Combination( CardCombination.HIGH_CARD, hand.getCards().get(4).getValue()));
    return true;
  }

}
