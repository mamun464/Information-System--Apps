package com.example.information;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;

import com.agrawalsuneet.dotsloader.loaders.AllianceLoader;
import com.agrawalsuneet.dotsloader.loaders.CircularDotsLoader;
import com.agrawalsuneet.dotsloader.loaders.LazyLoader;

import java.util.Timer;
import java.util.TimerTask;

public class open_loadling extends AppCompatActivity {
    CircularDotsLoader open_loading;
    Timer set_time;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_loadling);

         open_loading=(CircularDotsLoader)findViewById(R.id.open_loading);
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

                    Intent go_main=new Intent(open_loadling.this,com.example.information.MainActivity.class);
                    startActivity(go_main);
                    finish();

            }
        },2500);



    }
}