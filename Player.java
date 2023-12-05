public class Player {
  
  private String name;
  private int score;
  public Player(String name) {
    this.name = name;
    this.score = 0; //sets each players score to 0
  }
  // mutator methods
  public void setScore(int points) {
    score += points; 
  }
  // accessor methods
  public int getScore(){
    return score;
  }
  public String getName() {
    return name;
  }
}