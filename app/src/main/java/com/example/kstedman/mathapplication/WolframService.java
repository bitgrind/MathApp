package com.example.kstedman.mathapplication;

import android.util.Log;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
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
}
