package com.example.information;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;


public class contact extends AppCompatActivity {
    TextView tv_A_cnact,contact_name;
    ImageView imo_show;
    CardView call_card,profile_card,map_card,exit_card;
    Button new_reg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);


        tv_A_cnact=findViewById(R.id.tv_A_cnact);
        contact_name=findViewById(R.id.contact_name);
        imo_show=findViewById(R.id.imo_show);
        call_card=findViewById(R.id.call_card);
        profile_card=findViewById(R.id.profile_card);
        map_card=findViewById(R.id.map_card);
        exit_card=findViewById(R.id.exit_card);
        new_reg=findViewById(R.id.new_reg);


        final String name=getIntent().getStringExtra("pass_name").trim()+"'s Details Here:";
        final String phn="tel:"+getIntent().getStringExtra("pass_number");
        final String url="http://"+getIntent().getStringExtra("pass_url");
        final String address="geo:0,0?q="+getIntent().getStringExtra("pass_address");
        String F_reaction=getIntent().getStringExtra("pass_reaction");
        String imo=getIntent().getStringExtra("imoji");

       switch(imo) {
            case "happy":
                tv_A_cnact.setText(F_reaction);
                contact_name.setText(name);
                imo_show.setImageResource(R.drawable.happy);
                break;
            case "sad":
                tv_A_cnact.setText(F_reaction);
                contact_name.setText(name);
                imo_show.setImageResource(R.drawable.sad);
                break;
            case "neutral":
                tv_A_cnact.setText(F_reaction);
                contact_name.setText(name);
                imo_show.setImageResource(R.drawable.neutral);
                break;
        }

        call_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dial=new Intent(Intent.ACTION_DIAL,Uri.parse(phn) );
                startActivity(dial);
            }
        });

        profile_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent visit=new Intent(Intent.ACTION_VIEW,Uri.parse(url) );
                startActivity(visit);

            }
        });
        map_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent visit=new Intent(Intent.ACTION_VIEW,Uri.parse(address) );
                startActivity(visit);

            }
        });

        exit_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);

            }
        });
        new_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent go_form_act=new Intent(contact.this,com.example.information.info_form.class);
                startActivity(go_form_act);
                Intent go_contact_load=new Intent(contact.this,com.example.information.contact_load.class);
                startActivity(go_contact_load);

            }
        });
    }
}