package comparator;

import model.Card;

import java.util.Comparator;

public class SortCardByValue implements Comparator<Card>
{
  public int compare( Card o1, Card o2 )
  {
    return o1.getValue().getVal().compareTo( o2.getValue().getVal() );
  }

}
