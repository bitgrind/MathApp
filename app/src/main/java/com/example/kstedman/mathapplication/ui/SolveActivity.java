package com.example.kstedman.mathapplication.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kstedman.mathapplication.R;
import com.example.kstedman.mathapplication.adapters.WolframCustomAdapter;
import com.example.kstedman.mathapplication.adapters.WolframListAdapter;
import com.example.kstedman.mathapplication.models.WolframResponseModel;
import com.example.kstedman.mathapplication.services.WolframService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class SolveActivity extends AppCompatActivity {
    public static final String TAG = SolveActivity.class.getSimpleName();

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
//    @Bind(R.id.inputEquation) TextView mEquationText;

    private WolframListAdapter mAdapter;

    public ArrayList<WolframResponseModel> mResults = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solve);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String equation = intent.getStringExtra("question");

//        mEquationText.setText(equation);

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
                Log.v("solve log", mResults.toString());

                SolveActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {

                        mAdapter = new WolframListAdapter(getApplicationContext(), mResults);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManger = new LinearLayoutManager(SolveActivity.this);
                        mRecyclerView.setLayoutManager(layoutManger);
                        mRecyclerView.setHasFixedSize(true);

                    }
                });
            }
        });
    }
}
