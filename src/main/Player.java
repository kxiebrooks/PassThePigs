import java.util.ArrayList;

public class Player{
    private String name;
    private String strategy;
    public static ArrayList<Player> players = new ArrayList<Player>();
    public Player(String name){
        this.name = name;
    }
    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore){
        return true;
    }
    public String getName(){
        return name;
    }
    public String getStrategy(){
        return strategy;
    }
}