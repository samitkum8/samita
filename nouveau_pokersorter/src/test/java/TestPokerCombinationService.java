import enumtype.CardCombination;
import enumtype.CardValue;
import model.Combination;
import model.Hand;
import model.HandCombinations;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import service.PokerCombinationService;

import java.util.ArrayList;
import java.util.List;

public class TestPokerCombinationService
{
  @Test
  public void TestPayerHandCombination()
  {
    //String card = "AH 9S 4D TD 8S 4H JS 3C TC 8D";
    Hand input=new Hand(  "AH 9S 4D TD 8S");
    PokerCombinationService pokerCombinationService=new PokerCombinationService();
    HandCombinations handCombinations=pokerCombinationService.getHandCombination( input );
    List<Combination> listCombination=new ArrayList<>();
    listCombination.add(new Combination( CardCombination.HIGH_CARD, CardValue.ACE ));
    listCombination.add(new Combination( CardCombination.HIGH_CARD, CardValue.TEN ));
    listCombination.add(new Combination( CardCombination.HIGH_CARD, CardValue.NINE ));
    listCombination.add(new Combination( CardCombination.HIGH_CARD, CardValue.EIGHT ));
    listCombination.add(new Combination( CardCombination.HIGH_CARD, CardValue.FOUR ));
    HandCombinations expected=new HandCombinations();
    expected.setListCombination( listCombination );
    Assertions.assertEquals( handCombinations.toString(),expected.toString() );

  }
}
