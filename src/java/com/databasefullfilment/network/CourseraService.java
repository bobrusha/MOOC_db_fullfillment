package com.databasefullfilment.network;

import com.databasefullfilment.model.*;
import com.squareup.okhttp.OkHttpClient;
import retrofit.RestAdapter;
import java.util.concurrent.TimeUnit;
import retrofit.client.OkClient;

import retrofit.http.GET;

public class CourseraService {
    private static OkHttpClient client = new OkHttpClient();

    private static CourseraWebService SERVICE;

    static {
        client.setReadTimeout(0, TimeUnit.SECONDS);
        SERVICE = new RestAdapter.Builder()
                .setEndpoint("https://api.coursera.org/api/catalog.v1")
                .setClient(new OkClient(client))
                .build()
                .create(CourseraWebService.class);
    }

    public static CourseraWebService getService() {
        return SERVICE;
    }

    public static interface CourseraWebService {
        @GET("/courses?fields=language,previewLink,shortDescription&includes=sessions,categories")
        BasicCourseResponse getCourses();
        @GET("/sessions?fields=startDay,startMonth,startYear,status,durationString")
        SessionResponse getSessions();
        @GET("/universities?fields=name")
        UniversityResponse getUniversity();
        @GET("/instructors?includes=courses,universities")
        InstructorResponse getInstructors();
        @GET("/categories")
        CategoryResponse getCategories();
    }
}
