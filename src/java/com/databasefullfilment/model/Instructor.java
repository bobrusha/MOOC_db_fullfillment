package com.databasefullfilment.model;

import com.google.gson.annotations.SerializedName;
import com.sun.istack.internal.Nullable;

import java.util.List;

/**
 * Created by Саша on 21.03.2015.
 */
public class Instructor {
    @SerializedName("id")
    private int id;
    @SerializedName("firstName")
    private String firstName;
    @SerializedName("lastName")
    private String lastName;
    @Nullable
    @SerializedName("links")
    private Links links;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Nullable
    public Links getLinks() {
        return links;
    }
    /*
        Инструктор мб ассоциирован с несколькими университетами и несколькими курсами
        В json-файле массив с id курсов и университетов содержится в эл-те links
     */
    public class Links {
        @SerializedName("universities")
        private int[] aUniversityId;
        @SerializedName("courses")
        private int[] aCourseId;

        public int[] getaUniversityId() {
            return aUniversityId;
        }
        public int getLastUniversityId(){
            if (aUniversityId == null)
                return -1;
            return aUniversityId[aUniversityId.length-1];

        }

        public int[] getaCourseId() {
            return aCourseId;
        }
    }

}
