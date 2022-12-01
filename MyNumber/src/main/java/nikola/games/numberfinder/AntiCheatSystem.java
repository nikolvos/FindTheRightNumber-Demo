package nikola.games.numberfinder;

import java.util.ArrayList;

public class AntiCheatSystem {
    //AntiCheatSystem checks if the solution uses only the numbers given by the randomizer, numbers cant be repeated
    public static boolean checkForLetters(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkUsedNumbers(String s, ArrayList<Integer> numbers) {
        ArrayList<Integer> tools = numbers;
        boolean key = true;
        ArrayList<Integer> usedNumbers = numberSorter(s);
        for (int i = 0; i < usedNumbers.size(); i++) {
            int remove = -1;
            int com = usedNumbers.get(i);
            if (tools.contains(com)) {
                for (int j = 0; j < tools.size(); j++) {
                    if (com == tools.get(j)) {
                        remove = j;
                    }
                }
                if (remove != -1) tools.remove(remove);
            } else {
                System.err.println("WRONG NUMBERS");
                key = false;
            }
        }
        if (key) {
            System.out.println("numbers good");
        }
        return key;
    }

    public static boolean checkSolution(String s, int solution) {
        boolean key = true;
        if (Calculator.calculate(s) != solution) {
            key = false;
        }
        return key;
    }

    public static ArrayList<Integer> numberSorter(String s) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            StringBuilder num = new StringBuilder();
            if (Character.isDigit(s.charAt(i))) {
                num.append(s.charAt(i));
                try {
                    if (Character.isDigit(s.charAt(i + 1))) {
                        num.append(s.charAt(i + 1));
                        if (Character.isDigit(s.charAt(i + 2))) {
                            num.append(s.charAt(i + 2));
                        }
                    }
                } catch (Exception e) {}
                int number = Integer.parseInt(num.toString());
                numbers.add(number);
                if (number > 99) {
                    i++;
                    i++;
                } else if (number > 9) {
                    i++;
                }
            }
        }
        return numbers;
    }
}