package com.example.doanandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
        Button btn_themnhanvien,btn_sanpham,btn_thongke,btn_dx,btn_themsp;
        btn_themnhanvien=findViewById(R.id.btn_themnhanvien);
        btn_sanpham=findViewById(R.id.btn_sanpham);
        btn_thongke=findViewById(R.id.btn_thongke);
        btn_dx=findViewById(R.id.btn_dangxuat);
        btn_themsp=findViewById(R.id.btn_themsp);
        TextView lb_dntc=findViewById(R.id.lb_dntc);
        nhanvien nv;
        if(getIntent().getExtras()!=null) {
            nv = (nhanvien) getIntent().getExtras().get("nv_dn");
            lb_dntc.setText("Xin chào " +nv.tennv);
            if(!nv.manv.contains("QL"))
                btn_themnhanvien.setEnabled(false);
        }
        btn_dx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(dangnhaptc.this,MainActivity.class);
                startActivity(intent);
            }
        });
        btn_themnhanvien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(dangnhaptc.this,ThemNV.class);
                startActivity(intent);
            }
        });
        btn_themsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(dangnhaptc.this,ThemSP.class);
                startActivity(intent);
            }
        });
        btn_sanpham.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(dangnhaptc.this,lietkesp.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("nv_xct",(nhanvien) getIntent().getExtras().get("nv_dn"));
                intent.putExtras(bundle);
                startActivity(intent);

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