package com.example.overlaplayout;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView iv;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView)findViewById(R.id.imageView);
        btn1 =(Button)findViewById(R.id.button1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int i =random.nextInt(255)+1;
                int j =random.nextInt(255)+1;
                int k =random.nextInt(255)+1;
                btn1.setBackgroundColor(Color.rgb(i, j, k));
                iv.setColorFilter(Color.rgb(j, i, k));
            }
        });
    }
}
