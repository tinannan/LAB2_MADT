package com.example.lab2_madt;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import textUtils.TextCounter;

public class MainActivity extends AppCompatActivity {

    EditText edUserInput;
    Spinner spinnerCounting;
    TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        this.edUserInput = findViewById(R.id.edUserInput);
        this.tvResult = findViewById(R.id.tvResult);
        this.spinnerCounting = findViewById(R.id.spinnerCounting);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.counting_options,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCounting.setAdapter(adapter);
    }

    public void onBtnCountClick(View view) {

//getting text so it wont be hardcoded
        String[] countingOptions = getResources().getStringArray(R.array.counting_options);
        String userInput = this.edUserInput.getText().toString();
        if (userInput.isEmpty()) {
            // empty checking toast
            Toast.makeText(this, "Please enter some text", Toast.LENGTH_LONG).show();
            return;  // stop further processing
        }
//if set to chars counting
        if(this.spinnerCounting.getSelectedItem().toString().equals(countingOptions[0])) {
            int count = TextCounter.getCharsCount(userInput);
            this.tvResult.setText(String.valueOf(count));
        }
// words counting
        else {
            int wordCount = TextCounter.getWordsCount(userInput);
            this.tvResult.setText(String.valueOf(wordCount));
        }
    }
}