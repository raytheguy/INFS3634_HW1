package com.example.scrollingapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //retrieve the string and place it into the textView
        Intent intentBtn1 = getIntent();
        //get back the string -> note there is no default string
        String backString = intentBtn1.getStringExtra("StringToPass");
        //find the textView
        TextView topText = findViewById(R.id.topText);
        topText.setText(backString);

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
