package model;

import enumtype.CardSuit;
import enumtype.CardValue;

public class Card
{
  private CardSuit suits;

  private CardValue value;

  public Card(String card) {
    value = CardValue.valueOfLabel(card.substring(0,1));
    suits = CardSuit.valueOfLabel(card.substring(1,2));
  }

  public Card( CardSuit suits, CardValue value) {
    this.suits = suits;
    this.value = value;
  }

  @Override
  public String toString()
  {
    return "Card{" +
            "suits=" + suits +
            ", value=" + value +
            '}';
  }

  public CardSuit getSuits() {
    return suits;
  }

  public CardValue getValue() {
    return value;
  }

  public boolean valueEquals( CardValue v) {
    return value.getVal().equals(v.getVal());
  }

}
