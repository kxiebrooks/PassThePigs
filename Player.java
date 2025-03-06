import java.util.ArrayList;

class Player{
    private String name;
    private String strategy;
    private int handScore = pigs.roll();
    private Arraylist<Integer> otherScores = new ArrayList<Integer>();
    private int highestScore =0;
    public static ArrayList<Player> players = new ArrayList<Player>();
    public final int winningScore = 100;
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
    public ArrayList<Integer> getOtherScores(Player a){
        for (int i=0; i< players.size(); i++){
            if (player.get(i) == a){
                i++;
            }
            else{
                otherScores.set(i, players.get(i).myscore());
            }
        }
        return otherScores;
    }
    public void getInfo(Player a){
        for(int i=0; i<players.size(); i++){
            System.out.print("| " + player.get(i).getName() + ": " + player.get(i).getScore() +" |");
        }
        System.out.println("You currentlly hold " + a.getHandScore());
        System.out.println("The winning score is " + winningScore);
    }
    public int getHighestScore(){
        for(int i=0; i<players.size(); i++){
            if (player.get(i).getScore+player.get(i).getHandScore>highestScore){
                highestScore = player.get(i).getScore+player.get(i).getHandScore;
            }
        }
    }
    public int getWinScore(){
        return winningScore();
    }
}

