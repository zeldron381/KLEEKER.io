package com.example.kleekerio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.kleekerio.SurvivalMode;


public class ModeSelect extends AppCompatActivity {

    private Button buttonEnter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);

        buttonEnter = findViewById(R.id.survive);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ModeSelect.this, SurvivalMode.class);
                startActivity(intent);
            }
        };
        buttonEnter.setOnClickListener(listener);
    }
}