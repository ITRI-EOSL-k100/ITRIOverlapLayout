package com.example.overlaplayout;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.LineData;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    //activity_main.xml
    ImageView iv,iv2, iv3;
    Timer timer;
    int tt=10;

    //activity_chart.xml
    LineChart lineChartAccuracy, lineChartRMS;
    Button btn1x3, btn3x3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        //        timerTask();
        //viewBinding
        lineChartAccuracy = findViewById(R.id.linechart_accuracy);
        lineChartRMS = findViewById(R.id.linechart_rms);
        btn1x3 = findViewById(R.id.button_1x3);
        btn3x3 = findViewById(R.id.button_3x3);

        lineChartAccuracy.setNoDataText("No Data available");
        lineChartAccuracy.getDescription().setEnabled(true);
        lineChartAccuracy.getDescription().setText("Real Time EMG Accuracy Plot  (%) ");
        lineChartAccuracy.setTouchEnabled(false); // 設定是否可以觸控
        lineChartAccuracy.setDragEnabled(false); // 是否可以拖拽
        lineChartAccuracy.setScaleEnabled(false); // 是否可以縮放 x和y軸, 預設是true
        lineChartAccuracy.setDrawGridBackground(true); // 背景網格
        lineChartAccuracy.setPinchZoom(false); //設定x軸和y軸能否同時縮放。預設是否
        lineChartAccuracy.setBackgroundColor(Color.WHITE);

        LineData lineData = new  LineData();
        lineData.setValueTextColor(Color.BLACK);
        lineChartAccuracy.setData(lineData);

        Legend legendAccuracy = lineChartAccuracy.getLegend();
        legendAccuracy.setForm(Legend.LegendForm.CIRCLE);
        legendAccuracy.setTextColor(Color.BLUE);

        XAxis xAxis = lineChartAccuracy.getXAxis();
        xAxis.setTextColor(Color.BLACK);
        xAxis.setAvoidFirstLastClipping(true);

        YAxis yAxis = lineChartAccuracy.getAxisLeft();
        yAxis.setTextColor(Color.BLACK);
        yAxis.setDrawGridLines(true);
        yAxis.setAxisMinimum(0f);
        yAxis.setAxisMaximum(100f);

        lineChartAccuracy.setDrawBorders(true);
        lineChartAccuracy.getXAxis().setDrawGridLines(true);




    }

    private void timerTask() {
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
