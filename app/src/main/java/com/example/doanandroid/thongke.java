package com.example.doanandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class thongke extends AppCompatActivity {
   static List<HoaDon> hoaDons= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongke);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        nhanvien nv=(nhanvien) getIntent().getExtras().get("nv_thongke");


        myRef.child("HoaDon").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                hoaDons.clear();
                for (DataSnapshot a: dataSnapshot.getChildren()) {
                    HoaDon hd=a.getValue(HoaDon.class);
                    if(hd.nv.manv.equals(nv.manv))
                    hoaDons.add(hd);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        ListView listView;
        listView=(ListView)findViewById(R.id.lst_thongke);
        thongkeAdapter thongkeAdapter  = new thongkeAdapter(hoaDons,this);
        listView.setAdapter(thongkeAdapter);


    }
}