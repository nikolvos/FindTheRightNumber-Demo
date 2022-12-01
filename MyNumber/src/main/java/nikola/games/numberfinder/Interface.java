package nikola.games.numberfinder;

import java.util.ArrayList;
import java.util.Scanner;

public class Interface {
    public static void menu() {
        System.out.println("NUMBERS GAME");
        ArrayList<Integer> tools = Randomizer.giveTools();
        int goal = Randomizer.giveGoal();
        System.out.println("USE THE FOLLOWING NUMBERS " + tools + " TO GET :" + goal);
        Scanner sc = new Scanner(System.in);
        String solution = sc.nextLine();

        if (AntiCheatSystem.checkForLetters(solution) == false) {
            System.err.println("Solution can't contain letters");
            System.exit(1);
        }

        if (AntiCheatSystem.checkUsedNumbers(solution, tools) == false) {
            System.exit(1);
        }

        if (AntiCheatSystem.checkSolution(solution, goal)) {
            System.out.println(solution + " = " + goal + "\u001B[32m" + " CONGRATULATIONS! YOU FOUND THE SOLUTION");
        } else {
            System.err.println("INCORRECT, you got " + Calculator.calculate(solution) + "instead of " + goal);
        }
    }
}