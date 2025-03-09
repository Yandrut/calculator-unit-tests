package com.epam.tat.module4.mathTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.epam.tat.module4.configuration.BaseTest;
import com.epam.tat.module4.utils.NumberParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class TgTest extends BaseTest {

    @DisplayName("Tg test with positive scenarios")
    @ParameterizedTest
    @CsvFileSource(resources = {"/csv/tg.csv"})
    public void powPositiveScenarios(String param, String expectedString) {
        double expected = NumberParser.parseInfinity(expectedString);
        double actual = calculator.tg(NumberParser.parseInfinity(param));
        assertEquals(expected, actual, 1E-10);
    }

    @DisplayName("Tg test with nullable values")
    @ParameterizedTest
    @CsvFileSource(resources = {"/csv/nullOnly.csv"})
    public void nullableSqrt(String param) {
        assertThrows(NullPointerException.class,
            () -> calculator.tg(NumberParser.parseAsDouble(param)));
    }
}