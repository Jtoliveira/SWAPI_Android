package com.example.swapi;

import android.os.AsyncTask;
import android.os.Build;

import androidx.annotation.RequiresApi;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownloadVehicles extends AsyncTask<String, Void, String> {

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

            String name,model, manufacturer, crew, passengers;

            name = jsonObject.getString("name");

            model = jsonObject.getString("model");

            manufacturer = jsonObject.getString("manufacturer");

            crew = jsonObject.getString("crew");

            passengers = jsonObject.getString("passengers");

            if (name != "" && model!= "" && manufacturer != "" && crew != "" && passengers !="") { //data has been received
                MainActivity.answerVehicles = new Vehicles(name, model,manufacturer, crew, passengers);
                MainActivity.vehiclesTextView.setText(MainActivity.answerVehicles.toString());
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
