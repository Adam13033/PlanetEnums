package com.sparta.planets;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum PlanetProject {
    MERCURY("Mercury", 3.303e+23, 0.4, 0.38),
    VENUS("VENUS", 4.869e+24, 0.72, 0.91),
    EARTH("EARTH", 5.976e+24, 1, 1),
    MARS("MARS",6.421e+23 , 1.5245, 0.38),
    JUPITER("JUPITER", 1.9e+27, 5.2, 2.34),
    SATURN("SATURN",5.688e+26 , 9.54, 1.06),
    URANUS("URANUS",8.686e+25 , 19.2, 0.92),
    NEPTUNE("NEPTUNE", 1.024e+26, 30.06, 0.06);

    private final String planetName;
    private final double mass;
    private double distanceFromSun;
    private double relativeWeightIndex;


    // let
    // var
    // const = Don't change this.

    // final -- Don't change this value - Compiler won't allow it.
    // Protected - Package bound - Can only be accessed inside of the same package




    PlanetProject(String planetName, double mass, double distanceFromSun, double relativeWeightIndex) {
        this.planetName = planetName;
        this.mass = mass;
        this.distanceFromSun = distanceFromSun;
        this.relativeWeightIndex = relativeWeightIndex;
    }


    public String getPlanetName() {
        return planetName;
    }
    public BigDecimal getDistanceFromSun() {
        BigDecimal distance = new BigDecimal(distanceFromSun * 1.496e+8).setScale(2, RoundingMode.UNNECESSARY);
        return distance;
    }
    public BigDecimal getMass() {
        BigDecimal planetMass = new BigDecimal(mass);
        planetMass = planetMass .setScale(2, RoundingMode.HALF_DOWN);
        return planetMass;
    }

    protected double getWeightOnPlanet(double weight) {
        return weight * relativeWeightIndex;
    }
}
