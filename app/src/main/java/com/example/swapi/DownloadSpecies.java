package com.example.swapi;

import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.RequiresApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadSpecies extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... urls) {

        String result = "";

        URL url;

        HttpURLConnection urlConnection = null;

        try {
            url = new URL(urls[0]);

            urlConnection = (HttpURLConnection) url.openConnection();

            InputStream inputStream = urlConnection.getInputStream();

            InputStreamReader reader = new InputStreamReader(inputStream);

            int data = reader.read();

            while(data != -1) {
                char current = (char ) data;

                result += current;

                data = reader.read();
            }

            return result;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        try {
            JSONObject jsonObject = new JSONObject(s);

            JSONArray films;

            String name,classification, designation, averageLifespan, language;

            name = jsonObject.getString("name");

            classification = jsonObject.getString("classification");

            designation = jsonObject.getString("designation");

            averageLifespan = jsonObject.getString("average_lifespan");

            language = jsonObject.getString("language");

            if (name != "" && classification != "" && designation != "" && averageLifespan !="" && language != "") { //data has been received
                MainActivity.answerSpecies = new Species(name, classification, designation, averageLifespan, language);
                MainActivity.speciesTextView.setText(MainActivity.answerSpecies.toString());
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
