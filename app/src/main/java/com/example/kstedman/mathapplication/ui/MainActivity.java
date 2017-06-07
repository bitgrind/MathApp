package com.example.kstedman.mathapplication.ui;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;

import android.graphics.Typeface;
import android.widget.TextView;

import com.example.kstedman.mathapplication.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
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
        mSolveEquationButton.setOnClickListener(this);
        mAboutButton.setOnClickListener(this);
        mContactButton.setOnClickListener(this);
        mConvertButton.setOnClickListener(this);
        mSolveButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Log.v("MainActivity Click", v.toString());

        if(v == mSolveEquationButton) {
            String mathEquation = mInputEquation.getText().toString();
            Intent intent = new Intent(MainActivity.this, SolveActivity.class);
            intent.putExtra("question", mathEquation);
            startActivity(intent);
        }

        if(v == mAboutButton) {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        }

        if(v == mContactButton) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/keith-stedman"));
            startActivity(intent);
        }

        if(v == mConvertButton) {
            Intent intent = new Intent(MainActivity.this, ConvertActivity.class);
            startActivity(intent);
        }

        if(v == mSolveButton) {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
