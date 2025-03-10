package com.epam.tat.module4.mathTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.epam.tat.module4.configuration.BaseTest;
import com.epam.tat.module4.utils.NumberParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class SinTest extends BaseTest {

    @DisplayName("Sin test positive cases")
    @ParameterizedTest
    @CsvFileSource(resources = "/csv/sin.csv")
    public void sinTestPositiveCases(String param, String expectedString) {
        double expected = NumberParser.parseInfinity(expectedString);
        double actual = calculator.sin(NumberParser.parseInfinity(param));
        assertEquals(expected, actual,1e-9);
    }

    @DisplayName("Sin test nullable cases")
    @ParameterizedTest
    @CsvFileSource(resources = "/csv/nullOnly.csv")
    public void sinTestNullableCases(String param) {
        assertThrows(NullPointerException.class,
            () -> calculator.sin(NumberParser.parseAsDouble(param)));
    }
}