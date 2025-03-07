import java.util.ArrayList;
import java.util.Scanner;

class PassThePig{
    public static void main(String[] args) {
        int handScore =0;
        int roll;
        boolean canRoll = true;
        final int winningScore =100;
        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<Integer> otherScores = new ArrayList<Integer>();
        BotKev GenericBot = new BotKev("Generic Bot");
        Human Kev = new Human("Kev");
        Pigs pigs = new Pigs();
        players = GenericBot.getPlayers();
        while(true){
            while(GenericBot.wantsToRoll(GenericBot.getScore(),handScore, otherScores, winningScore)&&canRoll&&(GenericBot.getScore()+handScore)<100){
                    roll = pigs.roll();
                    if (roll == 0){
                        canRoll = false; 
                        handScore = 0;
                    }
                    else{
                        handScore += roll;
                        roll = 0;
                    }
                }
            GenericBot.addScore(handScore);
            handScore = 0;
            canRoll = true;
            if (GenericBot.getScore() >= 100){
                System.out.println("Winner is GenericBot");
                break;
            }
            for(int i = 0; i < players.size(); i++){
                if (players.get(i) instanceof BotKev){
                    BotKev bot = (BotKev) players.get(i);
                    System.out.print("| " + bot.getName() + ": " + bot.getScore() +" |");
                    otherScores.add(bot.getScore());
                }
                else{
                    Human man = (Human) players.get(i);
                    System.out.print("| " + man.getName() + ": " + man.getScore() +" |");
                    otherScores.add(man.getScore());
                }
            }
            while(canRoll&&Kev.wantsToRoll()){
                roll = pigs.roll();
                if (roll == 0){
                    System.out.println("You lost all the points in the hand");
                    canRoll = false; 
                    handScore = 0;
                }
                else{
                    handScore += roll;
                    System.out.println("You rolled " + roll + " points" + "Your hold " + handScore + " in your hand. You currently have " + (handScore + Kev.getScore()) + " scores");
                }
            }
            Kev.addScore(handScore);
            handScore = 0;
            canRoll = true;
            if (Kev.getScore() >= 100){
                System.out.println("Winner is Kev");
                break;
            }
        }
                
        for(int i = 0; i < players.size(); i++){
            if (players.get(i) instanceof BotKev){
                BotKev bot = (BotKev) players.get(i);
                System.out.print("| " + bot.getName() + ": " + bot.getScore() +" |");
                otherScores.add(bot.getScore());
            }
            else{
                Human man = (Human) players.get(i);
                System.out.print("| " + man.getName() + ": " + man.getScore() +" |");
                otherScores.add(man.getScore());
            }
        }
    }
}

class Player{
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

class Human extends Player{
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

class BotKev extends Player{
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
class Pigs{
    String pig1 ="pig";
    String pig2 = "pig";
    double possibility;
    int score = 0;
    int reset;
    public int roll(){
        possibility = Math.random();
        if (possibility <= 0.349){
            pig2 = "Dot";
            score += 1;
        }
        else if (possibility <= 0.651){
            pig2 = "No Dot";
            score += 1;
        }
        else if (possibility<=0.875){
            pig2 = "Razorback";
            score += 5;
        }
        else if (possibility <= 0.963){
            pig2 = "Trotter";
            score += 5;
        }
        else if (possibility <= 0.993){
            pig2 = "Snouter";
            score += 10;
        }
        else{
            pig2 = "Leaning Jowler";
            score += 15;
        }
        possibility = Math.random();
        if (possibility <= 0.349){
            pig2 = "Dot";
            score += 1;
        }
        else if (possibility <= 0.651){
            pig2 = "No Dot";
            score += 1;
        }
        else if (possibility <= 0.875){
            pig2 = "Razorback";
            score += 5;
        }
        else if (possibility <= 0.963){
            pig2 = "Trotter";
            score += 5;
        }
        else if (possibility <= 0.993){
            pig2 = "Snouter";
            score += 10;
        }
        else{
            pig2 = "Leaning Jowler";
            score += 15;
        }
        check();
        reset = score;
        score = 0;
        return reset;
    }

    public void check(){
        if (pig1.equals(pig2)){
            if (score == 2){
                score = 1;
            }
            else if (score == 10){
                score = 20;
            }
            else if (score == 20 ){
                score = 40;
            }
            else{
                score = 60;
            }
        }
        else if(score == 2){
            score = 0;
        }
    }
}