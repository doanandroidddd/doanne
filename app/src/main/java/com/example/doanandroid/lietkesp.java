package com.example.doanandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class lietkesp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lietkesp);
        ImageView img;
        img=findViewById(R.id.imgsp);
        Intent intent=getIntent();
        sanpham sp= new sanpham(R.drawable.linh,"a","a","a");
        img.setImageResource(sp.getHinh());
    }
}