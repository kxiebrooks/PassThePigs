import java.util.ArrayList;

class botKev extends Player{
    int myScore = 0;
    int handScore = 0;
    String strategy;
    ArrayList<Integer> otherScores
    public botKev(String name, String strategy){
        this.name = name;
        super.players.add(this);
        this.strategy = strategy;
    }
    public void wantsToRoll(){
        boolean YesRoll =true;
        handScoreBefore = handScore;
        ArrayList<Integer> otherScores = getOtherScores(this);
        super.getInfo();
        while (YesRoll){
        if (stratagy.equals("risky")()){
            YesRoll=stratagyRisky();
        }
        else if (stratagy.equals("moderate")()){
            YesRoll=stratagyModerate());
        }
        else{
            YesRoll=stratagyCautious();
        }
        if (YesRoll){
            handScore+=pigs.roll();
            if (handScoreBefore==handScore){
                handScore=0;
            }
        }
        else{
            myScore+=handScore;
            YesRoll=false;
        }
        }
    }

    public int getScore (){
        return myScore;
    }
    public int getHandScore (){
        return handScore;
    }

    public int checkotherScores(){
        int highestScore = 0;
        for (i=0; i< otherScores.size(); i++){
            if (otherScores.get(i)>highestScore){
                highestScore = otherScores.get(i);
            }
        } 
        return highestScore;
    }

    public boolean stratagyRisky(){
         if ((winningScore - myScore - handScore) <= 50){
            return true;
        }
        else if((100 - checkotherScores()) <= 50){
            return true;
        }
        else if(handScore>=50){
            return false;
        }
    }
    public boolean stratagyModerate(){
         if ((winningScore - myScore - handScore) <= 20){
            return true;
        }
        else if((100 - checkotherScores()) <= 25){
            return true;
        }
        else if(handScore>=30){
            return false;
        }
        return true;
    }
    public boolean stratagyCautious(){
         if ((winningScore - myScore - handScore) <= 10){
            return true;
        }
        else if((100 - checkotherScores()) <= 10){
            return true;
        }
        else if(handScore>=15){
            return false;
        }
        return true;
    }
}