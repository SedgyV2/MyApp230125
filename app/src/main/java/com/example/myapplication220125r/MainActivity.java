package com.example.myapplication220125r;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    int TimesClicked = 0;
    boolean IncreaseDecrease = false;
    String Increase ="Increase";
    String Decrease = "Decrease";

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
        textView = findViewById(R.id.HowManyClicked);
        textView.setText(String.valueOf(TimesClicked));
        button = findViewById(R.id.IncreaseDecreaseButton);
        button.setText(Increase);
    }
    public void AddTimesClicked(View view){
        if(!IncreaseDecrease) {
            TimesClicked++;
            textView.setText(String.valueOf(TimesClicked));
        } else if (IncreaseDecrease) {
            TimesClicked--;
            textView.setText(String.valueOf(TimesClicked));
        }
    }
    public void ResetTimesClicked(View view){
        TimesClicked = 0;
        textView.setText(String.valueOf(TimesClicked));
    }
    public void IncreaseDecreaseFunction(View view){
        if(!IncreaseDecrease){
            button.setText(Decrease);
            IncreaseDecrease = true;
        } else if (IncreaseDecrease) {
            button.setText(Increase);
            IncreaseDecrease = false;
        }
    }
}