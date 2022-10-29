import model.Hand;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import service.PlayerHandService;

public class TestPlayerHandService
{
  @Test
  public void TestPayerHandSorting()
  {
    //String card = "AH 9S 4D TD 8S 4H JS 3C TC 8D";
    Hand input=new Hand(  "AH 9S 4D TD 8S");
    PlayerHandService p1=new PlayerHandService();
    input=p1.sortHand( input );
    Hand expected=new Hand( "4D 8S 9S TD AH" );
    Assertions.assertEquals(input.toString(),expected.toString()  );
  }

}
