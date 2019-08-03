package com.example.jeffrey.academic.restaurant_menu;

public class Item {

    private int price;
    private String description;
    private int drawable;
    private String name;
    private String category;

    public Item() {
    }


    public Item(int drawable, String description, int price, String name) {

        this.drawable = drawable;
        this.description = description;
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}