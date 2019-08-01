package com.mayendrams.cekrek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Opening extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opening);

        clicklogin();
        clickregister();
    }
    public void clicklogin(){
        Button masuklogin = (Button) findViewById(R.id.btnloginopen);
        masuklogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Opening.this, Login.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
//                finish();
            }
        });
    }

    public void clickregister(){
        Button masukregister = (Button) findViewById(R.id.btnregisteropen);
        masukregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Opening.this, Register.class);
//                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
//                finish();
            }
        });

    }


}