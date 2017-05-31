package com.example.kstedman.mathapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

import android.graphics.Typeface;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.solveEquationButton) Button mSolveEquationButton;
    @Bind(R.id.aboutButton) Button mAboutButton;
    @Bind(R.id.convertButton) Button mConvertButton;
    @Bind(R.id.contactButton) Button mContactButton;
    @Bind(R.id.solveButton) Button mSolveButton;
    @Bind(R.id.inputEquation) TextView mInputEquation;
    private TextView mPageTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mPageTitle = (TextView) findViewById(R.id.pageTitle);
        Typeface leixoFont = Typeface.createFromAsset(getAssets(), "fonts/leixo.ttf");

        mPageTitle.setTypeface(leixoFont);

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
