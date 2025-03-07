import java.util.ArrayList;

public class BotKev extends Player{
    int myScore = 0;
    int handScore = 0;
    int highestScore = 0;
    int winningScore;
    public BotKev(String name){
        super (name);
        Player.players.add(this);
    }
    public boolean wantsToRoll(int myScore, int handScore, ArrayList<Integer> otherScores, int winningScore){
        this.myScore = myScore; 
        this.handScore = handScore;
        highestScore = getHighestScores(otherScores);
        this.winningScore = winningScore;
        return strategyRisky();
    }
    public int getScore (){
        return myScore;
    }
    public int getHandScore (){
        return handScore;
    }
    public int getHighestScores(ArrayList<Integer> otherScores){
        int highestScore = 0;
        for (int i = 0; i< otherScores.size(); i++){
            if (otherScores.get(i) > highestScore){
                highestScore = otherScores.get(i);
            }
        } 
        return highestScore;
    }

    public boolean strategyRisky(){
        if((winningScore - highestScore) <= 15){
            return true;
        }
        else if(handScore >= 10){
            return false;
        }
        else if ((winningScore - myScore - handScore) <= 10){
            return true;
        }
        return true;
    }
    public ArrayList<Player> getPlayers(){
        return Player.players;
    }
    public void addScore(int score){
        myScore += score;
        handScore = 0;
    }
}