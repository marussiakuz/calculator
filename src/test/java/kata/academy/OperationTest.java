package kata.academy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OperationTest {

    @Test
    void getOperationBySymbolIfSymbolIsBeingUsedThenReturnEnumOperation() {
        assertEquals(Operation.ADD, Operation.getOperationBySymbol("+"));
        assertEquals(Operation.MINUS, Operation.getOperationBySymbol("-"));
        assertEquals(Operation.DIVIDE, Operation.getOperationBySymbol("/"));
        assertEquals(Operation.MULTIPLY, Operation.getOperationBySymbol("*"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "%"})
    void getOperationBySymbolIfSymbolIsNotBeingUsedThenThrowsCalculationException(String symbol) {
        CalculationException ex = assertThrows(CalculationException.class, () ->
                Operation.getOperationBySymbol(symbol));
        assertEquals(String.format("operation %s isn't supported/recognized", symbol), ex.getMessage());
    }
}