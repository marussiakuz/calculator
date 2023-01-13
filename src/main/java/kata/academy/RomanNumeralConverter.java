package kata.academy;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

final class RomanNumeralConverter {

    private static final TreeMap<Integer, String> romanNumerals;

    static {
        romanNumerals = new TreeMap<>();

        Arrays.stream(RomanNumeral.values())
                .forEach(romanNumeral -> romanNumerals.put(romanNumeral.getValue(), romanNumeral.toString()));
    }

    private RomanNumeralConverter() {
    }

    public static String arabicToRoman(int number) {
        if (number < 1)
            throw new IncorrectRomanNumericException("There are no negative numbers and zero in the Roman system");

        if (number > romanNumerals.lastKey())
            throw new CalculationException(String.format("conversion of roman numerals greater than %s isn't supported",
                    romanNumerals.lastKey()));

        StringBuilder builder = new StringBuilder();

        while (number != 0) {
            if (romanNumerals.containsKey(number)) {
                builder.append(romanNumerals.get(number));
                break;
            }

            Map.Entry<Integer, String> entry = romanNumerals.floorEntry(number);
            builder.append(entry.getValue());
            number -= entry.getKey();
        }

        return builder.toString();
    }

    public static int romanToArabic(String input) {
        if (romanNumerals.containsValue(input.toUpperCase()))
            return RomanNumeral.valueOf(input.toUpperCase()).getValue();

        if (input.length() > 4 || !(input.matches("^V||V*(I{1,3})$"))) {
            throw new IncorrectRomanNumericException("incorrect format numbers");
        }

        return input.startsWith("I") ? RomanNumeral.I.getValue() * input.length() :
                RomanNumeral.V.getValue() + (RomanNumeral.I.getValue() * (input.length() - 1));
    }
}
