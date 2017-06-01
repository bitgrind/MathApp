package com.example.kstedman.mathapplication;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

public class WolframService {

    public static void solveMathEquation(String questionEquation, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder().build();

        //Build the URL
        HttpUrl.Builder urlBuilder = HttpUrl.parse(WolframConstants.WOLFRAM_URL).newBuilder();
        String url = urlBuilder.build().toString();

        //Build the Request
        Request request = new Request.Builder().url(url).build();
        Log.v("WolfServiceUrl", url);

        //Make the Call
        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<WolframResponseModel> processAnswer(Response response){
        ArrayList<WolframResponseModel> results = new ArrayList<>();
        try {
            String jsonData = response.body().string();
            Log.d("wolfservice json: ", jsonData);
            if(response.isSuccessful()) {
                JSONObject wolframJSON = new JSONObject(jsonData);
                JSONArray wolframResponse = wolframJSON.getJSONArray("queryresult");
                Log.d("wolframResponse",wolframResponse.toString());
                for(int i  = 0; i < wolframResponse.length(); i++) {
                    JSONObject resultJSON = wolframResponse.getJSONObject(i);
                    String responseType = resultJSON.getString("title");

                    WolframResponseModel responseObj = new WolframResponseModel(responseType);
                    results.add(responseObj);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch(JSONException e){
            e.printStackTrace();
        }
        return results;
    };
}
