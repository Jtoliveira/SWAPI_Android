package com.example.swapi;

public class Vehicles {

    String name;
    String model;
    String manufacturer;
    String crew;
    String passengers;

    public Vehicles(String name,String model, String manufacturer, String crew,String passengers ){
        this.name = name;
        this.model = model;
        this.manufacturer = manufacturer;
        this.crew = crew;
        this.passengers = passengers;
    }

    public String getPassengers() {
        return passengers;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getCrew() {
        return crew;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return "Model: " + model + '\n' +
                "Manufacturer: " + manufacturer + '\n' +
                "Crew: " + crew + '\n' +
                "Passengers: " + passengers + '\n';
    }
}
