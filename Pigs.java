class Pigs{
    String pig1;
    String pig2;
    double possibility;
    int score;
    public int roll(){
        possibility = Math.random();
        if (possibility<=0.349){
            pig2 = "Dot";
            score +=1;
        }
        else if (possibility<=0.651){
            pig2 = "No Dot";
            score+=1;
        }
        else if (possibility<=0.875){
            pig2 = "Razorback";
            score+=5;
        }
        else if (possibility<=0.963){
            pig2 = "Trotter";
            score+=5;
        }
        else if (possibility<=0.993){
            pig2 = "Snouter";
            score+=10;
        }
        else{
            pig2 ="Leaning Jowler";
            score+=15;
        }
        possibility = Math.random();
        if (possibility<=0.349){
            pig2 = "Dot";
            score +=1;
        }
        else if (possibility<=0.651){
            pig2 = "No Dot";
            score+=1;
        }
        else if (possibility<=0.875){
            pig2 = "Razorback";
            score+=5;
        }
        else if (possibility<=0.963){
            pig2 = "Trotter";
            score+=5;
        }
        else if (possibility<=0.993){
            pig2 = "Snouter";
            score+=10;
        }
        else{
            pig2 ="Leaning Jowler";
            score+=15;
        }
        check();
        return score;
    }
    public void check(){
        if (pig1.equals(pig2)){
            if (score ==2){
                score =1;
            }
            else if (score ==10){
                score =20;
            }
            else if (score ==20 ){
                score =40;
            }
            else{
                score =60;
            }
        }
        else if(score ==2){
            score =0;
        }
    }
}