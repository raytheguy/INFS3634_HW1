package com.example.worldclock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Switch;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.LocalDateTime;
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


//resolve error
//https://stackoverflow.com/questions/28353835/namespace-app-not-bound-in-android-studio-with-external-lib-from-maven

//images from: https://www.flaticon.com/


public class MainActivity extends AppCompatActivity {

    //Declare ConstraintLayout
    public ConstraintLayout box1;
    public ConstraintLayout box2;
    public ConstraintLayout box3;
    public ConstraintLayout box4;
    public ConstraintLayout box5;
    public ConstraintLayout box6;
    public ConstraintLayout box7;
    public DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
    public SimpleDateFormat sdfSyd = new SimpleDateFormat("hh:mm a");

    //declare int values that  can be changed
    public int testing;
    public int nightActivate = 0;
    //Button or Switch for time type (i.e. 12hr or 24hr)
    Button timeTypeButton;
    Switch timeSwitch;
    //Image Button
    ImageButton nightMode;
    //textViews for City names
    TextView city1Name;
    TextView city2Name;
    TextView city3Name;
    TextView city4Name;
    TextView city5Name;
    TextView city6Name;
    TextView city7Name;
    //textViews for times
    TextView timeZone1;
    TextView timeZone2;
    TextView timeZone3;
    TextView timeZone4;
    TextView timeZone5;
    TextView timeZone6;
    TextView timeZone7;
    //imageViews for Cities
    ImageView cityImage1;
    ImageView cityImage2;
    ImageView cityImage3;
    ImageView cityImage4;
    ImageView cityImage5;
    ImageView cityImage6;
    ImageView cityImage7;

    //mainBackground
    ConstraintLayout mainBack;

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

        //city 6 linkage
        box6 = findViewById(R.id.box6);
        city6Name = box6.findViewById(R.id.city);
        city6Name.setText("London");
        timeZone6 = box6.findViewById(R.id.clock);
        cityImage6 = box6.findViewById(R.id.image);
        cityImage6.setImageResource(R.drawable.london);

        //city 7 linkage
        box7 = findViewById(R.id.box7);
        city7Name = box7.findViewById(R.id.city);
        city7Name.setText("San Francisco");
        timeZone7 = box7.findViewById(R.id.clock);
        cityImage7 = box7.findViewById(R.id.image);
        cityImage7.setImageResource(R.drawable.sanfrancisco);

        //ImageButton Linkage
        nightMode = findViewById(R.id.nightButton);
        //nightmode invocation of activation method

        //main background
        mainBack = findViewById(R.id.mainBackGround);

