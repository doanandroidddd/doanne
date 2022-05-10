package com.example.doanandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText txt_tk,txt_mk;
        TextView lbdk;
        txt_mk=findViewById(R.id.txt_mk);
        txt_tk=findViewById(R.id.txt_tk);
        lbdk=findViewById(R.id.lb_dn);

        Button btn_dn;
        btn_dn=findViewById(R.id.btn_dangnhap);
        btn_dn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,lietkesp.class);
                startActivity(intent);
            }
        });
    }
}