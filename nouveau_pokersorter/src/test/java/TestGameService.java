import org.junit.After;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import service.GameService;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.Arrays;

public class TestGameService
{
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private final PrintStream originalErr = System.err;

  @BeforeEach
  public void setUp()
  {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
  }


  @After
  public void restoreStreams() {
    System.setOut(originalOut);
    System.setErr(originalErr);
  }

  @Test
  public void TestPlayGame()
  {
    String test = "7S 8S AC KD AH 5D TC 6D 7H 3S";
    Reader inputString = new StringReader(test);
   // BufferedReader reader = new BufferedReader(inputString);
    GameService gameService=new GameService();
    Assertions.assertEquals(  Arrays.toString( gameService.playGame( test ) ),"[1, 0]");

  }

  @Test
  public void TestPlayGameBufferedReaderInput() throws IOException
  {
    String test = "7S 8S AC KD AH 5D TC 6D 7H 3S";
    Reader inputString = new StringReader(test);
     BufferedReader reader = new BufferedReader(inputString);
    GameService gameService=new GameService();
    Assertions.assertEquals(  Arrays.toString( gameService.playGame( reader ) ),"[1, 0]");

  }

  @Test
  public void TestPlayTour()
  {
    String cards = "AH 9S 4D TD 8S 4H JS 3C TC 8D";
    GameService gameService=new GameService();
    Assertions.assertEquals( Arrays.toString(gameService.playTour( cards )  ),"[1, 0]");
  }

}
