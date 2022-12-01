package nikola.games.numberfinder;

import java.util.ArrayList;
import java.util.Scanner;

public class Interface {
    public static void menu() {
        System.out.println("Numbers Game");
        ArrayList<Integer> tools = Randomizer.giveTools();
        int goal = Randomizer.giveGoal();
        System.out.println("Use the following numbers " + tools + " to get :" + goal);
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
            System.out.println(solution + " = " + goal + "\u001B[32m" + " congratulations! You found the solution");
        } else {
            System.err.println("Incorrect, you got " + Calculator.calculate(solution) + "instead of " + goal);
        }
    }
}