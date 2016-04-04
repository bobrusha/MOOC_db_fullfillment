package com.databasefullfilment.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class UniversityResponse {
    @SerializedName("elements")
    List<University> universities;

    public List<University> getUniversities() {
        return universities;
    }
}
