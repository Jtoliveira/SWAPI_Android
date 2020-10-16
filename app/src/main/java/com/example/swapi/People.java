package com.example.swapi;

import android.os.Build;
import androidx.annotation.RequiresApi;

public class People {

    String name;
    String height;
    String hairColor;
    String skinColor;
    String gender;
    String[] films;

    @RequiresApi(api = Build.VERSION_CODES.N)
    public People(String name, String height, String hairColor, String skinColor, String gender, String[] films){
        this.name = name;
        this.height = height;
        this.films =films;

        //translate the movies from URL to titles
        for(int i  = 0; i < films.length; i++)
            this.films[i] = MainActivity.translateMovies(films[i]); //there aren't lambdas in the api level i chose

        this.hairColor = hairColor;
        this.skinColor = skinColor;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getHairColor() {
        return hairColor;
    }

    public String getSkinColor() {
        return skinColor;
    }

    public String getHeight() {
        return height;
    }

    public String getFilms(String[] filmsArray) {
        String result = "";

        for( String s : filmsArray)
            result += s + "; ";

        return result.replace(result.charAt(result.lastIndexOf(";")), ' ');
    }

    @Override
    public String toString() {
        return "Height: " + height + " cm" + '\n' +
                "Hair Color: " + hairColor + '\n' +
                "Skin Color: " + skinColor + '\n' +
                "Gender: " + gender + '\n' +
                "Films: " + getFilms(this.films);
    }
}
