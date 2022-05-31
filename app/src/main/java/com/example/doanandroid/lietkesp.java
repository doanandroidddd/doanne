package com.example.doanandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class lietkesp extends AppCompatActivity implements truyenanpham {
    Button btn_search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lietkesp);
        btn_search=findViewById(R.id.btn_timkiem);
        nhanvien nv=(nhanvien) getIntent().getExtras().get("nv_xct");
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Toast.makeText(lietkesp.this,nv.manv,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void truyensp(sanpham sp) {
        motspFragment mt=(motspFragment) getSupportFragmentManager().findFragmentById(R.id.chitietsp);
        if(mt!=null)
            mt.dienDuLieu(sp);
        else {
            nhanvien nv=(nhanvien) getIntent().getExtras().get("nv_xct");
            Intent intent =new Intent(this,ChiTietSP.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("nv_xct",nv);
            bundle.putSerializable("vinhtc",sp);
            intent.putExtras(bundle);
            startActivity(intent);
        }
    }
}