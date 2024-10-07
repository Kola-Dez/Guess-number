package com.example.serchnumber;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int randomNumber;
    private final int endNumber = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText numberInput = findViewById(R.id.numberInput);
        Button checkButton = findViewById(R.id.checkButton);
        TextView resultTextView = findViewById(R.id.resultTextView);

        randomNumber = generateRandomNumber();

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = numberInput.getText().toString();
                int guessedNumber = Integer.parseInt(userInput);
                if (!userInput.isEmpty() && guessedNumber <= endNumber && guessedNumber >= 0) {
                    checkNumber(guessedNumber, resultTextView);
                } else {
                    resultTextView.setText("Пожалуйста, введите число от 1 до 20.");
                }
            }
        });
    }

    private int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(endNumber) + 1;
    }

    private void checkNumber(int guessedNumber, TextView resultTextView) {
        if (guessedNumber < randomNumber) {
            resultTextView.setText("Загаданное число больше.");
        } else if (guessedNumber > randomNumber) {
            resultTextView.setText("Загаданное число меньше.");
        } else {
            resultTextView.setText("Поздравляем! Вы угадали число!\n\t\t\t\t\tДавайте еще раз!!!");
            randomNumber = generateRandomNumber();
        }
    }
}
