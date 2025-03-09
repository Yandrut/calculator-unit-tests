package com.epam.tat.module4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.epam.tat.module4.configuration.BaseTest;
import com.epam.tat.module4.utils.NumberParser;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class SubtractTest extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = {"/csv/subtractionNumbers.csv"})
    public void doublePositiveScenarios(double param1, double param2, double expected) {
        double actual = calculator.sub(param1, param2);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = {"/csv/nullableNumbers.csv"})
    public void nullableDouble(String param1, String param2) {
        assertThrows(NullPointerException.class,
            () -> calculator.sub(NumberParser.parseAsDouble(param1),
                NumberParser.parseAsDouble(param2)));
    }

    @ParameterizedTest
    @CsvFileSource(resources = {"/csv/subtractionNumbers.csv"})
    public void longPositiveScenarios(String param1, String param2, String expected) {
        assertEquals((long) NumberParser.parseAsDouble(expected),
            calculator.sub((long) NumberParser.parseAsDouble(param1),
                (long) NumberParser.parseAsDouble(param2)));
    }

    @ParameterizedTest
    @CsvFileSource(resources = {"/csv/nullableNumbers.csv"})
    public void nullableLong(String param1, String param2) {
        assertThrows(NullPointerException.class,
            () -> calculator.sub(NumberParser.parseAsLong(param1),
                NumberParser.parseAsLong(param2)));
    }
}