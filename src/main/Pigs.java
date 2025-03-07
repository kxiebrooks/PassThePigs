public class Pigs{
    String pig1;
    String pig2;
    double possibility;
    int score = 0;
    int reset;
    public int roll(){
        possibility = Math.random();
        if (possibility <= 0.349){
            pig2 = "Dot";
            System.out.print("a Dot and a ");
        }
        else if (possibility <= 0.651){
            pig2 = "No Dot";
            System.out.print("a No Dot and a ");
        }
        else if (possibility<=0.875){
            pig2 = "Razorback";
            score += 5;
            System.out.print("a Razorback and a ");
        }
        else if (possibility <= 0.963){
            pig2 = "Trotter";
            score += 5;
            System.out.print("a Trotter and a ");
        }
        else if (possibility <= 0.993){
            pig2 = "Snouter";
            score += 10;
            System.out.print("a Snouter and a ");
        }
        else{
            pig2 = "Leaning Jowler";
            score += 15;
            System.out.print("a Leaning Jowler and a ");
        }
        possibility = Math.random();
        if (possibility <= 0.349){
            pig1 = "Dot";
            System.out.println("Dot");
        }
        else if (possibility <= 0.651){
            pig1 = "No Dot";
            System.out.println("No Dot");
        }
        else if (possibility <= 0.875){
            pig1 = "Razorback";
            score += 5;
            System.out.println("Razorback");
        }
        else if (possibility <= 0.963){
            pig1 = "Trotter";
            score += 5;
            System.out.println("Trotter");
        }
        else if (possibility <= 0.993){
            pig1 = "Snouter";
            score += 10;
            System.out.println("Snouter");
        }
        else{
            pig1 = "Leaning Jowler";
            score += 15;
            System.out.println("Leaning Jowler");
        }
        check();
        reset = score;
        score = 0;
        return reset;
    }
    public void check(){
        if (pig1.equals(pig2)){
            if (score == 0){
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
    }
}