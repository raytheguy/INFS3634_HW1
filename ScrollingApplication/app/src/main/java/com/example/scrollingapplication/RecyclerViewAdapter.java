package com.example.scrollingapplication;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

//viewholder type
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    //for debugging
    private static final String TAG = "RecyclerViewAdapter";

    //ArrayList of Strings to Hold Imageids
    public ConstraintLayout layoutMain;
    public ArrayList<Integer> imageIds = new ArrayList<>();
    public ArrayList<String> articleSummary = new ArrayList<>();
    public ArrayList<Integer> articleIds = new ArrayList<>();
    public Context mContext;

    public RecyclerViewAdapter(ArrayList<Integer> imageIds, ArrayList<String> articleSummary, ArrayList<Integer> articleIds, Context mContext) {
        this.imageIds = imageIds;
        this.articleSummary = articleSummary;
        this.articleIds = articleIds;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    //inflate the view; same as any recycle adapter, just need to change the id
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    //changes based on layout
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //log for debugging purposes
        //called when loaded
        Log.d(TAG, "Tester called");

        //onClick Listener when the 'holder' or constraintLayout is clicked
        holder.layoutMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Intent initiated", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


            }
        });

    }

    @Override
    public int getItemCount() {
        //get the amount of Ids that exists
        return articleIds.size();
    }

    //purpose: holds widgets in memory
    public class ViewHolder extends RecyclerView.ViewHolder {

        //declare everything the ViewHolder holds here
        //in news_layout, there is imageView

        ConstraintLayout layoutMain;
        ImageView imageView;
        TextView textView;
        View view;
        Button shareBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //attach the items to the id
            layoutMain = itemView.findViewById(R.id.layoutMain);
            imageView = itemView.findViewById(R.id.imageView);
            view = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
            shareBtn = itemView.findViewById(R.id.shareBtn);

        }
    }
}
