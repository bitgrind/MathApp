package com.example.kstedman.mathapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SolveActivity extends AppCompatActivity {
    private TextView mEquationText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solve);
        mEquationText = (TextView) findViewById(R.id.inputEquation);
        Intent intent = getIntent();
        String equation = intent.getStringExtra("equation1");
        mEquationText.setText(equation);
    }
}
