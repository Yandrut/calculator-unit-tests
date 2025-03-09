package com.epam.tat.module4;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.epam.tat.module4.configuration.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class IsNegativeTest extends BaseTest {

    @DisplayName("Number is negative positive cases")
    @ParameterizedTest
    @CsvFileSource(resources = "/csv/negativeNumbers.csv")
    public void isNegativeTrueScenarios(long param) {
        assertTrue(calculator.isNegative(param));
    }

    @DisplayName("Number is negative false cases")
    @ParameterizedTest
    @CsvFileSource(resources = "/csv/sumPositiveValues.csv")
    public void isNegativeFalseScenario(long param) {
        assertFalse(calculator.isNegative(param));
    }
}