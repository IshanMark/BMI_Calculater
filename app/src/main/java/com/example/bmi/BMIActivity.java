package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BMIActivity extends AppCompatActivity {

    private android.widget.Button recaculatebmi;
    private TextView bmidisplay, bmicateogory, gender;
    private Intent intent;
    private ImageView imageView;
    private String bmi;
    private float intbmi;

    private String height, weight;
    private float intheight,intweight;
    private RelativeLayout background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        intent = getIntent();
        bmidisplay=findViewById(R.id.bmidisplay);
        bmicateogory = findViewById(R.id.bmicatagory);
        gender = findViewById(R.id.genderdisplay);
        background = findViewById(R.id.contentlayout);
        imageView= findViewById(R.id.imageview);

        height = intent.getStringExtra("height");
        weight = intent.getStringExtra("weight");

        intheight = Float.parseFloat(height);
        intweight = Float.parseFloat(weight);

        intheight = intheight/100;

        intbmi = intweight / (intheight*intheight);
        bmi =Float.toString(intbmi);

        if (intbmi < 16) {
            bmicateogory.setText("Severe Thinness");
            background.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.wrong);
        }else if (intbmi < 17){
            bmicateogory.setText("Moderate Thinness");
            background.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.wrong);
        }else if (intbmi<18.4){
            bmicateogory.setText("Mild Thinness");
            background.setBackgroundColor(Color.YELLOW);
            imageView.setImageResource(R.drawable.yellowronge);
        }
        else if(intbmi<25){
            bmicateogory.setText("Normal");
            background.setBackgroundColor(Color.GREEN);
            imageView.setImageResource(R.drawable.done);
        }
        else if(intbmi<40){
            bmicateogory.setText("Overweight");
            background.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.wrong);
        }
        else {
            bmicateogory.setText("Obese");
            background.setBackgroundColor(Color.RED);
            imageView.setImageResource(R.drawable.wrong);
        }

        gender.setText(intent.getStringExtra("gender"));
        bmidisplay.setText(bmi);

        recaculatebmi = findViewById(R.id.recalculatebmi);

        recaculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BMIActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}