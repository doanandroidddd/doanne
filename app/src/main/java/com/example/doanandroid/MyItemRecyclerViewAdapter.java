package com.example.doanandroid;

import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.doanandroid.placeholder.PlaceholderContent.PlaceholderItem;


import java.util.List;


public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {
    private final List<sanpham> mValues;
    Context context;
    truyenanpham truyenTC;

    public MyItemRecyclerViewAdapter(List<sanpham> mValues, Context context) {
        this.mValues = mValues;
        this.context = context;
    }

    public MyItemRecyclerViewAdapter(List<sanpham> mValues, Context context, truyenanpham truyenTC) {
        this.mValues = mValues;
        this.context = context;
        this.truyenTC = truyenTC;
    }

    public MyItemRecyclerViewAdapter(List<sanpham> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_lstsp, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        sanpham sp=mValues.get(position);

        holder.mHinh.setImageResource(sp.getHinh());
        holder.txt_tensp.setText(sp.getTensp());
        holder.layout1sp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent =new Intent(context,MainActivity.class);
                intent.putExtra("vinhtc",sp);
                truyenTC.truyensp(sp);
            }
        });
    }
    @Override
    public int getItemCount() {
        return mValues.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mHinh;
        TextView txt_tensp;
        Button btn_dn,btn_xct;

        RelativeLayout layout1sp;
        public ViewHolder(View view) {
            super(view);
           txt_tensp=view.findViewById(R.id.txt_tensp);
            mHinh =  view.findViewById(R.id.imgsp);



            layout1sp=view.findViewById(R.id.itemrcvsp);
        }
    }

}