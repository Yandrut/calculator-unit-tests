package com.epam.tat.module4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.epam.tat.module4.configuration.BaseTest;
import com.epam.tat.module4.utils.NumberParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class DivideTest extends BaseTest {

    @DisplayName("Dividing double positive scenarios")
    @ParameterizedTest
    @CsvFileSource(resources = {"/csv/division.csv"})
    public void divisionPositiveScenarios(double param1, double param2, double expected) {
        double actual = calculator.div(param1, param2);
        assertEquals(expected, actual);
    }

    @DisplayName("Dividing double with nullable values")
    @ParameterizedTest
    @CsvFileSource(resources = {"/csv/nullableNumbers.csv"})
    public void nullableDivision(String a, String b) {
        assertThrows(NullPointerException.class,
            () -> calculator.div(NumberParser.parseAsDouble(a),
                NumberParser.parseAsDouble(b)));
    }

    @DisplayName("Dividing long positive scenarios")
    @ParameterizedTest
    @CsvFileSource(resources = {"/csv/division.csv"})
    public void divisionPositiveScenarios(long a, long b, long expected) {
        double actual = calculator.div(a, b);
        assertEquals(expected, actual);
    }

    @DisplayName("Dividing long with nullable values")
    @ParameterizedTest
    @CsvFileSource(resources = {"/csv/nullableNumbers.csv"})
    public void nullableDivisionLong(String a, String b) {
        assertThrows(NullPointerException.class,
            () -> calculator.div(NumberParser.parseAsLong(a)
                , NumberParser.parseAsLong(b)));
    }
}
