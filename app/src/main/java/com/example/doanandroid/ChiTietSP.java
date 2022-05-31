package com.example.doanandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ChiTietSP extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    TextView txtTen, txtMoTa,txt_mahd,txt_tenkh,txt_makh,txt_diachi,txt_sdt,txt_sl;
    ImageView imgHinh;
    Button btn_banhang;
    String key;
    static List<sanpham> sanphams= new ArrayList<>();
    static List<HoaDon> hoaDons= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_sp);
        anhXa();

        Intent intent=getIntent();
        sanpham tc=(sanpham)intent.getSerializableExtra("vinhtc");

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
                HoaDon hd= new HoaDon(txt_mahd.getText().toString(),sanphams,nv,kh);
                int slmua=Integer.parseInt(txt_sl.getText().toString());
                if(tc.soluongkho<slmua)
                    Toast.makeText(ChiTietSP.this,"Khong du hang ban",Toast.LENGTH_SHORT).show();
                else {
//                    myRef.child("SanPham").addValueEventListener(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                            sanphams.clear();
//                            for (DataSnapshot a: dataSnapshot.getChildren()) {
//                                sanpham sp=a.getValue(sanpham.class);
//                                if(tc.masp.equals(sp.masp))
//                                {
//                                    sp.soluongkho=sp.soluongkho-Integer.parseInt(txt_sl.getText().toString());
//                                    sanphams.add(sp);
//                                }
//                                else
//                                    sanphams.add(sp);
//                            }
//                        }
//                        @Override
//                        public void onCancelled(@NonNull DatabaseError databaseError) {
//                        }
//                    });
//                   myRef.child("SanPham").setValue(sanphams);
                    myRef.child("HoaDon").push().setValue(hd);
                    Toast.makeText(ChiTietSP.this,"thêm hóa đơn thành công",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void anhXa() {
        txtTen=findViewById(R.id.txt_tensp);
        txtMoTa=findViewById(R.id.txt_motasp);
        imgHinh=findViewById(R.id.imgsp);
    }

}