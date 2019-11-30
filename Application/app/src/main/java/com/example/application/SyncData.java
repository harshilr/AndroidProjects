package com.example.application;

import android.os.AsyncTask;

public class SyncData extends AsyncTask<String, Void, String> {
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
            super.onPostExecute(s);
    }

    @Override
    protected String doInBackground(String... strings) {

        String jsonUrl = strings[0];

        HttpHandler httpHandler = new HttpHandler();
        String json= httpHandler.responseService(jsonUrl);

        System.out.println("Response from AsyncTask :"+json);

        return json;
    }
}
