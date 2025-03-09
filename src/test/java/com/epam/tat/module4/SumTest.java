package com.epam.tat.module4;

import com.epam.tat.module4.configuration.BaseTest;
import com.epam.tat.module4.utils.NumberParser;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SumTest extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/sumPositiveValues.csv")
    public void doublePositiveScenarios(double param1, double param2, double expected) {
        double actual = calculator.sum(param1, param2);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/nullableNumbers.csv")
    public void nullableDouble(String param1, String param2) {
        assertThrows(NullPointerException.class,
            () -> calculator.sum(NumberParser.parseAsDouble(param1),
                NumberParser.parseAsDouble(param2)));
    }

    @ParameterizedTest
    @CsvFileSource(resources = {"/csv/sumPositiveValuesLong.csv"})
    public void longPositiveScenarios(long param1, long param2, long expected) {
        long actual = calculator.sum(param1, param2);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/csv/nullableNumbers.csv")
    public void nullableLong(String param1, String param2) {
        assertThrows(NullPointerException.class,
            () -> calculator.sum(NumberParser.parseAsLong(param1),
                NumberParser.parseAsLong(param2)));
    }
}