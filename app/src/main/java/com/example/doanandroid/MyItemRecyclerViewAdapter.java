package com.example.doanandroid;

import androidx.recyclerview.widget.RecyclerView;

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


    public MyItemRecyclerViewAdapter(List<sanpham> mValues, Context context) {
        this.mValues = mValues;
        this.context = context;
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
        sanpham tc=mValues.get(position);

        holder.mHinh.setImageResource(tc.getHinh());
        holder.txt_tensp.setText(tc.getTensp());
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView mHinh;
        TextView txt_tensp;
        Button btn_dn,btn_xct;

        public ViewHolder(View view) {
            super(view);
           txt_tensp=view.findViewById(R.id.txt_tensp);
            mHinh =  view.findViewById(R.id.imgsp);
            btn_dn=view.findViewById(R.id.btn_dangnhap);
            btn_xct=view.findViewById(R.id.btn_xemct);

        }
    }
}