import java.util.Scanner;

import java.util.ArrayList;

class Human extends Player{
    int myScore = 0 ;
    int handScore;
    Scanner scanner = new Scanner(System.in);
    String name;
    ArrayList<Integer> otherScores;
    public Human(String name){
        super(name);
        this.name=name;
        super.players.add(this);
    }
    public boolean wantsToRoll(){
        super.getInfo(this);
        boolean YesRoll =true;
        int pigPoints;
        while(YesRoll){
        System.out.println("Do you want to roll? (y/n)");
        if (scanner.nextLine().equals("y")){
            return true;
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
    public void addScore(){
        myScore+=handScore;
        handScore =0;
    }
}