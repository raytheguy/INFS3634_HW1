package com.example.scrollingapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public ConstraintLayout top;
    //button
    public Button expandBtn;

    public ConstraintLayout article1;
    public TextView newsHeadline1;
    public ImageView newsImage1;

    public ConstraintLayout article2;
    public TextView newsHeadline2;
    public ImageView newsImage2;

    public ConstraintLayout article3;
    public TextView newsHeadline3;
    public ImageView newsImage3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String passString = "This is a string to pass";

        //button to go to another activity
        top = findViewById(R.id.top);
        expandBtn = top.findViewById(R.id.expandBtn);
        expandBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //execute the explicit + pass data in
                Intent intentBtn1 = new Intent(getApplicationContext(), DetailActivity.class);
                //pass over a string to the other activity
                intentBtn1.putExtra("StringToPass", passString);
                startActivity(intentBtn1);

            }
        });

        //article 1
        article1 = findViewById(R.id.article1);
        newsHeadline1 = article1.findViewById(R.id.textView);
        newsHeadline1.setText("Is iPhones worth it over other phones?");
        newsImage1 = article1.findViewById(R.id.imageView);
        newsImage1.setImageResource(R.drawable.iphone);

        //article 2
        article2 = findViewById(R.id.article2);
        newsHeadline2 = article2.findViewById(R.id.textView);
        newsHeadline2.setText("Are we doomed with the lack of rain?");
        newsImage2 = article2.findViewById(R.id.imageView);
        newsImage2.setImageResource(R.drawable.drought);

        //article 3
        article3 = findViewById(R.id.article3);
        newsHeadline3 = article3.findViewById(R.id.textView);
        newsHeadline3.setText("Does sleeping cause cancer? Should we avoid sleeping?");
        newsImage3 = article3.findViewById(R.id.imageView);
        newsImage3.setImageResource(R.drawable.bed);

    }
}
