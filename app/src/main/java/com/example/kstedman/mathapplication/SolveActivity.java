package com.example.kstedman.mathapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SolveActivity extends AppCompatActivity {
    public static final String TAG = SolveActivity.class.getSimpleName();

    @Bind(R.id.equationSteps) ListView mListView;
    @Bind(R.id.inputEquation) TextView mEquationText;

    public ArrayList<WolframResponseModel> mResults = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solve);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String equation = intent.getStringExtra("equation1");

        mEquationText.setText(equation);

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
            public void onResponse(Call call, Response response) {
                mResults = wolframService.processAnswer(response);

                SolveActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String[] responseNames = new String[mResults.size()];
                        for(int i = 0; i < responseNames.length; i++){
                            responseNames[i] = mResults.get(i).getType();
                        }

                        ArrayAdapter adapter = new ArrayAdapter(SolveActivity.this, android.R.layout.simple_list_item_1, responseNames);
                        mListView.setAdapter(adapter);

                        for (WolframResponseModel response : mResults){
                            Log.d(TAG, ""+response.getType());
                        }
                    }
                });
            }
        });
    }
}
