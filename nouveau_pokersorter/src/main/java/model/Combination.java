package model;

import enumtype.CardCombination;
import enumtype.CardValue;

import java.util.Objects;

public class Combination implements Comparable<Combination>
{
  @Override
  public String toString()
  {
    return "Combination{" +
            "name=" + name +
            ", value=" + value +
            '}';
  }

  private CardCombination name;

  private CardValue value;

  public Combination( CardCombination name, CardValue value )
  {
    this.name = name;
    this.value = value;
  }

  public CardCombination getName()
  {
    return name;
  }

  public void setName( CardCombination name )
  {
    this.name = name;
  }

  public CardValue getValue()
  {
    return value;
  }

  public void setValue( CardValue value )
  {
    this.value = value;
  }


  public int compareTo( Combination o )
  {
    if ( this.getName().getRank().equals( o.getName().getRank() ) )
    {
      return this.getValue().getVal().compareTo( o.getValue().getVal() );
    }
    else
    {
      return this.getName().getRank().compareTo( o.getName().getRank() );
    }
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
    Combination that = (Combination) o;
    return name.getRank().equals( that.name.getRank() ) &&
            value.equals( that.value );
  }

  @Override
  public int hashCode()
  {
    return Objects.hash( name, value );
  }

}
