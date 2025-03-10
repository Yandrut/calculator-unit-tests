package com.epam.tat.module4.mathTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.epam.tat.module4.configuration.BaseTest;
import com.epam.tat.module4.utils.NumberParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CtgTest extends BaseTest {

    @DisplayName("Ctg positive scenarios")
    @ParameterizedTest
    @CsvFileSource(resources = {"/csv/cotangents.csv"})
    public void ctgPositiveScenarios(double param, String expected) {
        double expectedValue = NumberParser.parseInfinity(expected);
        double actualValue = calculator.ctg(param);

        if (Double.isNaN(expectedValue)) {
            assertTrue(Double.isNaN(actualValue), "Expected NaN, but got " + actualValue);
        } else {
            assertEquals(expectedValue, actualValue, 1E-10);
        }
    }

    @DisplayName("Ctg nullable scenarios")
    @ParameterizedTest
    @CsvFileSource(resources = "/csv/nullOnly.csv")
    public void nullableCtg(String param) {
        assertThrows(NullPointerException.class,
            () -> calculator.ctg(NumberParser.parseAsDouble(param)));
    }
}