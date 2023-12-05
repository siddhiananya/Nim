import java.util.Scanner;

public class GameRunner
{
  public static void main(String[] args)
  {
    System.out.println("Welcome to the Game of Nim!");

    // gets the users names
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter player 1 name:");
    String name1 = sc.nextLine();

    System.out.println();

    System.out.println("Enter player 2 name:");
    String name2 = sc.nextLine();

    Game nim = new Game(name1, name2); 
    nim.play();

    // allows for another game
    System.out.println();
    System.out.println("Do you want to play again? (y/n)");
    String choice = sc.nextLine();
    System.out.println();
    if (choice.equals("y")){
      Game redo = new Game(name1, name2);
      redo.play();
    } else {
        System.out.println("Thanks for playing!");
    }
    sc.close();
  }
}