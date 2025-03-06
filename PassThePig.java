
class PassThePig{
    public static void main(String[] args) {
        int handscore =0;
        boolean canRoll =true;
        BotKev GenericBot = new BotKev("Generic Bot", "risky");
        // botKev SchemerBot = new botKev("SchemerBot", "moderate");
        // botKev RiskyBot = new botKev("RiskyBot", "cautious");
        Human Kev = new Human("Kev");
        Player player1 = new Player("1");

        Pigs pigs = new Pigs();
        pigs.roll();

        while (player1.getHighestScore() < player1.getWinScore()){
            // RiskyBot.wantsToRoll();
            // SchemerBot.wantsToRoll();
            while(GenericBot.wantsToRoll()&&canRoll){
            handscore = pigs.roll();
            if (handscore==0){
                System.out.println("You lost all the points in the hand");
               canRoll =false; 
            }
        }
        GenericBot.addScore();
        handscore=0;
        canRoll=true;
        
        while(Kev.wantsToRoll()&&canRoll){
            handscore = pigs.roll();
            if (handscore==0){
                System.out.println("You lost all the points in the hand");
               canRoll =false; 
            }
        }
        Kev.addScore();
        handscore=0;
        canRoll=true;
            
        }
    }
}