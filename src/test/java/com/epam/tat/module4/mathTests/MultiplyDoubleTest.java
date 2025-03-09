package com.epam.tat.module4.mathTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.epam.tat.module4.configuration.BaseTest;
import com.epam.tat.module4.utils.NumberParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class MultiplyDoubleTest extends BaseTest {

    @DisplayName("Multiplying double positive scenarios")
    @ParameterizedTest
    @CsvFileSource(resources = {"/csv/multiplyValuesWithRounding.csv"})
    public void doublePositiveScenarios(String param1, String param2, String expectedString) {
        double expected = NumberParser.parseInfinity(expectedString);
        double actual = calculator.mult(
            NumberParser.parseInfinity(param1), NumberParser.parseInfinity(param2));
        assertEquals(expected, actual);
    }

    @DisplayName("Multiply with nullable values")
    @ParameterizedTest
    @CsvFileSource(resources = {"/csv/nullableNumbers.csv"})
    public void nullableDoubleMultiplying(String param1, String param2) {
        assertThrows(NullPointerException.class,
            () -> calculator.mult(NumberParser.parseAsDouble(param1),
                NumberParser.parseAsDouble(param2)));
    }
}