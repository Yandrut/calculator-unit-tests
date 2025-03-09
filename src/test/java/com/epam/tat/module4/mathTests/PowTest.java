package com.epam.tat.module4.mathTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.epam.tat.module4.configuration.BaseTest;
import com.epam.tat.module4.utils.NumberParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class PowTest extends BaseTest {

    @DisplayName("Pow positive scenarios")
    @ParameterizedTest
    @CsvFileSource(resources = {"/csv/pow.csv"})
    public void powPositiveScenarios(String param1, String param2, String expectedString) {
        double expected = NumberParser.parseInfinity(expectedString);
        double actual = calculator.pow(NumberParser.parseInfinity(param1),
            NumberParser.parseInfinity(param2));
        assertEquals(expected, actual);
    }

    @DisplayName("Pow with nullable values")
    @ParameterizedTest
    @CsvFileSource(resources = {"/csv/nullableNumbers.csv"})
    public void nullableDoubleMultiplying(String param1, String param2) {
        assertThrows(NullPointerException.class,
            () -> calculator.pow(NumberParser.parseAsDouble(param1),
                NumberParser.parseAsDouble(param2)));
    }
}
