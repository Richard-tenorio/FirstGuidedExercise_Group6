package com.example.firstguidedexercise;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText name, age;
    TextView result;
    Button click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.etNameGE1);
        age = findViewById(R.id.etAgeGE1);
        result = findViewById(R.id.tvResultGE1);
        click = findViewById(R.id.btnClickGE1);
        showResult();
    }

    @SuppressLint("SetTextI18n")
    public void showResult() {
        click.setOnClickListener(view -> {
            String inputName = name.getText().toString().trim();
            String inputAge = age.getText().toString().trim();

            if (inputName.isEmpty()) {
                result.setText("Please enter your name.");
                name.requestFocus();
                return;
            }

            if (!inputName.matches("[a-zA-Z ]+")) {
                result.setText("Name must contain only letters.");
                name.requestFocus();
                return;
            }

            if (inputAge.isEmpty()) {
                result.setText("Please enter your age.");
                age.requestFocus();
                return;
            }

            if (!inputAge.matches("\\d+")) {
                result.setText("Age must be a number.");
                age.requestFocus();
                return;
            }

            result.setText("Name: " + inputName +
                    "\nAge: " + inputAge);
            name.setText("");
            age.setText("");
            name.requestFocus();
        });
    }
}
