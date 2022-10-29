package model;

import java.util.ArrayList;
import java.util.List;

public class HandCombinations implements Comparable<HandCombinations> {

  private List<Combination> listCombination;


  @Override
  public String toString()
  {
    return "HandCombinations{" +
            "listCombination=" + listCombination +
            '}';
  }

  public HandCombinations() {
    this.listCombination = new ArrayList<>();
  }

  public List<Combination> getListCombination() {
    return listCombination;
  }

  public void setListCombination(List<Combination> listCombination) {
    this.listCombination = listCombination;
  }

  @Override
  public int compareTo(HandCombinations o) {
    for(int i=0; i<listCombination.size();i++) {
      if (!listCombination.get(i).equals(o.getListCombination().get(i))) {
        return listCombination.get(i).compareTo(o.getListCombination().get(i));
      }
    }
    return 0;
  }
}
