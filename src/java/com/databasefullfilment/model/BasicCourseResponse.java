package com.databasefullfilment.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Саша on 21.03.2015.
 */
public class BasicCourseResponse {

    @SerializedName("elements")
    private List<BasicCourse> basicCourses;

    public List<BasicCourse> getBasicCourses() {
        return basicCourses;
    }
}
