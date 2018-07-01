package com.labti.fruits;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class PagerActivity extends Fragment {

    int mCurrentPage;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        Bundle data =getArguments();
        mCurrentPage =data.getInt("current_page",0); }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v=null;

        if(mCurrentPage == 1){
            v=inflater.inflate(R.layout.activity_detail,container, false);
            ImageView img = v.findViewById(R.id.detailImg);
            TextView name = v.findViewById(R.id.detailBuah);
            TextView detail = v.findViewById(R.id.detailDesc);

            String buah = getActivity().getIntent().getExtras().getString("name");
            String image = getActivity().getIntent().getExtras().getString("image");
            String desc = getActivity().getIntent().getExtras().getString("id");

            Glide.with(this).load(image).into(img);
            name.setText(buah);
            detail.setText(desc);
        } else if(mCurrentPage == 2){
            v=inflater.inflate(R.layout.activity_detail,container, false);
            ImageView img = v.findViewById(R.id.detailImg);
            TextView name = v.findViewById(R.id.detailBuah);
            TextView detail = v.findViewById(R.id.detailDesc);

            String buah = getActivity().getIntent().getExtras().getString("name");
            String image = getActivity().getIntent().getExtras().getString("image");
            String desc = getActivity().getIntent().getExtras().getString("en");
            Glide.with(this).load(image).into(img);
            name.setText(buah);
            detail.setText(desc);
        } return v;
    }

}
