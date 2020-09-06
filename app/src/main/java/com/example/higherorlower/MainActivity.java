package com.example.higherorlower;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int randomNumber = 0;

    public void randomNumberGenerator() {
        Random random = new Random();
        randomNumber = random.nextInt(20) + 1;
        Log.i("Random Number", Integer.toString(randomNumber));
    }

    public void guess(View view) throws InterruptedException {
        EditText editText = findViewById(R.id.editTextNumber);
        String guessed = editText.getText().toString();
        int guessedNumber = Integer.parseInt(guessed);
        Log.i("Entered Number", guessed);
        String message;
        if (randomNumber > guessedNumber) message = "Higher!";
        else if (randomNumber < guessedNumber) {
            message = "Lower!";
        } else {
            Toast.makeText(this, "You Got It!\nChanging number ...", Toast.LENGTH_SHORT).show();
            message = "Play Again!";
            randomNumberGenerator();
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        randomNumberGenerator();
    }
}