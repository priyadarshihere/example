package com.example.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.List;

public class imageAdapter extends BaseAdapter {

    private List<Integer> thumbids;
    private Context mcontext;
    private int position;

    public imageAdapter(List<Integer> thumbids, Context mcontext) {
        this.thumbids = thumbids;
        this.mcontext = mcontext;
    }

    @Override
    public int getCount() {
        return thumbids.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return thumbids.get(position);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageview  = new ImageView(mcontext);

        if(imageview == null){
            imageview = new ImageView(mcontext);
            imageview.setLayoutParams(new GridView.LayoutParams(350 , 450));
            imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
        imageview.setImageResource(thumbids.get(position));

        return imageview;
    }
}
