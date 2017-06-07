package com.example.kstedman.mathapplication.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.kstedman.mathapplication.R;

public class ResponseDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_response_detail);
        Log.v("ResponseDetail", "This is the Response Detail Activity");
    }
}
