package com.tms.calculator.operators;

import com.tms.calculator.CalcOperation;

public class Subtraction implements CalcOperation {
    @Override
    public double calculate(double number1, double number2) {
        return number1 - number2;
    }
}