        //invoke timeZones method
        timeZones();

    }

    public void timeZones() {
        final Switch timeSwitch = findViewById(R.id.switch2);
        final Handler timeHandler = new Handler(getMainLooper());
        //final night button
        nightMode = findViewById(R.id.nightButton);
//        nightMode.setImageResource(R.drawable.diffmoon);
        System.out.println("Finished");

        //runnable to have the time keep refreshing
        timeHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                timeHandler.postDelayed(this, 1000);

                timeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                        if (isChecked) {
                            testing = 1;
                        } else {
                            testing = 0;
                        }
                    }
                });

                if (testing == 1) {
                    formatter = DateTimeFormatter.ofPattern("EEE HH:mm");
                    sdfSyd = new SimpleDateFormat("EEE HH:mm");
                } else {
                    formatter = DateTimeFormatter.ofPattern("EEE hh:mm a");
                    sdfSyd = new SimpleDateFormat("EEE hh:mm a");
                }

                nightModeActivation();

                //phone time
                final long curTime = System.currentTimeMillis();
                String dateString = sdfSyd.format(curTime);
                timeZone1.setText(dateString);

                //time zone list:
                //https://garygregory.wordpress.com/2013/06/18/what-are-the-java-timezone-ids/

                //time zone for auckland
                ZoneId zoneIdAuckland = ZoneId.of("Pacific/Auckland");
                LocalDateTime localDateTimeAuckland = LocalDateTime.now(zoneIdAuckland);
                String formattedTimeAuckland = localDateTimeAuckland.format(formatter);
                timeZone2.setText(formattedTimeAuckland);

                //time zone for tokyo
                ZoneId zoneId = ZoneId.of("Asia/Tokyo");
                LocalDateTime localDateTime = LocalDateTime.now(zoneId);
                String formattedTime = localDateTime.format(formatter);
                timeZone3.setText(formattedTime);

                //time zone for beijing
                ZoneId zoneIdBeijing = ZoneId.of("Asia/Shanghai");
                LocalDateTime localDateTimeBeijing = LocalDateTime.now(zoneIdBeijing);
                String formattedTimeBeijing = localDateTimeBeijing.format(formatter);
                timeZone4.setText(formattedTimeBeijing);

                //time zone for new york
                ZoneId zoneIdNewYork = ZoneId.of("America/New_York");
                LocalDateTime localDateTimeNewYork = LocalDateTime.now(zoneIdNewYork);
                String formattedTimeNewYork = localDateTimeNewYork.format(formatter);
                timeZone5.setText(formattedTimeNewYork);

                //time zone for london
                ZoneId zoneIdLondon = ZoneId.of("Europe/London");
                LocalDateTime localDateTimeLondon = LocalDateTime.now(zoneIdLondon);
                String formattedTimeLondon = localDateTimeLondon.format(formatter);
                timeZone6.setText(formattedTimeLondon);

                //time zone for san francisco
                //note time zone in Los Angeles is the same as san francisco
                ZoneId zoneIdSF = ZoneId.of("America/Los_Angeles");
                LocalDateTime localDateTimeSF = LocalDateTime.now(zoneIdSF);
                String formattedTimeSF = localDateTimeSF.format(formatter);
                timeZone7.setText(formattedTimeSF);

            }
        }, 5);

    }

    public void nightModeActivation() {

        nightMode.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //if nightActivate = 0; then turn on night mode
                if (nightActivate == 0) {
                    nightActivate = 1;
                    mainBack.setBackgroundColor(000000);
                    System.out.println("night mode activated");
                }
                //if nightActivate = 1; then turn off night mode
                else {
                    nightActivate = 0;
                    mainBack.setBackgroundColor(0xEBFF9D0E);
                    System.out.println("night mode deactivated");
                }
            }
        });

    }

}

//app made by Raymond z5161354
//other Resources Used
//https://www.tutlane.com/tutorial/android/android-switch-on-off-button-with-examples
//https://stackoverflow.com/questions/14053079/simpledateformat-returns-24-hour-date-how-to-get-12-hour-date
//https://dzone.com/articles/getting-current-date-time-in-java
//https://stackoverflow.com/questions/46101925/as-2-3-3-gradle-3-3-java-1-8-cant-resolve-import-for-java-time-format-datetim
//https://stackoverflow.com/questions/29952404/showing-current-time-in-android-and-updating-it
//https://stackoverflow.com/questions/17807777/simpledateformatstring-template-locale-locale-with-for-example-locale-us-for/17808060
//https://stackoverflow.com/questions/35771531/call-requires-api-level-23-current-min-is-14-android-app-activityrequestperm
//https://abhiandroid.com/androidstudio/change-api-sdk-level-android-studio.html
//https://stackoverflow.com/questions/11664303/accessing-a-variable-outside-of-an-if-statement
//https://stackoverflow.com/questions/14425826/variable-is-accessed-within-inner-class-needs-to-be-declared-final
//https://alvinalexander.com/source-code/android/android-checkbox-listener-setoncheckedchangelisteneroncheckedchangelistener-exam
//file:///C:/Users/Raymond/Downloads/Homework_Task_1.pdf
//https://stackoverflow.com/questions/5121976/is-there-a-date-format-to-display-the-day-of-the-week-in-java
//https://stackoverflow.com/questions/23069370/format-a-date-using-the-new-date-time-api
//https://medium.com/mindorks/11-android-studio-shortcuts-every-android-developer-must-know-a153e736e611








