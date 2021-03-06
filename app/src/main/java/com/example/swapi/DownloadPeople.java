package com.example.swapi;

import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

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

public class DownloadPeople extends AsyncTask<String, Void, String> {

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

            String name,height, hairColor,skinColor,gender;

                name = jsonObject.getString("name");

                height = jsonObject.getString("height");

                hairColor = jsonObject.getString("hair_color");

                skinColor = jsonObject.getString("skin_color");

                gender = jsonObject.getString("gender");

                films = jsonObject.getJSONArray("films");

                String[] filmsArray = new String[films.length()];

                for(int j  = 0; j < films.length(); j++){
                   filmsArray[j] = films.getString(j);
                }

                if(name != "" && height != "" && hairColor != "" && skinColor!= "" && gender !=""){ //data has been received
                   MainActivity.answerPeople = new People(name, height,hairColor, skinColor, gender,filmsArray);
                    MainActivity.peopleTextView.setText(MainActivity.answerPeople.toString());
                }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}