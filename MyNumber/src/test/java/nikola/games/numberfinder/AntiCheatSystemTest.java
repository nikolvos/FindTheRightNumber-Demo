package nikola.games.numberfinder;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AntiCheatSystemTest {
    @Test
    void checkForLetters() {
        assertEquals(false, AntiCheatSystem.checkForLetters("sss"));
        assertEquals(true, AntiCheatSystem.checkForLetters("20+3-2/1"));
    }

    @Test
    void checkUsedNumbers() {
        var integers = new ArrayList<Integer>();
        integers.add(20);
        integers.add(3);
        integers.add(1);
        assertEquals(true, AntiCheatSystem.checkUsedNumbers("20+3-1", integers));
        assertEquals(false, AntiCheatSystem.checkUsedNumbers("20+20-1", integers));
    }

    @Test
    void checkSolution() {
        assertEquals(true, AntiCheatSystem.checkSolution("20+20", 40));
        assertEquals(true, AntiCheatSystem.checkSolution("20-20", 0));
        assertEquals(true, AntiCheatSystem.checkSolution("20-20+2+3", 5));
        assertEquals(true, AntiCheatSystem.checkSolution("20*20", 400));
        assertEquals(true, AntiCheatSystem.checkSolution("20/20", 1));
        assertEquals(false, AntiCheatSystem.checkSolution("1+1", 3));
    }

    @Test
    void numberSorter() {
        var integers = new ArrayList<Integer>();
        integers.add(30);
        integers.add(20);
        integers.add(2);
        integers.add(9);
        assertEquals(integers, AntiCheatSystem.numberSorter("30-20+2-9"));
    }
}