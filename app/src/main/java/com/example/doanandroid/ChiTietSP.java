package com.example.doanandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ChiTietSP extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_motsp);
        ImageView img;
        img=findViewById(R.id.imgsp);
        Intent intent=getIntent();
        sanpham sp= new sanpham(R.drawable.linh,"a","a","a",1);
        img.setImageResource(sp.getHinh());
    }

}
