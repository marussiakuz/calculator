package kata.academy;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

enum Operation {
    ADD("+"),
    MINUS("-"),
    DIVIDE("/"),
    MULTIPLY("*");

    private final String symbol;
    private static final Map<String, Operation> LOOKUP;

    static {
        LOOKUP = Arrays.stream(Operation.values())
                .collect(Collectors.toMap(Operation::getSymbol, e -> e));
    }

    Operation(String symbol) {
        this.symbol = symbol;
    }

    public static Operation getOperationBySymbol(String symbol) {
        if (!LOOKUP.containsKey(symbol))
            throw new CalculationException(String.format("operation %s isn't supported/recognized", symbol));
        return LOOKUP.get(symbol);
    }

    private static String getSymbol(Operation operation) {
        return operation.symbol;
    }
}
