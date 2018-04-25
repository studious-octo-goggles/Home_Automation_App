package com.example.prateek.myhome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);


    }
    public void onResume()
    {
        super.onResume();
        Thread t=new Thread()
        {
            public void run()
            {
                try
                {
                    Thread.sleep(3000);
                }
                catch (Exception e)
                {
                }
                startActivity(new Intent(MainActivity.this, SmartHome.class));
                finish();
            }

        };
        t.start();
    }
}
