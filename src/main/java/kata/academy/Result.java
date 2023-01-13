package kata.academy;

import java.util.Objects;

final class Result {
    private final int value;
    private boolean isRoman;

    public Result(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setRoman(boolean isRoman) {
        this.isRoman = isRoman;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Result result = (Result) o;
        return value == result.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return isRoman ? RomanNumeralConverter.arabicToRoman(value) : String.valueOf(value);
    }
}
