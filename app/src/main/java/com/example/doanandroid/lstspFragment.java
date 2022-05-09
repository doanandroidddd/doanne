package com.example.doanandroid;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.doanandroid.placeholder.PlaceholderContent;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class lstspFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    ArrayList<sanpham> dsDL=new ArrayList<>();


    public lstspFragment() {
    }


    public static lstspFragment newInstance(int columnCount) {
        lstspFragment fragment = new lstspFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lstsp_list, container, false);

        dsDL.add(new sanpham(R.drawable.linh,"Tao Ha Noi","SP01","La trai cay de an, nhung dat"));
        dsDL.add(new sanpham(R.drawable.linh,"Nho Vung Tau","sp02","Ngot, nhung khong thich an"));
        dsDL.add(new sanpham(R.drawable.linh,"Chuoi an trom","sp03","Giau chat dinh duong"));

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),1));

            recyclerView.setAdapter(new MyItemRecyclerViewAdapter(dsDL, getActivity()));
        }
        return view;
    }
}