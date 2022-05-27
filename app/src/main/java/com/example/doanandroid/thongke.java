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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongke);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();
        Button btn_loc=findViewById(R.id.btn_loc);
        TextView txt_manv=findViewById(R.id.txt_manv);
        List<HoaDon> hoaDons= new ArrayList<>();
        myRef.child("HoaDon").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                hoaDons.clear();
                for (DataSnapshot a: dataSnapshot.getChildren()) {
                    HoaDon hd=a.getValue(HoaDon.class);
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