package com.example.kleekerio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survive);

        editText = findViewById(R.id.text_view_SurvInp);
        textView = findViewById(R.id.text_view);
        textViewTime = findViewById(R.id.text_view_time);
        timer = new Timer();
        //editText.getText().toString();

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timer.cancel();
                Toast.makeText(SurvivalMode.this, "начало отсчета", Toast.LENGTH_SHORT).show();
                textView.setText(String.valueOf ((char)(97+Math.random()*10)));
                timer = new Timer();
                MyTimerTask mMyTimerTask = new MyTimerTask();
                timer.schedule(mMyTimerTask, 1000, 1000);
            }
        };
        editText.setOnClickListener(listener);
    }

    class MyTimerTask extends TimerTask {
        int count;

        MyTimerTask(){
            count = 0;
            Log.d("HEH", "String.valueOf(count)");
        }

        @Override
        public void run() {
            count++;
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
