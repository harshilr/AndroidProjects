package com.example.application;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpHandler {

    public HttpHandler() {

    }

    public String responseService (String url){

        String response = null;
        try {
            URL mUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) mUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type","application/json");
            InputStream inputStream = new BufferedInputStream(connection.getInputStream());

            response = convertStream(inputStream);

        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }


        return response;
    }

    public String convertStream (InputStream inputStream){
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();

        String line;

        try {
            while ((line =reader.readLine())!=null){

                stringBuilder.append(line).append("\n");
            }
        }
        catch (IOException e){
            Log.e("ConvertStream Method",e.getMessage());
        }
        finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                Log.e("ConvertStream F Method",e.getMessage());
            }

                }

        return stringBuilder.toString();
    }

}
