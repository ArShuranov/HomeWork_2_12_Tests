package com.example.homework_test.service.serviceImpl;

import com.example.homework_test.exception.NoParam;
import com.example.homework_test.service.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public String greeting() {
        return "Добро пожаловать в калькулятор!";
    }

    //проверка параметра на null
    private void CheckParam(Integer num1, Integer num2) {
        if (num1 == null || num2 == null) {
            throw new NoParam();
        }
    }

    @Override
    public String plus(Integer num1, Integer num2) {
        CheckParam(num1, num2);
        return num1 + " + " + num2 + " = " + (num1 + num2);
    }

    @Override
    public String minus(Integer num1, Integer num2) {
        CheckParam(num1, num2);
        return num1 + " - " + num2 + " = " + (num1 - num2);
    }

    @Override
    public String multiply(Integer num1, Integer num2) {
        CheckParam(num1, num2);
        return num1 + " * " + num2 + " = " + (num1 * num2);
    }

    @Override
    public String divide(Integer num1, Integer num2) {
        CheckParam(num1, num2);
        if (num2 == 0) {
            throw new IllegalArgumentException();
        }
        return num1 + " / " + num2 + " = " + (num1 / num2);

    }
}
