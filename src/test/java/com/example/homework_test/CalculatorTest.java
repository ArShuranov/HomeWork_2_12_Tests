package com.example.homework_test;

import com.example.homework_test.exception.NoParam;
import com.example.homework_test.service.serviceImpl.CalculatorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void plus() {
        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        String actual = calculatorService.plus(4,2);
        String expected = "4 + 2 = 6";
        assertEquals(expected, actual);
    }

    @Test
    public void minus() {
        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        String actual = calculatorService.minus(4,2);
        String expected = "4 - 2 = 2";
        assertEquals(expected, actual);
    }

    @Test
    public void multiply() {
        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        String actual = calculatorService.multiply(4,2);
        String expected = "4 * 2 = 8";
        assertEquals(expected, actual);
    }

    @Test
    public void divide() {
        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        String actual = calculatorService.divide(4,2);
        String expected = "4 / 2 = 2";
        assertEquals(expected, actual);
    }

    @Test
    public void divideByZero() {
        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculatorService.divide(4, 0);
        });
    }

    @Test
    public void divideWithoutParam() {
        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();

        Assertions.assertThrows(NoParam.class, () -> {
            calculatorService.divide(null, null);
        });

    }

}
