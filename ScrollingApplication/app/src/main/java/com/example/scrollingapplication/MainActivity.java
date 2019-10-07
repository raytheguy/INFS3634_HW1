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

    //Article 4
    public ConstraintLayout article4;
    public TextView newsHeadline4;
    public ImageView newsImage4;
    public Button expandBtn4;
    public Button shareBtn4;
    public int passArticle4;

    //Article 5
    public ConstraintLayout article5;
    public TextView newsHeadline5;
    public ImageView newsImage5;
    public Button expandBtn5;
    public Button shareBtn5;
    public int passArticle5;

    //Article 6
    public ConstraintLayout article6;
    public TextView newsHeadline6;
    public ImageView newsImage6;
    public Button expandBtn6;
    public Button shareBtn6;
    public int passArticle6;

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

        //article 1
        article1 = findViewById(R.id.article1);
        newsHeadline1 = article1.findViewById(R.id.textView);
        newsHeadline1.setText(FakeDatabase.getArticleById(1).getHeadline());
        newsImage1 = article1.findViewById(R.id.imageView);
        newsImage1.setImageResource(R.drawable.centralafrica);
        String article1Image = "centralafrica";
        final int article1ImgID = getResources().getIdentifier(article1Image, "drawable", getPackageName());
//        expandBtn1 = article1.findViewById(R.id.expandBtn);
        shareBtn1 = article1.findViewById(R.id.shareBtn);

        //get article 1
        passArticle1 = FakeDatabase.getArticleById(1).getArticleID();

        //when article 1 constraint layout button is clicked
        article1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //execute the explicit + pass data in
                Intent intentBtn1 = new Intent(getApplicationContext(), DetailActivity.class);
                //pass over a string to the other activity
                intentBtn1.putExtra("ArticleToPass", passArticle1);
                intentBtn1.putExtra("ImageToPass", article1ImgID);
                startActivity(intentBtn1);

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
                textIntent.putExtra(Intent.EXTRA_TEXT, FakeDatabase.getArticleById(1).getHeadline() + getResources().getString(R.string.NYTimes));
                startActivity(textIntent);

            }
        });

        //article 2
        article2 = findViewById(R.id.article2);
        newsHeadline2 = article2.findViewById(R.id.textView);
        newsHeadline2.setText(FakeDatabase.getArticleById(2).getHeadline());
        newsImage2 = article2.findViewById(R.id.imageView);
        newsImage2.setImageResource(R.drawable.bidens);
        String article2Image = "bidens";
        final int article2ImgID = getResources().getIdentifier(article2Image, "drawable", getPackageName());
//        expandBtn2 = article2.findViewById(R.id.expandBtn);
        shareBtn2 = article2.findViewById(R.id.shareBtn);

        //get article 2
        passArticle2 = FakeDatabase.getArticleById(2).getArticleID();

        //when article 2 share button is clicked
        shareBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Intent initiated", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

//intent for the button send thing
                Intent textIntent2 = new Intent(Intent.ACTION_SEND);
                textIntent2.setType("text/plain");
                textIntent2.putExtra(Intent.EXTRA_TEXT, FakeDatabase.getArticleById(2).getHeadline() + getResources().getString(R.string.NYTimes));
                startActivity(textIntent2);

            }
        });

        //when article 2 constraint layout button is clicked
        article2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //execute the explicit + pass data in
                Intent intentBtn2 = new Intent(getApplicationContext(), DetailActivity.class);
                //pass over a string to the other activity
                intentBtn2.putExtra("ArticleToPass", passArticle2);
                intentBtn2.putExtra("ImageToPass", article2ImgID);
                startActivity(intentBtn2);

            }
        });

        //article 3
        article3 = findViewById(R.id.article3);
        newsHeadline3 = article3.findViewById(R.id.textView);
        newsHeadline3.setText(FakeDatabase.getArticleById(3).getHeadline());
        newsImage3 = article3.findViewById(R.id.imageView);
        newsImage3.setImageResource(R.drawable.francemourn);
        String article3Image = "francemourn";
        final int article3ImgID = getResources().getIdentifier(article3Image, "drawable", getPackageName());
//        expandBtn3 = article3.findViewById(R.id.expandBtn);
        shareBtn3 = article3.findViewById(R.id.shareBtn);

        //get article 3
        passArticle3 = FakeDatabase.getArticleById(3).getArticleID();

        //when article 3 share button is clicked
        shareBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Intent initiated", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                //intent for the button send thing
                Intent textIntent3 = new Intent(Intent.ACTION_SEND);
                textIntent3.setType("text/plain");
                textIntent3.putExtra(Intent.EXTRA_TEXT, FakeDatabase.getArticleById(3).getHeadline() + getResources().getString(R.string.NYTimes));
                startActivity(textIntent3);

            }
        });

        //when article 3 constraint layout button is clicked
        article3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //execute the explicit + pass data in
                Intent intentBtn3 = new Intent(getApplicationContext(), DetailActivity.class);
                //pass over a string to the other activity
                intentBtn3.putExtra("ArticleToPass", passArticle3);
                intentBtn3.putExtra("ImageToPass", article3ImgID);
                startActivity(intentBtn3);

            }
        });

        //article 4
        article4 = findViewById(R.id.article4);
        newsHeadline4 = article4.findViewById(R.id.textView);
        newsHeadline4.setText(FakeDatabase.getArticleById(4).getHeadline());
        newsImage4 = article4.findViewById(R.id.imageView);
        newsImage4.setImageResource(R.drawable.inmates);
        String article4Image = "inmates";
        final int article4ImgID = getResources().getIdentifier(article4Image, "drawable", getPackageName());
