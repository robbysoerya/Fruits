package com.labti.fruits;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends BaseAdapter {

    Context con;
    ArrayList<Model> mlist;
    public Model sched;
    String name,image,detail;
    public Adapter(Context con,ArrayList<Model> mlist )
    {
        this.con=con;
        this.mlist=mlist;

    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mlist.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return mlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        sched=mlist.get(position);
        LayoutInflater inflater=(LayoutInflater)con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=inflater.inflate(R.layout.item,parent,false);
        TextView tv1= convertView.findViewById(R.id.txBuah);
        tv1.setText(sched.getName());
        ImageView img = convertView.findViewById(R.id.imgBuah);
        Glide.with(convertView).load(sched.getImage())
        .into(img);

        return convertView;
    }

}
