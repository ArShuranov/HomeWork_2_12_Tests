package com.example.homework_test;

import com.example.homework_test.exception.NoParam;
import com.example.homework_test.service.serviceImpl.CalculatorServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

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


    //Парметризованные тесты

    public static Stream<Arguments> numsForTestPlus() {
        return  Stream.of(
                Arguments.of(4, 2, "4 + 2 = 6"),
                Arguments.of(5, 1, "5 + 1 = 6"),
                Arguments.of(1, 2, "1 + 2 = 3")
        );
    }

    @ParameterizedTest
    @MethodSource("numsForTestPlus")
    public void plusParametrized(int a, int b, String result) {
        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        String actual = calculatorService.plus(a,b);
        assertEquals(result, actual);

    }
/////////////////////////////////////////////////////////////

    public static Stream<Arguments> numsForTestMinus() {
        return  Stream.of(
                Arguments.of(4, 2, "4 - 2 = 2"),
                Arguments.of(5, 1, "5 - 1 = 4"),
                Arguments.of(1, 2, "1 - 2 = -1")
        );
    }

    @ParameterizedTest
    @MethodSource("numsForTestMinus")
    public void minusParametrized(int a, int b, String result) {
        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        String actual = calculatorService.minus(a,b);
        assertEquals(result, actual);

    }
/////////////////////////////////////////////////////////////

    public static Stream<Arguments> numsForTestMultiply() {
        return  Stream.of(
                Arguments.of(4, 2, "4 * 2 = 8"),
                Arguments.of(5, 1, "5 * 1 = 5"),
                Arguments.of(1, 2, "1 * 2 = 2")
        );
    }

    @ParameterizedTest
    @MethodSource("numsForTestMultiply")
    public void multiplyParametrized(int a, int b, String result) {
        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        String actual = calculatorService.multiply(a,b);
        assertEquals(result, actual);

    }
/////////////////////////////////////////////////////////////
public static Stream<Arguments> numsForTestDivide() {
    return  Stream.of(
            Arguments.of(4, 2, "4 / 2 = 2"),
            Arguments.of(5, 1, "5 / 1 = 5"),
            Arguments.of(1, 2, "1 / 2 = 0")
    );
}

    @ParameterizedTest
    @MethodSource("numsForTestDivide")
    public void divideParametrized(int a, int b, String result) {
        CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
        String actual = calculatorService.divide(a,b);
        assertEquals(result, actual);

    }
}