//        expandBtn4 = article4.findViewById(R.id.expandBtn);
        shareBtn4 = article4.findViewById(R.id.shareBtn);

        //get article 4
        passArticle4 = FakeDatabase.getArticleById(4).getArticleID();

        //when article 4 share button is clicked
        shareBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Intent initiated", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                //intent for the button send thing
                Intent textIntent4 = new Intent(Intent.ACTION_SEND);
                textIntent4.setType("text/plain");
                textIntent4.putExtra(Intent.EXTRA_TEXT, FakeDatabase.getArticleById(4).getHeadline() + getResources().getString(R.string.NYTimes));
                startActivity(textIntent4);

            }
        });

        //when article 4 constraint layout button is clicked
        article4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //execute the explicit + pass data in
                Intent intentBtn4 = new Intent(getApplicationContext(), DetailActivity.class);
                //pass over a string to the other activity
                intentBtn4.putExtra("ArticleToPass", passArticle4);
                intentBtn4.putExtra("ImageToPass", article4ImgID);
                startActivity(intentBtn4);

            }
        });

        //article 5
        article5 = findViewById(R.id.article5);
        newsHeadline5 = article5.findViewById(R.id.textView);
        newsHeadline5.setText(FakeDatabase.getArticleById(5).getHeadline());
        newsImage5 = article5.findViewById(R.id.imageView);
        newsImage5.setImageResource(R.drawable.northpole);
        String article5Image = "northpole";
        final int article5ImgID = getResources().getIdentifier(article5Image, "drawable", getPackageName());
//        expandBtn5 = article5.findViewById(R.id.expandBtn);
        shareBtn5 = article5.findViewById(R.id.shareBtn);

        //get article 5
        passArticle5 = FakeDatabase.getArticleById(5).getArticleID();

        //when article 5 share button is clicked
        shareBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Intent initiated", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                //intent for the button send thing
                Intent textIntent5 = new Intent(Intent.ACTION_SEND);
                textIntent5.setType("text/plain");
                textIntent5.putExtra(Intent.EXTRA_TEXT, FakeDatabase.getArticleById(5).getHeadline() + getResources().getString(R.string.NYTimes));
                startActivity(textIntent5);

            }
        });

        //when article 5 constraint layout button is clicked
        article5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //execute the explicit + pass data in
                Intent intentBtn5 = new Intent(getApplicationContext(), DetailActivity.class);
                //pass over a string to the other activity
                intentBtn5.putExtra("ArticleToPass", passArticle5);
                intentBtn5.putExtra("ImageToPass", article5ImgID);
                startActivity(intentBtn5);

            }
        });

        //article 6
        article6 = findViewById(R.id.article6);
        newsHeadline6 = article6.findViewById(R.id.textView);
        newsHeadline6.setText(FakeDatabase.getArticleById(6).getHeadline());
        newsImage6 = article6.findViewById(R.id.imageView);
        newsImage6.setImageResource(R.drawable.posthappy);
        String article6Image = "posthappy";
        final int article6ImgID = getResources().getIdentifier(article6Image, "drawable", getPackageName());
//        expandBtn5 = article6.findViewById(R.id.expandBtn);
        shareBtn6 = article6.findViewById(R.id.shareBtn);

        //get article 6
        passArticle6 = FakeDatabase.getArticleById(6).getArticleID();

        //when article 6 share button is clicked
        shareBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Intent initiated", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                //intent for the button send thing
                Intent textIntent6 = new Intent(Intent.ACTION_SEND);
                textIntent6.setType("text/plain");
                textIntent6.putExtra(Intent.EXTRA_TEXT, FakeDatabase.getArticleById(6).getHeadline() + getResources().getString(R.string.NYTimes));
                startActivity(textIntent6);

            }
        });

        //when article 6 constraint layout button is clicked
        article6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //execute the explicit + pass data in
                Intent intentBtn6 = new Intent(getApplicationContext(), DetailActivity.class);
                //pass over a string to the other activity
                intentBtn6.putExtra("ArticleToPass", passArticle6);
                intentBtn6.putExtra("ImageToPass", article6ImgID);
                startActivity(intentBtn6);

            }
        });

//        initArticleIds();
//        initArticleSummary();
//        initImageIds();
//        initRecyclerViewer();

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
}
