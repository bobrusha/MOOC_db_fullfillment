package com.databasefullfilment.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Саша on 21.03.2015.
 */
public class SessionResponse {
    @SerializedName("elements")
    private List<Session> sessionList;

    public List<Session> getSessions(){ return sessionList; }
}
