package com.example.scrollingapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.widget.ImageView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
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

        article1 = findViewById(R.id.article1);
        newsHeadline1 = article1.findViewById(R.id.textView);
        newsHeadline1.setText("Is iPhones worth it over other phones?");
        newsImage1 = article1.findViewById(R.id.imageView);
        newsImage1.setImageResource(R.drawable.iphone);

        article2 = findViewById(R.id.article2);
        newsHeadline2 = article2.findViewById(R.id.textView);
        newsHeadline2.setText("Are we doomed with the lack of rain?");
        newsImage2 = article2.findViewById(R.id.imageView);
        newsImage2.setImageResource(R.drawable.drought);

        article3 = findViewById(R.id.article3);
        newsHeadline3 = article3.findViewById(R.id.textView);
        newsHeadline3.setText("Does sleeping cause cancer? Should we avoid sleeping?");
        newsImage3 = article3.findViewById(R.id.imageView);
        newsImage3.setImageResource(R.drawable.bed);



    }
}
