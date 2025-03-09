package com.epam.tat.module4.mathTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.epam.tat.module4.configuration.BaseTest;
import com.epam.tat.module4.utils.NumberParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class SqrtTest extends BaseTest {

    @DisplayName("Sqrt positive scenarios")
    @ParameterizedTest
    @CsvFileSource(resources = {"/csv/sqrt.csv"})
    public void powPositiveScenarios(String param, String expectedString) {
        double expected = NumberParser.parseInfinity(expectedString);
        double actual = calculator.sqrt(NumberParser.parseInfinity(param));
        assertEquals(expected, actual);
    }

    @DisplayName("Sqrt with nullable values")
    @ParameterizedTest
    @CsvFileSource(resources = {"/csv/nullOnly.csv"})
    public void nullableSqrt(String param) {
        assertThrows(NullPointerException.class,
            () -> calculator.sqrt(NumberParser.parseAsDouble(param)));
    }
}