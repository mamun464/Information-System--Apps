package com.example.information;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

import static com.basgeekball.awesomevalidation.utility.RegexTemplate.*;
import static com.example.information.R.id.etName_A_form;

public class info_form extends AppCompatActivity {
    EditText etName_A_form,etPhn_A_form,etWeb_A_form,etHome_A_form;
    ImageView happy,sad,neutral;
    AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_form);
        etName_A_form=findViewById(R.id.etName_A_form);
        etPhn_A_form=findViewById(R.id.etPhn_A_form);
        etWeb_A_form=findViewById(R.id.etWeb_A_form);
        etHome_A_form=findViewById(R.id.etHome_A_form);
        happy=findViewById(R.id.happy);
        sad=findViewById(R.id.sad);
        neutral=findViewById(R.id.neutral);

        awesomeValidation=new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this, R.id.etName_A_form,RegexTemplate.NOT_EMPTY,R.string.invalid_name);
        awesomeValidation.addValidation(this,R.id.etPhn_A_form, Patterns.PHONE,R.string.Invalid_Number);
        awesomeValidation.addValidation(this,R.id.etWeb_A_form,Patterns.WEB_URL,R.string.Valid_Url);
        awesomeValidation.addValidation(this,R.id.etHome_A_form, RegexTemplate.NOT_EMPTY,R.string.Invalid_Addreess);


        happy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(awesomeValidation.validate()){

                    Intent go_contact=new Intent(info_form.this,com.example.information.contact.class);
                    String name=etName_A_form.getText().toString().trim();
                    String number=etPhn_A_form.getText().toString().trim();
                    String url=etWeb_A_form.getText().toString().trim();
                    String address=etHome_A_form.getText().toString().trim();
                    String H_reaction="It's our pleasure that \"we made you happy\"";


                    go_contact.putExtra("pass_name",name);
                    go_contact.putExtra("pass_number",number);
                    go_contact.putExtra("pass_url",url);
                    go_contact.putExtra("pass_address",address);
                    go_contact.putExtra("imoji","happy");
                    go_contact.putExtra("pass_reaction",H_reaction.trim()) ;
                    startActivity(go_contact);
                    Intent go_contact_load=new Intent(info_form.this,com.example.information.contact_load.class);
                    startActivity(go_contact_load);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Fill up With Appropriate Value ",Toast.LENGTH_SHORT).show();

                }
            }
        });

        sad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(awesomeValidation.validate()){
                    Intent go_contact=new Intent(info_form.this,com.example.information.contact.class);
                    String name=etName_A_form.getText().toString().trim();
                    String number=etPhn_A_form.getText().toString().trim();
                    String url=etWeb_A_form.getText().toString().trim();
                    String address=etHome_A_form.getText().toString().trim();
                    String S_reaction="We're Sorry.Next time we try to make you happy";

                    go_contact.putExtra("pass_name",name);
                    go_contact.putExtra("pass_number",number);
                    go_contact.putExtra("pass_url",url);
                    go_contact.putExtra("pass_address",address);
                    go_contact.putExtra("imoji","sad");
                    go_contact.putExtra("pass_reaction",S_reaction.trim());
                    startActivity(go_contact);
                    Intent go_contact_load=new Intent(info_form.this,com.example.information.contact_load.class);
                    startActivity(go_contact_load);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Fill up With Appropriate Value ",Toast.LENGTH_SHORT).show();
                }
            }
        });
        neutral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(awesomeValidation.validate()){
                    Intent go_contact=new Intent(info_form.this,com.example.information.contact.class);
                    String name=etName_A_form.getText().toString().trim();
                    String number=etPhn_A_form.getText().toString().trim();
                    String url=etWeb_A_form.getText().toString().trim();
                    String address=etHome_A_form.getText().toString().trim();
                    String N_reaction="It's disappointing for us that \"we cannot make you happy\"";

                    go_contact.putExtra("pass_name",name);
                    go_contact.putExtra("pass_number",number);
                    go_contact.putExtra("pass_url",url);
                    go_contact.putExtra("pass_address",address);
                    go_contact.putExtra("imoji","neutral");
                    go_contact.putExtra("pass_reaction",N_reaction.trim());
                    startActivity(go_contact);
                    Intent go_contact_load=new Intent(info_form.this,com.example.information.contact_load.class);
                    startActivity(go_contact_load);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Fill up With Appropriate Value ",Toast.LENGTH_SHORT).show();
                }
            }
        });





    }
}