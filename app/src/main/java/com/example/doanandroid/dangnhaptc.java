package com.example.doanandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class dangnhaptc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhaptc);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        Button btn_themnhanvien,btn_hoadon,btn_thongke;
        btn_themnhanvien=findViewById(R.id.btn_themnhanvien);
        btn_hoadon=findViewById(R.id.btn_hoadon);
        btn_thongke=findViewById(R.id.btn_thongke);
        btn_themnhanvien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(dangnhaptc.this,ThemNV.class);
                startActivity(intent);
            }
        });
        btn_hoadon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                khachhang kh= new khachhang("a","a","a","a");
                nhanvien nv= new nhanvien("a","a","a","a");
                List<sanpham> sps= new ArrayList<>();
                sanpham sp= new sanpham(1,"a","a","a",1);
                sps.add(sp);
                DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

                HoaDon hd= new HoaDon("a",sps,nv,kh);

                myRef.child("HoaDon").push().setValue(hd);
            }
        });
        btn_thongke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(dangnhaptc.this,thongke.class);
                startActivity(intent);
            }
        });
    }
}