package enumtype;

public enum CardSuit
{
  DIAMONDS("D"),
  HEARTS("H"),
  SPADES("S"),
  CLUBS("C");

  private final String suit;

  /**
   * @param suit
   */
  CardSuit( final String suit) {
    this.suit = suit;
  }

  /* (non-Javadoc)
   * @see java.lang.Enum#toString()
   */
  @Override
  public String toString() {
    return suit;
  }

  public static CardSuit valueOfLabel( String label) {
    for ( CardSuit e : values()) {
      if (e.suit.equals(label)) {
        return e;
      }
    }
    return null;
  }
}
