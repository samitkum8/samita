package service;

import comparator.SortCardByValue;
import model.Hand;

public class PlayerHandService
{
  public PlayerHandService() {
  }

  public static Hand sortHand( Hand hand) {
    hand.getCards().sort( new SortCardByValue() );
    return hand;
  }

}
