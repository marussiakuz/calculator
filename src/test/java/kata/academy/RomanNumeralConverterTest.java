package kata.academy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralConverterTest {

    @ParameterizedTest
    @CsvSource({"1, I", "2, II", "3, III", "4, IV", "5, V", "6, VI", "7, VII", "8, VIII", "9, IX", "10, X",
            "99, XCIX", "45, XLV", "30, XXX", "69, LXIX", "33, XXXIII", "55, LV", "100, C"})
    void arabicToRomanWhenArabicPositiveThanConvertToRoman(int arabic, String roman) {
        assertEquals(RomanNumeralConverter.arabicToRoman(arabic), roman);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void arabicToRomanWhenArabicLessThanOneThenThrowsIncorrectRomanNumericException(int arabic) {
        IncorrectRomanNumericException ex = assertThrows(IncorrectRomanNumericException.class, () ->
                RomanNumeralConverter.arabicToRoman(arabic));
        assertEquals("There are no negative numbers and zero in the Roman system", ex.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {101, 111})
    void arabicToRomanWhenArabicMoreThan100ThenThrowsCalculationException(int arabic) {
        CalculationException ex = assertThrows(CalculationException.class, () ->
                RomanNumeralConverter.arabicToRoman(arabic));
        assertEquals("conversion of roman numerals greater than 100 isn't supported", ex.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"I, 1", "II, 2", "III, 3", "IV, 4", "V, 5", "VI, 6", "VII, 7", "VIII, 8", "IX, 9", "X, 10"})
    void romanToArabicWhenRomanFromIToXThenReturnArabic(String input, int output) {
        assertEquals(RomanNumeralConverter.romanToArabic(input), output);
    }

    @ParameterizedTest
    @ValueSource(strings = { "XI", "XX", "LX", "XCIX" })
    void romanToArabicWhenRomanMoreThanXThenThrowsIncorrectRomanNumericException(String roman) {
        IncorrectRomanNumericException ex = assertThrows(IncorrectRomanNumericException.class, () ->
                RomanNumeralConverter.romanToArabic(roman));
        assertEquals("incorrect format numbers", ex.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = { "IIII", "VV", "VIV", "IVI" })
    void romanToArabicWhenRomanInvalidThenThrowsIncorrectRomanNumericException(String roman) {
        IncorrectRomanNumericException ex = assertThrows(IncorrectRomanNumericException.class, () ->
                RomanNumeralConverter.romanToArabic(roman));
        assertEquals("incorrect format numbers", ex.getMessage());
    }
}