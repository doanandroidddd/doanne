package com.example.doanandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        EditText txt_tk,txt_mk;
        TextView lbdk;
        txt_mk=findViewById(R.id.txt_mk);
        txt_tk=findViewById(R.id.txt_tk);
        lbdk=findViewById(R.id.lb_dn);
        List<nhanvien> nhanviens= new ArrayList<nhanvien>();
        Button btn_dn,btn_dk;
        btn_dn=findViewById(R.id.btn_dangnhap);
        btn_dk=findViewById(R.id.btn_dangky);
        btn_dn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                for (nhanvien nv: nhanviens) {
                    if(txt_mk.getText().toString().equals(nv.mk)&&txt_tk.getText().toString().equals(nv.tk))
                    {
                        Intent intent=new Intent(MainActivity.this,lietkesp.class);
                        startActivity(intent);
                    }

                }
            }
        });
        btn_dk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,ThemNV.class);
                startActivity(intent);
            }
        });
    }
}