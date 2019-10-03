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

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    public ConstraintLayout top;
    //button
    public Button expandBtn;

    //Article 1
    public ConstraintLayout article1;
    public TextView newsHeadline1;
    public ImageView newsImage1;
    public Button expandBtn1;
    public Button shareBtn1;
    public int passArticle1;

    //Article 2
    public ConstraintLayout article2;
    public TextView newsHeadline2;
    public ImageView newsImage2;
    public Button expandBtn2;
    public Button shareBtn2;
    public int passArticle2;

    //Article 3
    public ConstraintLayout article3;
    public TextView newsHeadline3;
    public ImageView newsImage3;
    public Button expandBtn3;
    public Button shareBtn3;
    public int passArticle3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get article 1
        passArticle1 = FakeDatabase.getArticleById(1).getArticleID();

        //button to go to another activity
        top = findViewById(R.id.top);
        expandBtn = top.findViewById(R.id.expandBtn);
        expandBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //execute the explicit + pass data in
                Intent intentBtn1 = new Intent(getApplicationContext(), DetailActivity.class);
                //pass over a string to the other activity
                intentBtn1.putExtra("ArticleToPass1", passArticle1);
                startActivity(intentBtn1);

            }
        });

        //article 1
        article1 = findViewById(R.id.article1);
        newsHeadline1 = article1.findViewById(R.id.textView);
        newsHeadline1.setText("iPhones, Diamonds, Warlords and Mercenaries: Russia’s New Playbook in Africa");
        newsImage1 = article1.findViewById(R.id.imageView);
        newsImage1.setImageResource(R.drawable.iphone);
        expandBtn1 = article1.findViewById(R.id.expandBtn);
        shareBtn1 = article1.findViewById(R.id.shareBtn);

        //when article 1 expand button is clicked
        expandBtn1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //execute the explicit + pass data in
                Intent intentBtn1a = new Intent(getApplicationContext(), DetailActivity.class);
                //pass over a string to the other activity
                intentBtn1a.putExtra("ArticleToPass1", passArticle1);
                startActivity(intentBtn1a);

            }
        });

        //when article 1 share button is clicked
        shareBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Intent initiated", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

//intent for the button send thing
                Intent textIntent = new Intent(Intent.ACTION_SEND);
                textIntent.setType("text/plain");
                startActivity(textIntent);

            }
        });

        //when article 1 constraint layout button is clicked
        article1.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                //execute the explicit + pass data in
                Intent intentBtn1 = new Intent(getApplicationContext(), DetailActivity.class);
                //pass over a string to the other activity
                intentBtn1.putExtra("ArticleToPass", passArticle2);
                startActivity(intentBtn1);

            }
        });

        //article 2
        article2 = findViewById(R.id.article2);
        newsHeadline2 = article2.findViewById(R.id.textView);
        newsHeadline2.setText("Biden’s Digital Ads Are Disappearing. ‘Not a Good Sign,’ Strategists Say.");
        newsImage2 = article2.findViewById(R.id.imageView);
        newsImage2.setImageResource(R.drawable.drought);
        expandBtn2 = article2.findViewById(R.id.expandBtn);
        shareBtn2 = article2.findViewById(R.id.shareBtn);

        //get article 2
        passArticle2 = FakeDatabase.getArticleById(2).getArticleID();

        //when article 2 expand button is clicked
        expandBtn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //execute the explicit + pass data in
                Intent intentBtn2 = new Intent(getApplicationContext(), DetailActivity.class);
                //pass over a string to the other activity
                intentBtn2.putExtra("ArticleToPass", passArticle2);
                startActivity(intentBtn2);

            }
        });

        //when article 2 share button is clicked
        shareBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Intent initiated", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

//intent for the button send thing
                Intent textIntent2 = new Intent(Intent.ACTION_SEND);
                textIntent2.setType("text/plain");
                startActivity(textIntent2);

            }
        });

        //when article 2 constraint layout button is clicked
        article2.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                //execute the explicit + pass data in
                Intent intentBtn2 = new Intent(getApplicationContext(), DetailActivity.class);
                //pass over a string to the other activity
                intentBtn2.putExtra("ArticleToPass", passArticle2);
                startActivity(intentBtn2);

            }
        });

        //article 3
        article3 = findViewById(R.id.article3);
        newsHeadline3 = article3.findViewById(R.id.textView);
        newsHeadline3.setText("France Marks a Day of Mourning for Jacques Chirac");
        newsImage3 = article3.findViewById(R.id.imageView);
        newsImage3.setImageResource(R.drawable.bed);
        expandBtn3 = article3.findViewById(R.id.expandBtn);
        shareBtn3 = article3.findViewById(R.id.shareBtn);

        //get article 3
        passArticle3 = FakeDatabase.getArticleById(3).getArticleID();

        //when article 3 expand button is clicked
        expandBtn3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //execute the explicit + pass data in
                Intent intentBtn3 = new Intent(getApplicationContext(), DetailActivity.class);
                //pass over a string to the other activity
                intentBtn3.putExtra("ArticleToPass", passArticle3);
                startActivity(intentBtn3);

            }
        });

        //when article 3 share button is clicked
        shareBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Intent initiated", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

//intent for the button send thing
                Intent textIntent3 = new Intent(Intent.ACTION_SEND);
                textIntent3.setType("text/plain");
                startActivity(textIntent3);

            }
        });

        //when article 1 constraint layout button is clicked
        article3.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                //execute the explicit + pass data in
                Intent intentBtn3 = new Intent(getApplicationContext(), DetailActivity.class);
                //pass over a string to the other activity
                intentBtn3.putExtra("ArticleToPass", passArticle3);
                startActivity(intentBtn3);

            }
        });

    }
}
