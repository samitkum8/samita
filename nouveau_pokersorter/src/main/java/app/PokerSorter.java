package app;

import exception.IllegalFileTypeException;
import service.GameService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PokerSorter
{
  public static void main( String[] args ) throws IOException
  {
    if (args[0].endsWith(".txt")) {
      if(args[0].equals( ".txt" )) throw new IllegalFileTypeException();
      BufferedReader reader = new BufferedReader(new FileReader(args[0]));
      GameService gameService=new GameService();
      gameService.playGame(reader);
      reader.close();
    }else {
      GameService gameService=new GameService();
      gameService.playGame(args[0]);
    }
    /*String filename="/home/sakumari/nouveau_pokersorter/src/main/java/resource/poker-hands";
    BufferedReader reader = new BufferedReader(new FileReader(filename));
    GameService.playGame(reader);
    reader.close();
    */
  }
}
