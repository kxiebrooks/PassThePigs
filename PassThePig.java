import java.util.Scanner;

class PassThePig{
    public static void main(String[] args){
        botKev GenericBot = new Player("Generic Bot", "risky");
        botKev SchemerBot = new Player("SchemerBot", "moderate");
        botKev RiskyBot = new botKev("RiskyBot", "cautious");
        human Kev = new human("Kev");
        Player player1 = new Player("1");

        while (player1.getHighestScore() < player1.getWinScore){
            RiskyBot.wantsToRoll();
            SchemerBot.wantsToRoll();
            GenericBot.wantsToRoll();
            Kev.wantsToRoll();
        }
    }
}