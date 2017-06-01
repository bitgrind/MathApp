package com.example.kstedman.mathapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SolveActivity extends AppCompatActivity {
    private TextView mEquationText;
    private ListView mListView;
    private String[] equationSteps = new String[] {"This is the complicated Problem","This is the less complicated problem","More Less complicated","the most simple"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solve);

        mListView = (ListView) findViewById(R.id.equationSteps);
        mEquationText = (TextView) findViewById(R.id.inputEquation);

        Intent intent = getIntent();
        String equation = intent.getStringExtra("equation1");
        mEquationText.setText(equation);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, equationSteps);
        mListView.setAdapter(adapter);

        getSolutions(equation);

    }

    private void getSolutions(String questionEquation){
        final WolframService wolframService = new WolframService();
        wolframService.solveMathEquation(questionEquation, new Callback(){

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonData = response.body().string();
                    Log.v("WolframAnwser", jsonData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
