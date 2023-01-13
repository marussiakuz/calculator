package kata.academy;

import java.util.EnumMap;
import java.util.function.BiFunction;

import static kata.academy.Operation.*;

class Calculator {
    private static final EnumMap<Operation, BiFunction<Integer, Integer, Result>> OPERATION_EXECUTORS;

    static {
        OPERATION_EXECUTORS = new EnumMap<>(Operation.class);
        OPERATION_EXECUTORS.put(ADD, (a, b) -> new Result(a + b));
        OPERATION_EXECUTORS.put(MINUS, (a, b) -> new Result(a - b));
        OPERATION_EXECUTORS.put(MULTIPLY, (a, b) -> new Result(a * b));
        OPERATION_EXECUTORS.put(DIVIDE, (a, b) -> new Result(division(a, b)));
    }

    private Calculator() {
    }

    public static Result calculate(int a, Operation operation, int b) {
        return OPERATION_EXECUTORS.get(operation).apply(a, b);
    }

    private static int division(int a, int b) {
        if (b == 0) {
            throw new CalculationException("Division by zero");
        }

        return a / b;
    }
}
