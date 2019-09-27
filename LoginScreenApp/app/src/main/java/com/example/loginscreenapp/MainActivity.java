package com.example.loginscreenapp;

//import stuff required
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;

//import views
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //declare a button, textviews and textboxes
    //only initialise them after onCreate = what the app loads when starting
    //https://stackoverflow.com/questions/36666091/attempt-to-invoke-virtual-method-android-view-windowcallback-android-view-wind
    public Button btn;
    public TextView userName;
    public EditText passwordBox ;
    public TextView bottomText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //link the widgets to java
        btn = findViewById(R.id.loginButton);
        userName = findViewById(R.id.loginText);
        passwordBox = findViewById(R.id.passwordText);
        bottomText = findViewById(R.id.bottomText);

        //code for buttonOnClick
        //https://developer.android.com/reference/android/widget/Button#top_of_page
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                buttonClick();
            }

        });

    }

    //the method to be called for clicking on the button
    public void buttonClick(){
        bottomText.setText("You clicked on it!");
        bottomText.setVisibility(View.VISIBLE);
    }

}
