package com.example.jeffrey.academic.restaurant_menu;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jeffrey.academic.R;

import java.util.ArrayList;

public class ShowPickedItem extends AppCompatActivity {

    private Button order;
    static ArrayList<Item> orderList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_picked_item);

        init();

        onClick();
    }

    private  void init() {
        ImageView itemImg = findViewById(R.id.iv_item);
        TextView description = findViewById(R.id.desc_of_item);
        TextView price = findViewById(R.id.price_of_item);
        TextView title = findViewById(R.id.title_of_item);
        TextView category = findViewById(R.id.tv_category);
        order = findViewById(R.id.add_item_to_list);

        title.setText(MenuActivity.pickedList.get(RecyclerAdapter.position).getName());
        itemImg.setImageResource(MenuActivity.pickedList.get(RecyclerAdapter.position).getDrawable());
        description.setText(MenuActivity.pickedList.get(RecyclerAdapter.position).getDescription());
        price.setText(String.valueOf(MenuActivity.pickedList.get(RecyclerAdapter.position).getPrice()));
        category.setText(MenuActivity.cat);
    }

    private void onClick() {
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Item item = new Item(MenuActivity.pickedList.get(RecyclerAdapter.position)
                        .getDrawable(),MenuActivity.pickedList.get(RecyclerAdapter.position)
                        .getDescription(),MenuActivity.pickedList.get(RecyclerAdapter.position)
                        .getPrice(),MenuActivity.pickedList.get(RecyclerAdapter.position).getName());
                orderList.add(item);
                startActivity(new Intent(ShowPickedItem.this, MenuActivity.class));
                finish();
            }
        });
    }
}

