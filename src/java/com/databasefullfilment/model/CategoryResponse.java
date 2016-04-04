package com.databasefullfilment.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryResponse {
    @SerializedName("elements")
    List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }
}
