package com.example.doanandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ChiTietSP extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    TextView txtTen, txtMoTa,txt_mahd,txt_tenkh,txt_makh,txt_diachi,txt_sdt,txt_sl;
    ImageView imgHinh;
    Button btn_banhang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_sp);
        anhXa();

        Intent intent=getIntent();
        sanpham tc=(sanpham)intent.getSerializableExtra("vinhtc");
        List<sanpham> sanphams= new ArrayList<>();
        sanphams.add(tc);
        txtTen.setText(tc.getTensp());
        txtMoTa.setText(tc.getMota());
        imgHinh.setImageResource(tc.getHinh());
        btn_banhang=findViewById(R.id.btn_banhang);
        txt_mahd=findViewById(R.id.txt_themmahd);
        txt_tenkh=findViewById(R.id.txt_tenkh);
        txt_makh=findViewById(R.id.txt_makh);
        txt_diachi=findViewById(R.id.txt_dckh);
        txt_sdt=findViewById(R.id.txt_sdt);
        txt_sl=findViewById(R.id.txt_sl);
        btn_banhang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nhanvien nv=(nhanvien) getIntent().getExtras().get("nv_xct");
                khachhang kh= new khachhang(txt_makh.getText().toString(),txt_tenkh.getText().toString(),txt_diachi.getText().toString(),txt_sdt.getText().toString());
                HoaDon hd= new HoaDon("Hd01",sanphams,nv,kh);
                myRef.child("HoaDon").push().setValue(hd);
                Toast.makeText(ChiTietSP.this,"cc",Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void anhXa() {
        txtTen=findViewById(R.id.txt_tensp);
        txtMoTa=findViewById(R.id.txt_motasp);
        imgHinh=findViewById(R.id.imgsp);
    }
}