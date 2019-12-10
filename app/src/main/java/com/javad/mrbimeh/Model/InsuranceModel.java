package com.javad.mrbimeh.Model;

public class InsuranceModel {
    private String id;
    private String name;
    private String price;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getId() {
        return this.id;
    }

    public String getPrice() {
        return this.price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
