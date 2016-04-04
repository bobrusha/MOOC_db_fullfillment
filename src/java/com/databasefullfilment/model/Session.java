package com.databasefullfilment.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Саша on 21.03.2015.
 */
public class Session {
    @SerializedName("id")
    private int id;
    @SerializedName("startDay")
    private int startDay = -1;
    @SerializedName("startMonth")
    private int startMonth = -1;
    @SerializedName("startYear")
    private int startYear = -1;
    @SerializedName("duration")
    private String duration;

    public int getId() {
        return id;
    }

    public int getStartDay() {
        return startDay;
    }

    public int getStartMonth() {
        return startMonth;
    }

    public int getStartYear() {
        return startYear;
    }

    public String getDuration() {
        return duration;
    }
}
