package nikola.games.numberfinder;

import jdk.jshell.JShell;

public class Calculator {
    public static int calculate(String s) {
        int solution = 0;
        JShell js = JShell.builder().build();
        String sol = (js.eval(s).get(0).value());
        solution = Integer.parseInt(sol);
        return solution;
    }
}
