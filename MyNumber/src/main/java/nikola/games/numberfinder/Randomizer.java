package nikola.games.numberfinder;

import java.util.ArrayList;
import java.util.Random;


public class Randomizer {
    public static ArrayList<Integer> giveTools (){
        ArrayList<Integer> numbers = new ArrayList<Integer>();

        for(int i = 1; i<5; i++){
            int num = giveOneToTen();
            numbers.add(num);
        }
            numbers.add(giveFive());
            numbers.add(giveTwentyFive());
            return numbers;
    }


    static int giveOneToTen (){
        Random r = new Random();
        int num = 1 + r.nextInt(9);

        return num;
    }

    static int giveFive (){
        Random r = new Random();
        int num = 5* (1 +r.nextInt(4));
        return num;

    }

    static int giveTwentyFive (){
        Random r = new Random();
        int num = 25* (1 +r.nextInt(4));
        return num;

    }


    static int giveGoal(){
        Random r = new Random();
        int num = (100+ r.nextInt(899));
        return num;

    }
}
