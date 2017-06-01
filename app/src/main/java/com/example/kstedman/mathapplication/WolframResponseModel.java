package com.example.kstedman.mathapplication;


public class WolframResponseModel {
    private String mType;

    public WolframResponseModel(String result){
        this.mType = result;
    }

    public String getResult(){
        return mType;
    }

}
