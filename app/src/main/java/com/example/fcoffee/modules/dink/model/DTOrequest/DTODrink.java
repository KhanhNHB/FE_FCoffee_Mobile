package com.example.fcoffee.modules.dink.model.DTOrequest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DTODrink implements Serializable {

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("price")
    @Expose
    private float price;

    @SerializedName("disable")
    @Expose
    private boolean disable;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("categoryId")
    @Expose
    private int categoryId;

    @SerializedName("image")
    @Expose
    private String image;

    private int count = 0;

    public DTODrink() {}


    public DTODrink(int id, String name, float price, boolean disable, String description, int categoryId, String image, int count) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.disable = disable;
        this.description = description;
        this.categoryId = categoryId;
        this.image = image;
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public boolean isDisable() {
        return disable;
    }

    public String getDescription() {
        return description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getImage() {
        return image;
    }
}