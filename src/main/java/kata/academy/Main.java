package kata.academy;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final String ARABIC_PATTERN = "^([1-9]||10)\\s*[+-/*]\\s*([1-9]||10)$";
    private static final String ROMAN_PATTERN = "^(I{1,3}|X|IX|IV|V?I{0,3})\\s*[+-/*]\\s*(I{1,3}|X|IX|IV|V?I{0,3})$";
    private static final String OPERATOR = "[+-/*]";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        while (!(input = scanner.nextLine()).equals("exit")) {
            System.out.println(calc(input));
        }
    }

    public static String calc(String input) {
        boolean isArabic = true;

        if (!input.matches(ARABIC_PATTERN)) {
            if (input.matches(ROMAN_PATTERN)) isArabic = false;
            else throw new CalculationException("The expression doesn't follow the rules");
        }

        Matcher m = Pattern.compile(OPERATOR).matcher(input);
        String[] numbers = input.split(OPERATOR);

        Result result = Calculator.calculate(convertToInt(numbers[0].trim(), isArabic),
                Operation.getOperationBySymbol(m.find() ? m.group() : ""), convertToInt(numbers[1].trim(), isArabic));

        result.setRoman(!isArabic);

        return result.toString();
    }

    private static int convertToInt(String str, boolean isArabic) {
        return isArabic? Integer.parseInt(str) : RomanNumeralConverter.romanToArabic(str);
    }
}