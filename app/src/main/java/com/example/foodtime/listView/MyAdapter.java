package com.example.foodtime.listView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodtime.R;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<ListData> listData;

    public MyAdapter(Context context, ArrayList<ListData> data) {
        mContext = context;
        listData = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }


    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.list_view, null);

        ImageView imageView = (ImageView)view.findViewById(R.id.poster);
        TextView storeName = (TextView)view.findViewById(R.id.movieName);
        TextView distance = (TextView)view.findViewById(R.id.grade);

        imageView.setImageResource(listData.get(position).getPoster());
        storeName.setText(listData.get(position).getStoreName());
        distance.setText(listData.get(position).getDistance());

        return view;
    }
}
