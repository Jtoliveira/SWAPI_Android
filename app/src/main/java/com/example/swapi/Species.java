package com.example.swapi;

public class Species {

    String name;
    String classification;
    String designation;
    String averageLifeSpan;
    String language;

    public Species(String name,  String classification, String designation, String averageLifeSpan, String language){
        this.name = name;
        this.classification = classification;
        this.designation = designation;
        this.averageLifeSpan = averageLifeSpan;
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public String getAverageLifeSpan() {
        return averageLifeSpan;
    }

    public String getClassification() {
        return classification;
    }

    public String getDesignation() {
        return designation;
    }

    public String getLanguage() {
        return language;
    }

    @Override
    public String toString() {
        return "Classification: " + classification + '\n' +
                "Designation: " + designation + '\n' +
                "Average Lifespan: " + averageLifeSpan + '\n' +
                "Language: " + language + '\n';
    }
}
