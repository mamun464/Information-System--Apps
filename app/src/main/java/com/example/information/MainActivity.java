package com.example.information;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.agrawalsuneet.dotsloader.loaders.AllianceLoader;
import com.agrawalsuneet.dotsloader.loaders.LazyLoader;

public class MainActivity extends AppCompatActivity {

    Button btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreate=findViewById(R.id.btnCreate);




        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent go_form=new Intent(MainActivity.this,com.example.information.regi_loader.class);
                startActivity(go_form);
                finish();

            }
        });
    }
}