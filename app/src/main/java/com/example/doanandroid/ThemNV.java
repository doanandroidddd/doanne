package com.example.doanandroid;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ThemNV extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    List<nhanvien> nhanviens= new ArrayList<nhanvien>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_nv);
        EditText txt_tk,txt_mk,txt_manvv,txt_tennv,txt_hinhnv;
        TextView lbdk;
        Button btn_themnv;
        txt_mk=findViewById(R.id.txt_themmk);
        txt_tk=findViewById(R.id.txt_themtk);
        txt_manvv=findViewById(R.id.txt_themmanv);
        txt_tennv=findViewById(R.id.txt_themtennv);
        txt_hinhnv=findViewById(R.id.txt_themhinh);
        lbdk=findViewById(R.id.lb_themnv);
        btn_themnv=findViewById(R.id.btn_themnv);



        btn_themnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nhanvien a= new nhanvien(txt_tk.getText().toString(),txt_mk.getText().toString(),txt_manvv.getText().toString(),txt_tennv.getText().toString());


                if(txt_manvv.getText().toString().equals("")||txt_tennv.getText().toString().equals("")||txt_tk.getText().toString().equals("")||txt_mk.getText().toString().equals("")) {
                    Toast.makeText(ThemNV.this, "Nhập đầy đủ thông tin", Toast.LENGTH_LONG).show();
                    return;
                }


                myRef.child("NhanVien").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        nhanviens.clear();
                        for (DataSnapshot a: dataSnapshot.getChildren()) {
                            nhanvien nv=a.getValue(nhanvien.class);
                            nhanviens.add(nv);
                        }

                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                for (nhanvien nv:nhanviens) {
                    if(nv.manv.equals(txt_manvv.getText().toString()))
                    {
                        Toast.makeText(ThemNV.this, "Mã nhân viên đã tồn tại", Toast.LENGTH_LONG).show();
                        return;
                    }
                    if(nv.tk.equals(txt_tk.getText().toString()))
                    {
                        Toast.makeText(ThemNV.this, "Tài khoản nhân viên đã tồn tại", Toast.LENGTH_LONG).show();
                        return;
                    }
                }
                myRef.child("NhanVien").push().setValue(a);
                //Toast.makeText(ThemNV.this, nhanviens.get(0).manv, Toast.LENGTH_LONG).show();
            }
        });
    }
    public List<nhanvien> laydulieunv( )
    {
        List<nhanvien> lstnhanvien= new ArrayList<>();
        myRef.child("NhanVien").addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            lstnhanvien.clear();
            for (DataSnapshot a: dataSnapshot.getChildren()) {
                nhanvien nv=a.getValue(nhanvien.class);
                lstnhanvien.add(nv);
            }

        }
        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
        return lstnhanvien;
    }
}