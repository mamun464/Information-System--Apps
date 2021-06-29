package com.example.information;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;

import com.agrawalsuneet.dotsloader.loaders.CircularDotsLoader;

import java.util.Timer;
import java.util.TimerTask;

public class regi_loader extends AppCompatActivity {
    Timer set_time;
    CircularDotsLoader reg_loading;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regi_loader);
        reg_loading=(CircularDotsLoader)findViewById(R.id.reg_loading);
        set_time=new Timer();
        CircularDotsLoader loader = new CircularDotsLoader(this);
        loader.setDefaultColor(ContextCompat.getColor(this,R.color.amber));
        loader.setSelectedColor(ContextCompat.getColor(this,R.color.green));
        loader.setShowRunningShadow(true);
        loader.setFirstShadowColor(ContextCompat.getColor(this, R.color.red));
        loader.setSecondShadowColor(ContextCompat.getColor(this, R.color.colorAccent));

        set_time.schedule(new TimerTask() {
            @Override
            public void run() {

                Intent go_reg=new Intent(regi_loader.this,com.example.information.info_form.class);
                startActivity(go_reg);
                finish();

            }
        },1500);
    }
}