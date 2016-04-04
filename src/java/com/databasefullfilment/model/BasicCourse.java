package com.databasefullfilment.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Саша on 21.03.2015.
 */
public class BasicCourse {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("shortDescription")
    private String description;
    @SerializedName("previewLink")
    private String link = "";
    @SerializedName("language")
    private String lang;
    @SerializedName("links")
    private Links links;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }

    public String getLang() {
        return lang;
    }

    public Links getLinks() {
        return links;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public class Links{
        @SerializedName("sessions")
        private int[] sessions;
        @SerializedName("categories")
        private int[] caregories;

        public int[] getSessions() {
            return sessions;
        }

        public int[] getCaregories() {
            return caregories;
        }

        public int getLatestSessionNumber(){
            if(sessions != null)
                return sessions[sessions.length-1];
            else
                return -1;
        }
    }

}
