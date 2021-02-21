package com.yola.aloysiuschow.topdownloads;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class FeedAdapter extends ArrayAdapter {


    private static final String TAG = "FeedAdapter";
    private final int layoutResource;
    private final LayoutInflater layoutInflater;
    private List<FeedEntry> articles;


    public FeedAdapter(@NonNull Context context, int resource, List<FeedEntry> applications) {
        super(context, resource);
        this.layoutResource = resource;
        this.layoutInflater = LayoutInflater.from(context);
        this.articles = applications;
    }




    @Override
    public int getCount() {
        return articles.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = layoutInflater.inflate(layoutResource, parent, false);
        TextView newsTitle = (TextView) view.findViewById(R.id.newsTitle);
        TextView newsDate = (TextView) view.findViewById(R.id.newsDate);
        TextView newsSummary = (TextView) view.findViewById(R.id.newsSummary);
        TextView space = (TextView) view.findViewById(R.id.space);

        FeedEntry currentApp = articles.get(position);

        newsTitle.setText(currentApp.getTitle());
        newsDate.setText(currentApp.getPubDate());
        newsSummary.setText(currentApp.getDescription());
        space.setText("\n");

        return view;
    }


    
}
