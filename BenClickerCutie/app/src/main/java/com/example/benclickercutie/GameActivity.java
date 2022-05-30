package com.example.benclickercutie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity {
    private TextView textViewSum;
    private ImageView imageViewBen;
    private TextView textViewPrize;
    private Button buttonClick;
    private int sum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        textViewSum = findViewById(R.id.text_view_sum);
        imageViewBen = findViewById(R.id.image_view_ben);
        textViewPrize = findViewById(R.id.text_view_prize);
        buttonClick = findViewById(R.id.button_click);
        sum = 0;


        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sum++;
                textViewSum.setText(String.valueOf(sum));
                switch (sum){
                    case 1:
                        textViewPrize.setText("Лузер");
                        imageViewBen.setImageResource(R.drawable.ben_1);
                        break;
                    case 10:
                        textViewPrize.setText("Бедолага");
                        imageViewBen.setImageResource(R.drawable.ben_2);
                        break;
                    case 20:
                        textViewPrize.setText("Ровный Бен");
                        imageViewBen.setImageResource(R.drawable.ben_3);
                        break;
                    case 30:
                        textViewPrize.setText("Бен Хорош!!!!");
                        imageViewBen.setImageResource(R.drawable.ben_4);
                    case 40:
                        textViewPrize.setText("Бен, Убийца Кнопок");
                        imageViewBen.setImageResource(R.drawable.ben_5);
                        break;
                    case 50:
                        textViewPrize.setText("Бен, Кнопочный Аннигилятор");
                        imageViewBen.setImageResource(R.drawable.ben_6);
                }

            }
        };
        buttonClick.setOnClickListener(listener);
    }
}
