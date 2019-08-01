package com.mayendrams.cekrek;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mayendrams.cekrek.adapter.AdapterStory;

public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_home,container,false);
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        recyclerView = view.findViewById(R.id.recyclestory);
//        recyclerView.hasFixedSize(true);
        return  view;
    }
}
