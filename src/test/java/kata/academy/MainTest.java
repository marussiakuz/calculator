package kata.academy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @ParameterizedTest
    @CsvSource({"I+III, IV", "III - II, I", "X - V, V", "X *X, C", "X* IX, XC", "X + X, XX", "VI / IV, I"})
    void calcWhenOperationBetweenRomanThanReturnRoman(String input, String output) {
        assertEquals(Main.calc(input), output);
    }

    @ParameterizedTest
    @CsvSource({"9+9, 18", "2-10, -8", "1 - 10, -9", "10 * 10, 100", "10/ 8, 1", "1 / 10, 0"})
    void calcWhenOperationBetweenArabicThanReturnArabic(String input, String output) {
        assertEquals(Main.calc(input), output);
    }

    @ParameterizedTest
    @CsvSource({"I + 3", "9 - I", "XI - V", "11 + 1", "0 + 6", "1 + 2 + 3", "8 % 2", "V", "111" ,"1 ++ 7", "1 +/ 7"})
    void calcWhenIncorrectInputThenThrowCalculationException(String input) {
        CalculationException ex = assertThrows(CalculationException.class, () ->
                Main.calc(input));
        assertEquals("The expression doesn't follow the rules", ex.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"V - VII", "X - X"})
    void calcWhenOperationBetweenRomanAndResultIsLessThan1ThenThrowIncorrectRomanNumericException(String input) {
        IncorrectRomanNumericException ex = assertThrows(IncorrectRomanNumericException.class, () ->
                Main.calc(input));
        assertEquals("There are no negative numbers and zero in the Roman system", ex.getMessage());
    }
}