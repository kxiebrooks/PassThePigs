class pigs{
    String pig1;
    String pig2;
    int possibility;
    public int roll(){
        possibility = Math.random();
        if (possibility<=0.349){
            pig1 = "Dot";
        }
        else if (possibility<=0.651){
            pig1 = "No Dot";
        }
        else if (possibility<=0.875){
            pig1 = "Razorback";
        }
        else if (possibility<=0.963){
            pig1 = "Trotter";
        }
        else if (possibility<=0.993){
            pig1 = "Snouter";
        }
        else{
            pig1 ="Leaning Jowler";
        }
        possibility = Math.random();
        if (possibility<=0.349){
            pig2 = "Dot";
        }
        else if (possibility<=0.651){
            pig2 = "No Dot";
        }
        else if (possibility<=0.875){
            pig2 = "Razorback";
        }
        else if (possibility<=0.963){
            pig2 = "Trotter";
        }
        else if (possibility<=0.993){
            pig2 = "Snouter";
        }
        else{
            pig2 ="Leaning Jowler";
        }
        return check();
    }
    public int check(){
        int score;
        if pig1.equals(pig2){
            if pig1.equals("Dot"){
                return 1;
            }
            if pig1.equals("No Dot"){
                return 1;
            }
            if pig1.equals("Razorback"){
                return 20;
            }
            if pig1.equals("Trotter"){
                return 20;
            }
            if pig1.equals("Snouter"){
                return 40;
            }
            if pig1.equals("Leaning Jowler"){
                return 60;
            }
        }
        else if((pig1.equals("Dot")&&pig2.equals("No Dot"))||(pig2.equals("Dot")&&pig1.equals("No Dot")) ){
            return 0;
        }
        if(pig1.equals("Dot")||pig1.equals("No Dot")){
            score++;
        }
        if(pig1.equals("Trotter")||pig1.equals("Razorback")){
            score+=5;
        }
        if(pig1.equals("Snouter")){
            score+=10;
        }
        if(pig1.equals("Leaning Jowler")){
            score+=15;
        }
        if(pig2.equals("Dot")||pig2.equals("No Dot")){
            score++;
        }
        if(pig2.equals("Trotter")||pig2.equals("Razorback")){
            score+=5;
        }
        if(pig2.equals("Snouter")){
            score+=10;
        }
        if(pig2.equals("Leaning Jowler")){
            score+=15;
        }
        return score;
    }

    ArrayList<Integer> players;
    ArrayList<Integer> otherScores;
}