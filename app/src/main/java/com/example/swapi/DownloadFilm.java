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

public class DownloadFilm extends AsyncTask<String, Void, String> {

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

            String title,crawl, director,producer,release_date;

            title = jsonObject.getString("title");

            crawl = jsonObject.getString("opening_crawl");

            director = jsonObject.getString("director");

            producer = jsonObject.getString("producer");

            release_date = jsonObject.getString("release_date");

            if(title != "" && crawl != "" && director != "" && producer!= "" && release_date !=""){ //data has been received
                MainActivity.answerFilm = new Film(title, crawl,director, producer, release_date);
                MainActivity.filmsTextView.setText(MainActivity.answerFilm.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}