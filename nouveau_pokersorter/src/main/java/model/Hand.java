package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Hand
{
  private List<Card> cards = null;


  @Override
  public String toString()
  {
    return "Hand{" +
            "cards=" + cards +
            '}';
  }

  public Hand( String card) {
    cards = new ArrayList<>();
    cards.add(new Card(card.substring(0,2)));
    cards.add(new Card(card.substring(3,5)));
    cards.add(new Card(card.substring(6,8)));
    cards.add(new Card(card.substring(9,11)));
    cards.add(new Card(card.substring(12,14)));
  }


  public List<Card> getCards() {
    return cards;
  }

  public void setCards(List<Card> cards) {
    this.cards = cards;
  }

  @Override
  public boolean equals( Object o )
  {
    if ( this == o )
    {
      return true;
    }
    if ( o == null || getClass() != o.getClass() )
    {
      return false;
    }
    Hand hand = (Hand) o;
    return Objects.equals( cards, hand.cards );
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( cards );
  }
}
