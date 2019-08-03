package com.example.jeffrey.academic.restaurant_menu;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jeffrey.academic.R;
import com.example.jeffrey.academic.recycler_view.RecyclerViewExample;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowItems extends Fragment {


    public ShowItems() {
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_show_items, container, false);
        TextView tvTag = view.findViewById(R.id.tv_tag);
        tvTag.setText(MenuActivity.cat);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        loadTheRecycler();
    }

    private void loadTheRecycler() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        layoutManager.setSmoothScrollbarEnabled(true);
        RecyclerView recyclerView = Objects.requireNonNull(getView()).findViewById(R.id.resturant_recycler);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerAdapter adapter = new RecyclerAdapter(getActivity(),MenuActivity.pickedList);
        recyclerView.setAdapter(adapter);
    }

}
