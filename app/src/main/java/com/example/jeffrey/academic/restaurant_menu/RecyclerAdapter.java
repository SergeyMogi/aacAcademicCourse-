package com.example.jeffrey.academic.restaurant_menu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jeffrey.academic.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ArrayList<Item> arrayList;
    private Context mContext;
    public static int position;

    RecyclerAdapter(Context context, ArrayList<Item> arrayList) {
        this.arrayList = arrayList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.resturant_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, @SuppressLint("RecyclerView") final int i) {

        viewHolder.name.setText(arrayList.get(i).getDescription());

        Glide.with(mContext)
                .load(arrayList.get(i).getDrawable())
                .into(viewHolder.imageView);

        viewHolder.price.setText(String.valueOf(arrayList.get(i).getPrice()));

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position =i;
                mContext.startActivity(new Intent(mContext, ShowPickedItem.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private ImageView imageView;
        private TextView price;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            price = itemView.findViewById(R.id.price_of_resturant_item);
            name = itemView.findViewById(R.id.name_of_item_resturant);
            imageView = itemView.findViewById(R.id.image_item_resturant);

        }
    }

}
