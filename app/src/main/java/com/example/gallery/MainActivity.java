package com.example.gallery;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
//import android.media.Image;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> imageIds = new ArrayList<>(Arrays.asList(
            R.drawable.img1, R.drawable.img2, R.drawable.img3 ,
            R.drawable.img4 , R.drawable.img5, R.drawable.img6 ,
            R.drawable.img7 , R.drawable.img8 , R.drawable.img9));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridview = findViewById(R.id.grid);
        gridview.setAdapter(new imageAdapter(imageIds,this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                int item_pos = imageIds.get(position);

                ShowDialog(item_pos);
            }
        });
    }

    public void ShowDialog(final int item_pos){
        final Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.custom_dialog);

        //getting custom dialog views
        TextView Image_name = findViewById(R.id.image_name);
        ImageView image = dialog.findViewById(R.id.img);
        Button btn_full = dialog.findViewById(R.id.btn_full);
        Button btn_close = dialog.findViewById(R.id.btn_close);

        String title = getResources().getResourceName(item_pos);

        //extracting name
        int index = title.indexOf("/");
        String name = title.substring(index+1, title.length());
        Image_name.setText(name);

        image.setImageResource(item_pos);

        btn_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        btn_full.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this , full_view.class);
                i.putExtra("img_id" , item_pos);
                startActivity(i);
            }
        });

        dialog.show();
    }
}