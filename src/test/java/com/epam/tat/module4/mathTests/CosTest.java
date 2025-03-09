package com.epam.tat.module4.mathTests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.epam.tat.module4.configuration.BaseTest;
import com.epam.tat.module4.utils.NumberParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CosTest extends BaseTest {

    @DisplayName("Cosign positive scenarios")
    @ParameterizedTest
    @CsvFileSource(resources = {"/csv/cos.csv"})
    public void cosignPositiveScenarios(double param, double expected) {
        double actual = calculator.cos(param);
        assertEquals(expected, actual, 1E-15);
    }

    @DisplayName("Cosign with nullable values")
    @ParameterizedTest
    @CsvFileSource(resources = {"/csv/nullOnly.csv"})
    public void nullableCosign(String param) {
        assertThrows(NullPointerException.class,
            () -> calculator.cos(NumberParser.parseAsDouble(param)));
    }
}
