package comparator;

import model.Combination;

import java.util.Comparator;

public class SortCombinationByRank implements Comparator<Combination>
{

  // reverse
  public int compare(Combination o2, Combination o1) {
    if (o1.getName().equals(o2.getName())) {
      return o1.getValue().getVal().compareTo(o2.getValue().getVal());
    }else {
      return o1.getName().getRank().compareTo(o2.getName().getRank());
    }
  }
}

