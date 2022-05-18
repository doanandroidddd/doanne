package com.example.doanandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message1/1/TENSP");

        myRef.setValue( "cc");
        EditText txt_tk,txt_mk;
        TextView lbdk;
        txt_mk=findViewById(R.id.txt_mk);
        txt_tk=findViewById(R.id.txt_tk);
        lbdk=findViewById(R.id.lb_dn);

        Button btn_dn,btn_dk;
        btn_dn=findViewById(R.id.btn_dangnhap);
        btn_dk=findViewById(R.id.btn_dangky);
        btn_dn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,lietkesp.class);
                startActivity(intent);
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