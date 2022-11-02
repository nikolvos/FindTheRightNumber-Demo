import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void calculate() {
        assertEquals(323,Calculator.calculate("150*2+25-2"));
        assertEquals(256,Calculator.calculate("50*10/2+8*2-10"));



    }
}