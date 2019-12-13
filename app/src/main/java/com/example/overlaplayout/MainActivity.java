package com.example.overlaplayout;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.sql.Time;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ImageView iv,iv2, iv3;
    Timer timer;
    int tt=10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = (ImageView)findViewById(R.id.imageView);
        iv2 = (ImageView)findViewById(R.id.imageView2);
        iv3 = (ImageView)findViewById(R.id.imageView3);
        timer = new Timer();//時間函示初始化

        final TimerTask task = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tt--;//時間倒數
                        Random random = new Random();
                        int i =random.nextInt(255)+1;
                        int j =random.nextInt(255)+1;
                        int k =random.nextInt(255)+1;
                        iv.setColorFilter(Color.rgb(j, k, i));
                        iv2.setColorFilter(Color.rgb(i, j, k));
                        iv3.setColorFilter(Color.rgb(k, i, j));
//                        t1.setText(tt+"second");//讓TextView元件顯示時間倒數情況
                        //if判斷示裡面放置在時間結束後想要完成的事件
                        if (tt < 1) {
                            tt = 10; //讓時間執行緒保持輪迴
                        }
                    }
                });
            }
        };
        timer.schedule(task, 1000, 1000);//時間在幾毫秒過後開始以多少毫秒執行
    }
}
