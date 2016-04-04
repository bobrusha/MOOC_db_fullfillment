package com.databasefullfilment.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InstructorResponse {
    @SerializedName("elements")
    List<Instructor> instructors;

    public List<Instructor> getInstructors() {
        return instructors;
    }
}
