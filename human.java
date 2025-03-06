import java.util.Scanner;
import java.util.ArrayList;

class human extends Player{
    int myScore = 0 ;
    int handScore;
    ArrayList<Integer> otherScores;
    public human(String name){
        this.name=name;
        super.players.add(this);
    }
    public void wantsToRoll(){
        super.getInfo();
        boolean YesRoll =true;
        int pigPoints;
        while(YesRoll){
        System.out.println("Do you want to roll? (y/n)");
        if (scanner.nextLine().equals("y")){
            pigPoints = pigs.roll();
            if (pigPoints ==0){
                System.out.println("You lost all the points in the hand");
                YesRoll =false;
            }
            else{
                System.out.println("You rolled " + pigPoints + " points");
            }
        }
        }

    }
    public int getScore (){
        return myScore;
    }
    public int getHandScore (){
        return handScore;
    }
}