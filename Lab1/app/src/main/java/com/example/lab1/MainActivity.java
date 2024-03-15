package com.example.lab1;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.GridLayout;
import androidx.appcompat.widget.AppCompatButton;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity {
    private TextView resultField;
    private TextView operationField;
    private Calculator calculator;

    private static final String KEY_RESULT = "Result";
    private static final String KEY_OPERATION = "Pperation";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultField = findViewById(R.id.resultField);
        operationField = findViewById(R.id.operationField);

        calculator = new Calculator();

        GridLayout gridLayout = findViewById(R.id.buttonGrid);
        for (int i = 0; i < gridLayout.getChildCount(); i++) {
            View view = gridLayout.getChildAt(i);
            if (view instanceof AppCompatButton) {
                AppCompatButton button = (AppCompatButton) view;
                button.setOnClickListener((View v) -> onButtonClick(button.getText().toString()));
            }
        }

        if (savedInstanceState != null) {
            resultField.setText(savedInstanceState.getString(KEY_RESULT));
            operationField.setText(savedInstanceState.getString(KEY_OPERATION));
        }
    }

    protected void onButtonClick(String buttonText) {
        calculator.processButtonClick(buttonText, operationField, resultField);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_RESULT, resultField.getText().toString());
        outState.putString(KEY_OPERATION, operationField.getText().toString());
    }
}
