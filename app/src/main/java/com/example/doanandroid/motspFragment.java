package com.example.doanandroid;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.widget.Button;
import android.widget.ImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link motspFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class motspFragment extends Fragment {
    TextView txtTen, txtMoTa;
    ImageView imgHinh;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    public motspFragment() {
        // Required empty public constructor
    }

    public static motspFragment newInstance(String param1, String param2) {
        motspFragment fragment = new motspFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    public void dienDuLieu(sanpham huhu)
    {
        txtTen=getActivity().findViewById(R.id.txt_tensp);
        txtTen.setText(huhu.getTensp());
        imgHinh=getActivity().findViewById(R.id.imgsp);
        imgHinh.setImageResource(huhu.getHinh());
        txtMoTa=getActivity().findViewById(R.id.txt_motasp);
        txtMoTa.setText(huhu.getMota());


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_motsp, container, false);
//        imgHinh=view.findViewById(R.id.imgsp);
        return view;
    }

}