package com.example.administrator.dame;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    LargeImageView mLargeImageView;
    private Timer timer;
    int i=0;
    @SuppressLint("HandlerLeak")
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
           if(msg.what==5){
               Intent intent = new Intent(MainActivity.this, Main2Activity.class);
               startActivity(intent);
           }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLargeImageView = (LargeImageView) findViewById(R.id.id_largetImageview);
        try
        {
            InputStream inputStream = getAssets().open("world.jpg");
            mLargeImageView.setInputStream(inputStream);

        } catch (IOException e)
        {
            e.printStackTrace();
        }
        final Intent it = new Intent(this, Main2Activity.class); //你要转向的Activity
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                startActivity(it); //执行
            }
        };
        timer.schedule(task, 1000 * 10); //10秒后


    }
}
