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
    private EditText mInputEquation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSolveEquationButton = (Button) findViewById(R.id.solveEquationButton);
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
    }
}
