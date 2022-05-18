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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_nv);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("tnv");
        EditText txt_tk,txt_mk;
        TextView lbdk;
        Button btn_themnv;
        txt_mk=findViewById(R.id.txt_themmk);
        txt_tk=findViewById(R.id.txt_themtk);
        lbdk=findViewById(R.id.lb_themnv);
        btn_themnv=findViewById(R.id.btn_themnv);
        ArrayList<String> taikhoan= new ArrayList<String>();
        myRef.child("2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot a: dataSnapshot.getChildren()) {
                    String dl=a.getValue().toString();
                    taikhoan.add(dl);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        btn_themnv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(taikhoan.isEmpty())
                    Toast.makeText(ThemNV.this,taikhoan.get(0),Toast.LENGTH_LONG).show();



            }
        });
    }
}