import java.util.ArrayList;


public class PassThePig{
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
                System.out.print("Bot roll ");
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
                System.out.print("Kev roll ");
                roll = pigs.roll();
                if (roll == 0){
                    System.out.println("You lost all the points in the hand");
                    canRoll = false;
                    handScore = 0;
                }
                else{
                    handScore += roll;
                    System.out.println("You rolled " + roll + " points. " + "Your hold " + handScore + " in your hand. You currently have " + (handScore + Kev.getScore()) + " scores");
                    if(handScore+Kev.getScore()>=100){
                        break;
                    }
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