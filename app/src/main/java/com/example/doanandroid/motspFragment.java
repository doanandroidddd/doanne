package com.example.doanandroid;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.widget.ImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link motspFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class motspFragment extends Fragment {

    public motspFragment() {

    }

    public static motspFragment newInstance(String param1, String param2) {
        motspFragment fragment = new motspFragment();
        return fragment;
    }
    ImageView imgHinh;
    public void dienDuLieu(sanpham sp)
    {

        imgHinh=getActivity().findViewById(R.id.imgsp);
        imgHinh.setImageResource(sp .getHinh());

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_motsp, container, false);
        imgHinh=view.findViewById(R.id.imgsp);
        return view;
    }}