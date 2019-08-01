package com.mayendrams.cekrek;

//NIM               : 10117613
//NAMA              : Mayendra Muhammad Shiddiq
//Tanggal Dibuat    : 30-04-2019

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class SplashActivity extends Activity {

    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashfile);

        handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this,Opening.class);
                startActivity(intent);
                finish();
            }
        },1000);

    }
}