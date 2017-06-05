package com.example.kstedman.mathapplication.models;


public class WolframResponseModel {
    private String mTitle;
    private String mValue;

    public WolframResponseModel(String title, String value){
        this.mTitle = title;
        this.mValue = value;
    }

    public String getTitle(){
        return mTitle;
    }

    public String getValue(){
        return mValue;
    }

}
