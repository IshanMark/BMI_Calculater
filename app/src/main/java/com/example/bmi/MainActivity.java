package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private android.widget.Button calculatebmi;

    private TextView currentheight,currentweight,currentage;
    private ImageView incrementage,descrementage, incrementweight,descrementweight;
    private SeekBar seekbarforheight;
    private RelativeLayout  male, female;

    private int weight = 70;
    private int age = 22;
    private int currentprogress;
    private String mintprogress ="170";
    private String typeofuser = "0";
    private String weight2 = "70";
    private String age2 = "22";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        calculatebmi = findViewById(R.id.calculatebmi);
        currentage = findViewById(R.id.currentage);
        currentweight = findViewById(R.id.currentweight);
        currentheight = findViewById(R.id.currentheight);
        incrementage = findViewById(R.id.incrementage);
        descrementage = findViewById(R.id.decrementage);
        incrementweight = findViewById(R.id.incrementweight);
        descrementweight = findViewById(R.id.decrementweight);
        seekbarforheight = findViewById(R.id.seekbarforheight);
        male = findViewById(R.id.male);
        female = findViewById(R.id.female);

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemaleforcus));
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotforcus));
                typeofuser="Male";
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                female.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemaleforcus));
                male.setBackground(ContextCompat.getDrawable(getApplicationContext(),R.drawable.malefemalenotforcus));
                typeofuser="Female";
            }
        });

        seekbarforheight.setMax(300);

        seekbarforheight.setProgress(170);
        seekbarforheight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                 currentprogress = progress;
                 mintprogress = String.valueOf(currentprogress);
                 currentheight.setText(mintprogress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        incrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                age = age+1;
                age2= String.valueOf(age);
                currentage.setText(age2);
            }
        });
        descrementage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                age = age-1;
                age2= String.valueOf(age);
                currentage.setText(age2);
            }
        });
        incrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weight = weight+1;
                weight2= String.valueOf(weight);
                currentweight.setText(weight2);
            }
        });
        descrementweight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                weight = weight-1;
                weight2= String.valueOf(weight);
                currentweight.setText(weight2);
            }
        });

        calculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (typeofuser.equals("0")){
                    Toast.makeText(getApplicationContext(),"Select your Gender first",Toast.LENGTH_SHORT).show();
                }
                else if (mintprogress.equals("0")){
                    Toast.makeText(getApplicationContext(),"Select your Height first",Toast.LENGTH_SHORT).show();
                }
                else if(age ==0 || age<0){
                    Toast.makeText(getApplicationContext(),"Age is Incorrect",Toast.LENGTH_SHORT).show();
                }
                else if(weight ==0 || weight<0){
                    Toast.makeText(getApplicationContext(),"Weight is Incorrect",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(MainActivity.this, BMIActivity.class);
                    intent.putExtra("gender",typeofuser);
                    intent.putExtra("height",mintprogress);
                    intent.putExtra("weight",weight2);
                    intent.putExtra("age",age2);

                    startActivity(intent);
                }
            }
        });
    }
}