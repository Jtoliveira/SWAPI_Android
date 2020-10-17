package com.example.swapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import androidx.gridlayout.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    //Answers
    public static People answerPeople;
    public static Film answerFilm;
    public static Planets answerPlanets;
    public static Species answerSpecies;
    public static Starships answerStarships;
    public static Vehicles answerVehicles;

    //Layouts
    GridLayout mainGrid;
    RelativeLayout peopleLayout;
    RelativeLayout filmsLayout;
    RelativeLayout planetsLayout;
    RelativeLayout speciesLayout;
    RelativeLayout starshipsLayout;
    RelativeLayout vehiclesLayout;

    //Text views and inputs
    static TextView peopleTextView;
    EditText peopleEditText;
    static TextView filmsTextView;
    EditText filmsEditText;
    static TextView planetsTextView;
    EditText planetsEditText;
    static TextView speciesTextView;
    EditText speciesEditText;
    static TextView starshipsTextView;
    EditText starshipsEditText;
    static TextView vehiclesTextView;
    EditText vehiclesEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hideSystemUI();

        mainGrid = (GridLayout) findViewById(R.id.mainGrid);

        peopleLayout = findViewById(R.id.peopleLayout);
        peopleTextView = findViewById(R.id.peopleTextView);
        peopleEditText = findViewById(R.id.peopleEditText);

        filmsLayout = findViewById(R.id.filmsLayout);
        filmsTextView = findViewById(R.id.filmsTextView);
       filmsEditText = findViewById(R.id.filmsEditText);
       filmsTextView.setMovementMethod(new ScrollingMovementMethod()); //scrollable text view

        planetsLayout = findViewById(R.id.planetsLayout);
        planetsTextView = findViewById(R.id.planetsTextView);
        planetsEditText = findViewById(R.id.planetsEditText);

        speciesLayout = findViewById(R.id.speciesLayout);
        speciesTextView = findViewById(R.id.speciesTextView);
        speciesEditText = findViewById(R.id.speciesEditText);

        starshipsLayout = findViewById(R.id.starshipsLayout);
        starshipsTextView = findViewById(R.id.starshipsTextView);
        starshipsEditText = findViewById(R.id.starshipsEditText);

        vehiclesLayout = findViewById(R.id.vehiclesLayout);
        vehiclesTextView = findViewById(R.id.vehiclesTextView);
        vehiclesEditText = findViewById(R.id.vehiclesEditText);
    }

    //These functions could be just one "switchMain" function,
    // but i don't know how to get the parent of the pressed button in each layout
    public void peopleReturnMain(View view){
      peopleLayout.setVisibility(View.INVISIBLE);
       mainGrid.setVisibility(View.VISIBLE);
    }

    public void filmsReturnMain(View view){
        filmsLayout.setVisibility(View.INVISIBLE);
        mainGrid.setVisibility(View.VISIBLE);
    }

    public void planetsReturnMain(View view){
        planetsLayout.setVisibility(View.INVISIBLE);
        mainGrid.setVisibility(View.VISIBLE);
    }

    public void speciesReturnMain(View view){
        speciesLayout.setVisibility(View.INVISIBLE);
        mainGrid.setVisibility(View.VISIBLE);
    }

    public void starshipsReturnMain(View view){
        starshipsLayout.setVisibility(View.INVISIBLE);
        mainGrid.setVisibility(View.VISIBLE);
    }

    public void vehiclesReturnMain(View view){
        vehiclesLayout.setVisibility(View.INVISIBLE);
        mainGrid.setVisibility(View.VISIBLE);
    }

    //Main grid -> Layouts
    public void switchPeople(View view){
        mainGrid.setVisibility(View.INVISIBLE);
        peopleLayout.setVisibility(View.VISIBLE);
        generatePeople();
    }

    public void switchFilms(View view){
        mainGrid.setVisibility(View.INVISIBLE);
        filmsLayout.setVisibility(View.VISIBLE);
        generateFilm();
    }

    public void switchPlanets(View view){
        mainGrid.setVisibility(View.INVISIBLE);
        planetsLayout.setVisibility(View.VISIBLE);
        generatePlanets();
    }

    public void switchSpecies(View view){
        mainGrid.setVisibility(View.INVISIBLE);
        speciesLayout.setVisibility(View.VISIBLE);
        generateSpecies();
    }

    public void switchStarships(View view){
        mainGrid.setVisibility(View.INVISIBLE);
        starshipsLayout.setVisibility(View.VISIBLE);
        generateStarships();
    }

    public void switchVehicles(View view){
        mainGrid.setVisibility(View.INVISIBLE);
        vehiclesLayout.setVisibility(View.VISIBLE);
        generateVehicles();
    }

    //New Requests at the API
    public void generatePeople(){
        DownloadPeople dl = new DownloadPeople();

        Random rand  = new Random();

        int n = rand.nextInt(82); //0 to 81

        n += 1; //1 to 82

        dl.execute("https://swapi.dev/api/people/" + n + "/"); //random person in the API
    }

    public void generateFilm(){
        DownloadFilm dl = new DownloadFilm();

        Random rand  = new Random();

        int n = rand.nextInt(6); //0 to 5

        n += 1; //1 to 6

        dl.execute("https://swapi.dev/api/films/" + n + "/"); //random film in the API
    }

    public void generatePlanets(){
        DownloadPlanets dl = new DownloadPlanets();

        Random rand  = new Random();

        int n = rand.nextInt(60); //0 to 59

        n += 1; //1 to 60

        dl.execute("https://swapi.dev/api/planets/" + n + "/"); //random film in the API
    }

    public void generateSpecies(){
        DownloadSpecies dl = new DownloadSpecies();

        Random rand  = new Random();

        int n = rand.nextInt(37);

        n += 1;

        dl.execute("https://swapi.dev/api/species/" + n + "/"); //random film in the API
    }

    public void generateStarships(){
        DownloadStarships dl = new DownloadStarships();

        Random rand  = new Random();

        Integer[] ships = {2,3,5,9,10,11,12,13,15,17,21,22,23,27,28,29,31,32};

        int n = rand.nextInt(ships.length);


        dl.execute("https://swapi.dev/api/starships/" + ships[n] + "/"); //random film in the API
    }

    public void generateVehicles(){
        DownloadVehicles dl = new DownloadVehicles();

        Random rand  = new Random();

        Integer[] vehicles = {4,6,7,8,14,16,18,19,20,24,25,26,30,33,34,35,36,37,38};

        int n = rand.nextInt(vehicles.length);

        dl.execute("https://swapi.dev/api/vehicles/" + vehicles[n] + "/"); //random film in the API
    }

    //Evaluation of input and Toast with "correct" or "incorrect"
   public void peopleAnswer(View view){

        if(peopleEditText.getText().toString().toLowerCase().equals(answerPeople.getName().toLowerCase())){
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Incorrect, it was " + answerPeople.getName(), Toast.LENGTH_SHORT).show();
        }

        peopleEditText.setText("");
        generatePeople();
    }

    public void filmAnswer(View view){
        if(filmsEditText.getText().toString().toLowerCase().equals(answerFilm.getTitle().toLowerCase())){
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Incorrect, it was " + answerFilm.getTitle(), Toast.LENGTH_SHORT).show();
        }

        filmsEditText.setText("");
        generateFilm();
    }

    public void planetAnswer(View view){
        if(planetsEditText.getText().toString().toLowerCase().equals(answerPlanets.getName().toLowerCase())){
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Incorrect, it was " + answerPlanets.getName(), Toast.LENGTH_SHORT).show();
        }

        planetsEditText.setText("");
        generatePlanets();
    }

    public void speciesAnswer(View view){
        if(speciesEditText.getText().toString().toLowerCase().equals(answerSpecies.getName().toLowerCase())){
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Incorrect, it was " + answerSpecies.getName(), Toast.LENGTH_SHORT).show();
        }

        speciesEditText.setText("");
        generateSpecies();
    }

    public void starshipsAnswer(View view){
        if(starshipsEditText.getText().toString().toLowerCase().equals(answerStarships.getName().toLowerCase())){
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Incorrect, it was " + answerStarships.getName(), Toast.LENGTH_SHORT).show();
        }

        starshipsEditText.setText("");
        generateStarships();
    }

    public void vehiclesAnswer(View view){
        if(vehiclesEditText.getText().toString().toLowerCase().equals(answerVehicles.getName().toLowerCase())){
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Incorrect, it was " + answerVehicles.getName(), Toast.LENGTH_SHORT).show();
        }

        vehiclesEditText.setText("");
        generateVehicles();
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

    //method from https://developer.android.com/training/system-ui/immersive#java to make the app fullscreen
    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

}