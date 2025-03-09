package com.epam.tat.module4;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.epam.tat.module4.configuration.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class IsPositiveTest extends BaseTest {

    @DisplayName("Number is positive true cases")
    @ParameterizedTest
    @CsvFileSource(resources = "/csv/sumPositiveValues.csv")
    public void isPositiveTrueScenarios(long param) {
        assertTrue(calculator.isPositive(param));
    }

    @DisplayName("Number is positive negative cases")
    @ParameterizedTest
    @CsvFileSource(resources = "/csv/negativeNumbers.csv")
    public void isPositiveFalseScenario(long param) {
        assertFalse(calculator.isPositive(param));
    }
}