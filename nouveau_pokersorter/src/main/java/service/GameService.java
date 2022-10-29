package service;

import exception.PokerException;
import model.Hand;
import model.HandCombinations;

import java.io.BufferedReader;
import java.io.IOException;

public class GameService
{
  public static final String PATHERN_STDIN = "([1-9TKQJA][DHSC]\\s){9}[1-9TKQJA][DHSC]";

  private Integer scorePlayer1 = 0;
  private Integer scorePlayer2 = 0;


  public  int[] playGame( BufferedReader reader) throws IOException, PokerException {
    GameService gameManager = new GameService();
    String currentLine = null;
    int[] score=new int[2];
    while ((currentLine = reader.readLine()) != null) {
     if(currentLine.trim().equals( "" )) continue;
      if (!currentLine.matches( GameService.PATHERN_STDIN)) {
        throw new PokerException("Problem when tryin to read the expression : " + currentLine);
      }

      int[] val= gameManager.playTour(currentLine);
      score[0]+=val[0];
      score[1]+=val[1];
    }
   gameManager.diplayScore();
    return score;
  }

  public  int[] playGame(String currentLine) throws PokerException
  {
    if (!currentLine.matches( GameService.PATHERN_STDIN)) {
      throw new PokerException("Problem when tryin to read the expression : " + currentLine);
    }
    GameService gameManager = new GameService();
    int[] score=gameManager.playTour(currentLine);
    gameManager.diplayScore();
    return score;
  }




  public int[] playTour(String cards) {
    Hand hand1 = new Hand(cards.substring(0,14));
    Hand hand2 = new Hand(cards.substring(15,29));
    PokerCombinationService pokerCombinationService = new PokerCombinationService();
    HandCombinations handCombinations1 = pokerCombinationService.getHandCombination(hand1);
    HandCombinations handCombinations2 = pokerCombinationService.getHandCombination(hand2);
    if (handCombinations1.compareTo(handCombinations2)>0) {
      scorePlayer1++;
    }else {
      scorePlayer2++;
    }
    return new int[]{scorePlayer1, scorePlayer2};
  }

  public void diplayScore() {
    System.out.println("Player 1: " + scorePlayer1);
    System.out.println("Player 2: " + scorePlayer2);
  }

}
