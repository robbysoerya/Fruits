package com.labti.fruits;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Detail extends AppCompatActivity {
    ImageView img;
    TextView name,detail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        img = findViewById(R.id.detailImg);
        name = findViewById(R.id.detailBuah);
        detail = findViewById(R.id.detailDesc);
    }
}
