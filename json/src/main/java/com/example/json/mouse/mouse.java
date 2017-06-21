package com.example.json.mouse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class java {

    @SerializedName("cost")
    @Expose
    private Integer cost;
    @SerializedName("name")
    @Expose
    private String name;

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
