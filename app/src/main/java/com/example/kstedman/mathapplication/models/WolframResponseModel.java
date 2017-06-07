package com.example.kstedman.mathapplication.models;

import org.parceler.Parcel;

@Parcel
public class WolframResponseModel {
    private String title;
    private String value;

    public WolframResponseModel() {}

    public WolframResponseModel(String title, String value){
        this.title = title;
        this.value = value;
    }

    public String getTitle(){
        return title;
    }

    public String getValue(){
        return value;
    }

}
