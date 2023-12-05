//main code class

import java.util.Random;
import java.util.Scanner;

  public class Game
  {
    private Player player1;
    private Player player2;
    private int currentScore;
    private int paperClips;
    private String playerStart;

    public Game(String player1Name, String player2Name) {
      // creates two players
      player1 = new Player(player1Name); 
      player2 = new Player(player2Name);

      Random rand = new Random();
      paperClips = rand.nextInt(41) + 10; // chooses a random paperclip amount

      System.out.println();
      System.out.println("Hello and welcome to the game of nim, " + player1.getName() + " and " + player2.getName());
      System.out.println("To play Nim, begin with a set of piles containing a variable number of objects. Players take turns removing any desired quantity of objects from a single pile, with the goal of leaving the opponent with the last remaining object(s). The player who forces their opponent to take the final object wins the game.");
      System.out.println("You will also be provided a challenge called, Random Reduction. This challenge is set to a specific number between 1-10 and when its entered, a random amount of paper clips will be reduced rather than the number you put in");
      System.out.println();

      int temp = rand.nextInt(2); // chooses who goes first
      if (temp == 0) {
        playerStart = player1.getName();
      } else {
        playerStart = player2.getName();
      }
    }
    
    public void play(){
      
      Scanner scanner = new Scanner(System.in);
      
      while (paperClips != 0){ // continues till the last paperclip
        if (player1.getName() == playerStart){
          player1.setScore(currentScore);
          playerStart = player2.getName();
          currentScore = 0;
        } 
        else{
          player2.setScore(currentScore);
          playerStart = player1.getName();
          currentScore = 0;
        }
        // starts each terms
        System.out.println(playerStart + " goes with " + paperClips + " paper clips.");
        System.out.println(playerStart + ", how many paper clips do you want to remove? ");
        int removedPaperClips = scanner.nextInt();

        // updates paperclips and the score
        if (removedPaperClips <= (paperClips/2)){
          paperClips -= removedPaperClips;
          System.out.println();
          System.out.println("You have " + paperClips + " paperclips left.");
          currentScore += removedPaperClips; // updates score
        } else {
          System.out.println();
          System.out.println("You can't remove more than half of the paperclips.");
        }
        
        // determines if the game is over
        if (paperClips == 1){
          if (player1.getName() == playerStart){
            System.out.println();
            System.out.println(playerStart + " won with " + (player1.getScore() + currentScore) + " paperclips.");
            playerStart = player2.getName();
            currentScore = player2.getScore();
          } 
          else{
            System.out.println();
            System.out.println(playerStart + " won with " + (player2.getScore() + currentScore) + " paperclips.");
            playerStart = player1.getName();
            currentScore = player1.getScore();
          }
          System.out.println();
          System.out.println("Oh no!! " + playerStart + ", you have lost the game with a score of " + currentScore + ".");
          paperClips -= 1; // ends the loop
        }
        
        if ((removedPaperClips == 5) || (removedPaperClips == 2)) {
            int randomReduction = new Random().nextInt(paperClips / 2) + 1;
            paperClips -= randomReduction;
            currentScore += randomReduction;
            System.out.println();
            System.out.println(playerStart + " used Random Reduction! " + randomReduction + " paper clips were randomly removed.");
        }
    }
  }
}