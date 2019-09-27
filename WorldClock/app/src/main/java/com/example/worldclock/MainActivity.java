package com.example.worldclock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Switch;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.Calendar;
import java.util.TimeZone;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;


public class MainActivity extends AppCompatActivity {

    //Button or Switch for time type (i.e. 12hr or 24hr)
    Button timeTypeButton;
    Switch timeSwitch;

    //textViews for City names
    TextView city1Name;
    TextView city2Name;
    TextView city3Name;
    TextView city4Name;
    TextView city5Name;

    //textViews for times
    TextView timeZone1;
    TextView timeZone2;
    TextView timeZone3;
    TextView timeZone4;
    TextView timeZone5;

    //imageViews for Cities
    ImageView cityImage1;
    ImageView cityImage2;
    ImageView cityImage3;
    ImageView cityImage4;
    ImageView cityImage5;

    //Declare ConstraintLayout
    public ConstraintLayout box1;
    public ConstraintLayout box2;
    public ConstraintLayout box3;
    public ConstraintLayout box4;
    public ConstraintLayout box5;

    public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
    public SimpleDateFormat sdfSyd = new SimpleDateFormat("hh:mm a");
    public int testing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //city 1 linkage
        box1 = findViewById(R.id.box1);
        city1Name = box1.findViewById(R.id.city);
        city1Name.setText("Sydney");
        timeZone1 = box1.findViewById(R.id.clock);
        cityImage1 = box1.findViewById(R.id.image);
        cityImage1.setImageResource(R.drawable.sydney2);

        //city 2 linkage
        box2 = findViewById(R.id.box2);
        city2Name = box2.findViewById(R.id.city);
        city2Name.setText("Auckland");
        timeZone2 = box2.findViewById(R.id.clock);
        cityImage2 = box2.findViewById(R.id.image);
        cityImage2.setImageResource(R.drawable.auckland);

        //city 3 linkage
        box3 = findViewById(R.id.box3);
        city3Name = box3.findViewById(R.id.city);
        city3Name.setText("Tokyo");
        timeZone3 = box3.findViewById(R.id.clock);
        cityImage3 = box3.findViewById(R.id.image);
        cityImage3.setImageResource(R.drawable.tokyo);

        //city 4 linkage
        box4 = findViewById(R.id.box4);
        city4Name = box4.findViewById(R.id.city);
        city4Name.setText("Beijing");
        timeZone4 = box4.findViewById(R.id.clock);
        cityImage4 = box4.findViewById(R.id.image);
        cityImage4.setImageResource(R.drawable.beijing2);

        //city 5 linkage
        box5 = findViewById(R.id.box5);
        city5Name = box5.findViewById(R.id.city);
        city5Name.setText("New York");
        timeZone5 = box5.findViewById(R.id.clock);
        cityImage5 = box5.findViewById(R.id.image);
        cityImage5.setImageResource(R.drawable.newyork);

        timeZones();

    }

    public void timeZones(){
        final Switch timeSwitch = findViewById(R.id.switch2);
        final Handler timeHandler = new Handler(getMainLooper());

        //runnable to have the time keep refreshing
        timeHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                timeHandler.postDelayed(this, 1000);

                timeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                        if (isChecked) {
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                            testing = 1;
                        } else {
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
                            testing = 0;
                        }
                    }
                });

                if (testing == 1){
                    formatter = DateTimeFormatter.ofPattern("HH:mm");
                    sdfSyd = new SimpleDateFormat("HH:mm");
                }
                else {
                    formatter = DateTimeFormatter.ofPattern("hh:mm a");
                    sdfSyd = new SimpleDateFormat("hh:mm a");
                }

                //phone time
                final long curTime = System.currentTimeMillis();
                String dateString = sdfSyd.format(curTime);
                timeZone1.setText(dateString);

                //time zone for auckland
                ZoneId zoneIdAuckland = ZoneId.of("Pacific/Auckland");
                LocalTime localTimeAuckland=LocalTime.now(zoneIdAuckland);
                String formattedTimeAuckland=localTimeAuckland.format(formatter);
                timeZone2.setText(formattedTimeAuckland);

                //time zone for tokyo
                ZoneId zoneId = ZoneId.of("Asia/Tokyo");
                LocalTime localTime=LocalTime.now(zoneId);
                String formattedTime=localTime.format(formatter);
                timeZone3.setText(formattedTime);

                //time zone for beijing
                ZoneId zoneIdBeijing = ZoneId.of("Asia/Shanghai");
                LocalTime localTimeBeijing=LocalTime.now(zoneIdBeijing);
                String formattedTimeBeijing=localTimeBeijing.format(formatter);
                timeZone4.setText(formattedTimeBeijing);

                //time zone for new york
                ZoneId zoneIdNewYork = ZoneId.of("America/New_York");
                LocalTime localTimeNewYork=LocalTime.now(zoneIdNewYork);
                String formattedTimeNewYork=localTimeNewYork.format(formatter);
                timeZone5.setText(formattedTimeNewYork);

            }
        }, 10);


    }

    }

