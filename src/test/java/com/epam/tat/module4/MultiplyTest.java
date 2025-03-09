package com.epam.tat.module4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.epam.tat.module4.configuration.BaseTest;
import com.epam.tat.module4.utils.NumberParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class MultiplyTest extends BaseTest {

    @DisplayName("Multiplying long positive scenarios")
    @ParameterizedTest
    @CsvFileSource(resources = {"/csv/multiply.csv"})
    public void multiplyingLongPositiveScenarios(long param1, long param2, long expected) {
        double actual = calculator.mult(param1, param2);
        assertEquals(expected, actual);
    }

    @DisplayName("Multiplying long with nullable values")
    @ParameterizedTest
    @CsvFileSource(resources = {"/csv/nullableNumbers.csv"})
    public void nullableLongMultiplying(String param1, String param2) {
        assertThrows(NullPointerException.class,
            () -> calculator.mult(NumberParser.parseAsLong(param1),
                NumberParser.parseAsLong(param2)));
    }
}
