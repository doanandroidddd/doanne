package com.example.doanandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class ThemSP extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    static ArrayList<sanpham> sanphams= new ArrayList<sanpham>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_sp);
        EditText txt_themmasp,txt_themtensp,txt_themhinhsp,txt_themmota,txt_soluongcon;
        TextView lbthemsp;
        Button btn_themsp;
        txt_themmasp=findViewById(R.id.txt_themmasp1);
        txt_themtensp=findViewById(R.id.txt_themtensp1);
        txt_themhinhsp=findViewById(R.id.txt_themhinhsp1);
        txt_themmota=findViewById(R.id.txt_themmota1);
        txt_soluongcon=findViewById(R.id.txt_themslcon1);
        lbthemsp=findViewById(R.id.lb_themsp);
        btn_themsp=findViewById(R.id.btn_themsp1);
        btn_themsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                myRef.child("SanPham").addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        sanphams.clear();
                        for (DataSnapshot a: dataSnapshot.getChildren()) {
                            sanpham sp=a.getValue(sanpham.class);
                            sanphams.add(sp);

                        }

                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

                sanpham sp1= new sanpham(R.drawable.sp1,txt_themtensp.getText().toString(),txt_themmasp.getText().toString(),txt_themmota.getText().toString(),Integer.parseInt(txt_soluongcon.getText().toString()));

                if(txt_themmasp.getText().toString().equals("")||txt_themtensp.getText().toString().equals("")||txt_themhinhsp.getText().toString().equals("")||txt_themmota.getText().toString().equals("")) {
                    Toast.makeText(ThemSP.this, "Nh???p ?????y ????? th??ng tin", Toast.LENGTH_SHORT).show();
                    return;
                }

//                    for (sanpham sp : sanphams) {
//                        if (sp.masp.equals(txt_themmasp.getText().toString())) {
////                            Toast.makeText(ThemSP.this, "M?? s???n ph???m ???? t???n t???i", Toast.LENGTH_SHORT).show();
////                            return;
//
//                        }
//                        else
//                        {

                            sanphams.add(sp1);
                            myRef.child("SanPham").setValue(sanphams);
                            Toast.makeText(ThemSP.this, "Th??m s???n ph???m th??nh c??ng", Toast.LENGTH_SHORT).show();


////                        }
//                    }
            }
        });
    }
//    public void laydulieusp()
//    {
//        myRef.child("SanPham").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                sanphams.clear();
//                for (DataSnapshot a: dataSnapshot.getChildren()) {
//                    sanpham sp=a.getValue(sanpham.class);
//                    sanphams.add(sp);
//                }
//            }
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//    }

    }
