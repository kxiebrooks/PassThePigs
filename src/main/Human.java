import java.util.Scanner;

public class Human extends Player{
    int myScore = 0;
    Scanner scanner = new Scanner(System.in);
    public Human(String name){
        super(name);
        Player.players.add(this);
    }
    public boolean wantsToRoll(){
        boolean YesRoll;
        System.out.println("Do you want to roll? (y/n)");
        if (scanner.nextLine().equals("y")){
            YesRoll = true;
        }
        else{
            YesRoll = false;
        }
        return YesRoll;
    }
    public int getScore (){
        return myScore;
    }
    public void addScore(int score){
        myScore += score;
    }
}