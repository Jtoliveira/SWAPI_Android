package com.example.swapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.gridlayout.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    public static People answerPeople;

    //Layouts
    GridLayout mainGrid;
    RelativeLayout peopleLayout;

    static TextView peopleTextView;
    EditText peopleEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);
        peopleLayout = findViewById(R.id.peopleLayout);
        peopleTextView = findViewById(R.id.peopleTextView);
        peopleEditText = findViewById(R.id.peopleEditText);

    }

    //These functions could be just one "switchMain" function,
    // but i don't know how to get the parent of the pressed button in each layout
    public void peopleReturnMain(View view){
      peopleLayout.setVisibility(View.INVISIBLE);
       mainGrid.setVisibility(View.VISIBLE);
    }

    //Main grid -> people Layout
    public void switchPeople(View view){
        mainGrid.setVisibility(View.INVISIBLE);
        peopleLayout.setVisibility(View.VISIBLE);
        generatePeople();
    }

    //New Request with another person
    public void generatePeople(){
        DownloadPeople dl = new DownloadPeople();

        Random rand  = new Random();

        int n = rand.nextInt(82); //0 to 81

        n += 1; //1 to 82

        Log.i("cenas", "https://swapi.dev/api/people/" + n + "/");

        dl.execute("https://swapi.dev/api/people/" + n + "/"); //random person in the API
    }

    //Evaluation of input and Toast with "correct" or "incorrect"
   public void peopleAnswer(View view){

        if(peopleEditText.getText().toString().equals(answerPeople.getName()) ){
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Incorrect, it was " + answerPeople.getName(), Toast.LENGTH_SHORT).show();
        }

        peopleEditText.setText("");
        generatePeople();
    }

    //Translates Movie urls into movie titles, saves another API request for the movie title since there's 6 movies in the API
    public static String translateMovies(String movie){
        Pattern getID = Pattern.compile("http://swapi.dev/api/films/(.*?)/");
        Matcher matcher = getID.matcher(movie);

        while(matcher.find()) {
            switch (matcher.group(1)) {
                case "1":
                    return "The Phantom Menace";
                case "2":
                    return "Attack of the Clones";
                case "3":
                    return "Revenge of the Sith";
                case "4":
                    return "A New Hope";
                case "5":
                    return "The Empire Strikes Back";
                case "6":
                    return "Return of the Jedi";
            }
        }
        return "";
    }
}