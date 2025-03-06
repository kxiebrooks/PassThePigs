import java.util.ArrayList;

class Player{
    private String name;
    private String strategy;
    private int handScore;
    private ArrayList<Integer> otherScores = new ArrayList<Integer>();
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
            if (players.get(i) == a){
                i++;
            }
            else{
                if (players.get(i) instanceof BotKev){
                     otherScores.set(i, ((BotKev)players.get(i)).getScore());
                }
                else{
                    otherScores.set(i, ((Human)players.get(i)).getScore());
                }
            }
        }
        return otherScores;
    }
    public void getInfo(Player a){
        for(int i=0; i<players.size(); i++){
            if (players.get(i) instanceof BotKev){
                     System.out.print("| " + ((BotKev)players.get(i)).getName() + ": " + ((BotKev)players.get(i)).getScore() +" |");
            }
            else{
                 System.out.print("| " + ((Human)players.get(i)).getName() + ": " + ((Human)players.get(i)).getScore() +" |");
            }
        }
        if (a instanceof BotKev) {
            System.out.println("You currentlly hold " + ((BotKev)a).getHandScore());
        }
        else{
            System.out.println("You currentlly hold " + ((Human)a).getHandScore());
        }
        System.out.println("The winning score is " + winningScore);
    }
    public int getHighestScore(){
        for(int i=0; i<players.size(); i++){
            if (players.get(i) instanceof BotKev){
                if (((BotKev)players.get(i)).getScore() + ((BotKev)players.get(i)).getHandScore() > highestScore){
                    highestScore = ((BotKev)players.get(i)).getScore() + ((BotKev)players.get(i)).getHandScore();
                }
            }
            else{
                if (((Human)players.get(i)).getScore() + ((Human)players.get(i)).getHandScore() > highestScore){
                    highestScore = ((Human)players.get(i)).getScore() + ((Human)players.get(i)).getHandScore();
                }
            }
        }
    }
    public int getWinScore(){
        return winningScore;
    }
}

