package com.example.lab1;

import android.widget.TextView;
import net.objecthunter.exp4j.*;

public class Calculator {
    public void processButtonClick(String buttonText, TextView operationField, TextView resultField) {
        switch (buttonText) {
            case "sqrt":
            case "log2":
            case "log":
            case "sin":
            case "cos":
                operationField.append(buttonText + "(");
                break;
            case "x^y":
                operationField.append("^");
                break;
            case "AC":
                resultField.setText("");
                operationField.setText("");
                break;
            case "back":
                String s = operationField.getText().toString();
                if (!s.isEmpty()) {
                    operationField.setText(s.substring(0, s.length() - 1));
                }
                break;
            case "=":
                String operationText = operationField.getText().toString();
                if (!operationText.isEmpty()) {
                    try {
                        Expression expression = new ExpressionBuilder(operationText).build();
                        double result = expression.evaluate();
                        resultField.setText(Double.toString(result));
                    } catch (Exception exception) {
                        resultField.setText("Invalid input");
                    }
                }
                break;
            default:
                operationField.append(buttonText);
                break;
        }
    }
}
