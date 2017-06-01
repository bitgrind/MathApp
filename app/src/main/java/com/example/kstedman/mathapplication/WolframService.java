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

    public ArrayList<WolframResponseModel> processAnswer(Response result){
        ArrayList<WolframResponseModel> results = new ArrayList<>();
        System.out.println(result);
        try {
            String jsonData = result.body().string();

            if(result.isSuccessful()) {
                JSONObject wolframJSON = new JSONObject(jsonData);
                JSONArray wolframResponse = wolframJSON.getJSONArray("pods");
                String logLength = Integer.toString(wolframResponse.length());
                Log.v("pods", logLength);

                for(int i  = 0; i < wolframResponse.length(); i++) {
                    JSONObject responseJSON = wolframResponse.getJSONObject(i);
                    String responseType = responseJSON.getString("title");

                    WolframResponseModel response = new WolframResponseModel(responseType);
                    results.add(response);
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
