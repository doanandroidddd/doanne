package com.example.doanandroid;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class thongkeAdapter extends BaseAdapter {
    List<HoaDon> items;
    Activity activity;
    truyenanpham tsp;
    public thongkeAdapter(List<HoaDon> items,Activity activity)
    {
        this.items=items;
        this.activity=activity;
    }
    public thongkeAdapter(List<HoaDon> items,Activity activity,truyenanpham tsp)
    {
        this.items=items;
        this.activity=activity;
        this.tsp=tsp;
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater=activity.getLayoutInflater();
        view=inflater.inflate(R.layout.itemlsthoadon,null);
        TextView txt_tenkh=(TextView)view.findViewById(R.id.txt_tenkh);
        TextView txt_mahd=(TextView)view.findViewById(R.id.txt_mahd);
        khachhang kh= items.get(i).getKh();
        txt_tenkh.setText(kh.getTenkh());
        txt_mahd.setText(items.get(i).getMahd());
        return view;
    }
}
