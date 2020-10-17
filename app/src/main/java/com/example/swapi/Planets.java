package com.example.swapi;

import java.util.Arrays;

public class Planets {

    String name;
    String climate;
    String terrain;
    String[] films;

    public Planets(String name, String climate, String terrain, String[] films){
        this.name = name;
        this.climate = climate;
        this.terrain = terrain;
        this.films =films;

        //translate the movies from URL to titles
        for(int i  = 0; i < films.length; i++)
            this.films[i] = MainActivity.translateMovies(films[i]); //there aren't lambdas in the api level i chose
    }

    //some planets don't have any info and null films arrays, gotta account for that in the constructor
    public Planets(String name, String climate, String terrain) {
        this.name = name;
        this.climate = climate;
        this.terrain = terrain;
    }

    public String getName() {
        return name;
    }

    public String getClimate() {
        return climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public String getFilms(String[] filmsArray) {
        String result = "";

        for( String s : filmsArray)
            result += s + "; ";

        return result.replace(result.charAt(result.lastIndexOf(";")), ' ');
    }

    @Override
    public String toString() {
        return "Climate: " + climate + '\n' +
                "Terrain: " + terrain + '\n' +
                "Films: " + getFilms(this.films);
    }

    public String toStringNoArray(){
        return "Climate: " + climate + '\n' +
                "Terrain: " + terrain + '\n';
    }
}
