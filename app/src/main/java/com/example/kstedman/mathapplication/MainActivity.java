package com.example.kstedman.mathapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mSolveEquationButton;
    private Button mSolveButton;
    private Button mAboutButton;
    private Button mContactButton;
    private Button mConvertButton;
    private EditText mInputEquation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSolveEquationButton = (Button) findViewById(R.id.solveEquationButton);
        mAboutButton = (Button) findViewById(R.id.aboutButton);
        mConvertButton = (Button) findViewById(R.id.convertButton);
        mContactButton = (Button) findViewById(R.id.contactbutton);
        mSolveButton = (Button) findViewById(R.id.solveButton);
        mInputEquation = (EditText) findViewById(R.id.inputEquation);


        mSolveEquationButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String mathEquation = mInputEquation.getText().toString();
                Log.d("Input Equation", "Whats up");
                Intent intent = new Intent(MainActivity.this, SolveActivity.class);
                intent.putExtra("equation1", mathEquation);
                startActivity(intent);
            }
        });

        mAboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });

        mContactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(intent);
            }
        });

        mConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ConvertActivity.class);
                startActivity(intent);
            }
        });

        mSolveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
