package com.example.swapi;

public class Starships {

    String name;
    String manufacturer;
    String crew;
    String passengers;

    public Starships(String name,String manufacturer, String crew,String passengers  ){
        this.name = name;
        this.manufacturer = manufacturer;
        this.crew = crew;
        this.passengers = passengers;
    }

    public String getName() {
        return name;
    }

    public String getCrew() {
        return crew;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getPassengers() {
        return passengers;
    }

    @Override
    public String toString() {
        return "Manufacturer: " + manufacturer + '\n' +
                "Crew: " + crew + '\n' +
                "Passengers: " + passengers + '\n';
    }
}
