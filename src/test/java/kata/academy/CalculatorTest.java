package kata.academy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @ParameterizedTest
    @CsvSource({"10, DIVIDE, 4, 2", "7, MINUS, 9, -2", "1, ADD, 10, 11", "9, MULTIPLY, 8, 72"})
    void calculateWhenAddThenReturnValidResult(int a, String operation, int b, int result) {
        assertEquals(Calculator.calculate(a, Operation.valueOf(operation), b).getValue(), result);
    }

    @Test
    void calculateWhenTryToDivideOnZeroThenThrowsCalculationException() {
        CalculationException ex = assertThrows(CalculationException.class, () ->
                Calculator.calculate(10, Operation.DIVIDE, 0));
        assertEquals("Division by zero", ex.getMessage());
    }
}