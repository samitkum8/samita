package enumtype;

public enum CardValue
{
  TWO("2",2),
  THREE("3",3),
  FOUR("4",4),
  FIVE("5",5),
  SIX("6",6),
  SEVEN("7",7),
  EIGHT("8",8),
  NINE("9",9),
  TEN("T",10),
  JACK("J",11),
  QUEEN("Q",12),
  KING("K",13),
  ACE("A",14);


  private final String text;

  private final Integer val;

  /**
   * @param text
   */
  CardValue( final String text, Integer val) {
    this.text = text;
    this.val=val;
  }

  /* (non-Javadoc)
   * @see java.lang.Enum#toString()
   */
  @Override
  public String toString() {
    return text;
  }

  public Integer getVal() {
    return val;
  }

  public static CardValue valueOfLabel( String label) {
    for ( CardValue e : values()) {
      if (e.text.equals(label)) {
        return e;
      }
    }
    return null;
  }

}
