package com.example.worldclock;

import android.app.ActionBar;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Switch;

public class SettingsActivity extends AppCompatActivity {

    //city 1
    Switch switch1;
    int city1Status;

    //city 2
    Switch switch2;
    int city2Status;

    //city 3
    Switch switch3;
    int city3Status;

    //city 4
    Switch switch4;
    int city4Status;

    //city 5
    Switch switch5;
    int city5Status;

    //city 6
    Switch switch6;
    int city6Status;

    //city 7
    Switch switch7;
    int city7Status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        switchInitialise();

    }

    public void switchInitialise(){
        //city 1
        switch1 = findViewById(R.id.switch1);

        //city 2
        switch2 = findViewById(R.id.switch2);

        //city 3
        switch3 = findViewById(R.id.switch3);

        //city 4
        switch4 = findViewById(R.id.switch4);

        //city 5
        switch5 = findViewById(R.id.switch5);

        //city 6
        switch6 = findViewById(R.id.switch6);

        //city 7
        switch7 = findViewById(R.id.switch7);

    }

}
