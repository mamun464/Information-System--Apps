package com.example.information;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;

import com.agrawalsuneet.dotsloader.loaders.CircularDotsLoader;

import java.util.Timer;
import java.util.TimerTask;

public class contact_load extends AppCompatActivity {
    CircularDotsLoader contact_loading;
    Timer set_time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_load);
        contact_loading=(CircularDotsLoader)findViewById(R.id.contact_loading);
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

                finish();


            }
        },1500);

    }
}