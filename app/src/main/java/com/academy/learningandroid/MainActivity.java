package com.academy.learningandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import kotlin.text.HexExtensionsKt;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    SeekBar seekBar;
    TextView textViewPercent;
    Button button;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        seekBar = findViewById(R.id.seekBar);
        textViewResult = findViewById(R.id.textViewResult);
        button = findViewById(R.id.button);
        textViewPercent = findViewById(R.id.textViewPercent);
        final int[] percentage = {0};

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                percentage[0] = progress * 10;
                textViewPercent.setText(progress * 10 + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                try{
                    double sum = Double.parseDouble(str);
                    double result = sum * percentage[0] / 100;
                    textViewResult.setText("Сумма чаевых: " + result);
                }catch (NumberFormatException e){
                    textViewResult.setText(e.toString());
                }
            }
        });
    }
}