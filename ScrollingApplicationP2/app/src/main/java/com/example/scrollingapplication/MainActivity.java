package com.example.scrollingapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

//recycle view: https://www.youtube.com/watch?v=Vyqz_-sJGFk

public class MainActivity extends AppCompatActivity {
    public ConstraintLayout top;
    //button
    public Button expandBtn;

    //spinner
    public Spinner topSpin;

    //others from Adapter
    public ArrayList<Integer> imageIds = new ArrayList<>();
    public ArrayList<String> articleSummary = new ArrayList<>();
    public ArrayList<Integer> articleIds = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button to go to another activity
        top = findViewById(R.id.top);

        //Spinners test
        topSpin = findViewById(R.id.topSpin);
        //Create an ArrayAdapter using array in string resources
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this, R.array.newsArray, android.R.layout.simple_spinner_item);
        //Layout to use when list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //apply adapter to spinner
        topSpin.setAdapter(adapter);
        //more information
        //https://developer.android.com/guide/topics/ui/controls/spinner

        initArticleIds();
        initArticleSummary();
        initImageIds();
        initRecyclerViewer();

    }

    //method is to obtain the articleIds and place them into an arrayList
    public void initArticleIds() {
        articleIds.add(FakeDatabase.getArticleById(1).getArticleID());
        articleIds.add(FakeDatabase.getArticleById(2).getArticleID());
        articleIds.add(FakeDatabase.getArticleById(3).getArticleID());
        articleIds.add(FakeDatabase.getArticleById(4).getArticleID());
        articleIds.add(FakeDatabase.getArticleById(5).getArticleID());
        articleIds.add(FakeDatabase.getArticleById(6).getArticleID());
    }

    //method is to obtain the articleSummary and place them into an arrayList
    public void initArticleSummary() {
        articleSummary.add(FakeDatabase.getArticleById(1).getHeadline());
        articleSummary.add(FakeDatabase.getArticleById(2).getHeadline());
        articleSummary.add(FakeDatabase.getArticleById(3).getHeadline());
        articleSummary.add(FakeDatabase.getArticleById(4).getHeadline());
        articleSummary.add(FakeDatabase.getArticleById(5).getHeadline());
        articleSummary.add(FakeDatabase.getArticleById(6).getHeadline());

    }

    //method is to obtain the imageIds and place them into an arrayList
    public void initImageIds() {
        imageIds.add(R.drawable.centralafrica);
        imageIds.add(R.drawable.bidens);
        imageIds.add(R.drawable.francemourn);
        imageIds.add(R.drawable.inmates);
        imageIds.add(R.drawable.northpole);
        imageIds.add(R.drawable.posthappy);
    }

    //method is to initialise the recyclerViewer
    public void initRecyclerViewer(){
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        //the arrayLists to put inside the RecycleView Adapter
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(imageIds, articleSummary, articleIds, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    //references
    //https://stackoverflow.com/questions/37786796/how-to-display-an-arraylist-in-a-recyclerview
    //https://stackoverflow.com/questions/35817610/large-gap-forms-between-recyclerview-items-when-scrolling-down
    //https://stackoverflow.com/questions/51646852/recyclerview-slow-scrolling-performance-and-lag-halt-sometime-while-scrolling
    //https://stackoverflow.com/questions/28528009/start-new-intent-from-recyclerviewadapter
    //https://stackoverflow.com/questions/42468113/how-can-i-use-getresources-inside-of-onbindviewholder
}
