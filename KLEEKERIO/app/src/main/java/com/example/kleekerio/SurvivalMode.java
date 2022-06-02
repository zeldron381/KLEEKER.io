package com.example.kleekerio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class SurvivalMode extends AppCompatActivity {
    private EditText editText;
    private TextView textView;
    private TextView textViewTime;
    private Timer timer;
    private boolean flag;
    private MyTimerTask mMyTimerTask;
    private int count;
    private int correct;
    private int total;
    private TextView textOtvet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survive);

        editText = findViewById(R.id.text_view_SurvInp);
        textView = findViewById(R.id.text_view);
        textViewTime = findViewById(R.id.text_view_time);
        timer = new Timer();
        flag = false;
        correct = 0;
        total = 0;
        //editText.getText().toString();

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText.getText().toString().equals(textView.getText().toString())) {
                    count += 10;
                    correct += 1;
                    Log.d("MAIN", editText.getText().toString() + " " + textView.getText().toString());
                }
                if(!flag){
                    Toast.makeText(SurvivalMode.this, "начало отсчета", Toast.LENGTH_SHORT).show();
                    mMyTimerTask = new MyTimerTask();
                    timer.cancel();
                    timer = new Timer();
                    timer.schedule(mMyTimerTask, 1000, 1000);
                    textView.setText(GenWords.generate());
                    total += 1;
                    flag = true;
                }
                else {
                    timer.cancel();
                    timer = new Timer();
                    mMyTimerTask = new MyTimerTask(0);
                    timer.schedule(mMyTimerTask, 1000, 1000);
                    textView.setText(GenWords.generate());
                    total += 1;
                    flag = true;
                }
            }
        };
        editText.setOnClickListener(listener);
    }

    class MyTimerTask extends TimerTask {

        MyTimerTask(){
            count = 120;
            Log.d("HEH", "String.valueOf(count)");
        }
        MyTimerTask(int i){
            Log.d("HEH", "String.valueOf(count)");
        }

        @Override
        public void run() {
            count--;
            if(count<0)
                count = 0;
            if(count == 0) {
                Intent intent = new Intent(SurvivalMode.this, GameResults.class);
                startActivity(intent);
            }
            Log.d("HEH", "String.valueOf(count)");

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    textViewTime.setText(String.valueOf(count));
                    Log.d("HEH", String.valueOf(count));
                }
            });

        }

    }
}
