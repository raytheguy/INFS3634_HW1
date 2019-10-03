package com.example.scrollingapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.widget.Button;

import android.view.View;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public TextView articleText;
    public TextView headLineText;
    public TextView authorText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //retrieve the string and place it into the textView
        Intent intentBtn1 = getIntent();
//        //get back the string -> note there is no default string
        int backString = intentBtn1.getIntExtra("ArticleToPass", 1);

        articleText = findViewById(R.id.mainLine);
        articleText.setText(FakeDatabase.getArticleById(backString).getContent());

        headLineText = findViewById(R.id.headLine);
        headLineText.setText(FakeDatabase.getArticleById(backString).getHeadline());

        authorText = findViewById(R.id.authorText);
        authorText.setText(FakeDatabase.getArticleById(backString).getAuthor());

        //retrieve the string and place it into the textView
//        Intent intentBtn1 = getIntent();
//        //get back the string -> note there is no default string
//        String backString = intentBtn1.getStringExtra("StringToPass");
//        //find the textView
//        TextView topText = findViewById(R.id.topText);
//        topText.setText(backString);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
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


    }

}
