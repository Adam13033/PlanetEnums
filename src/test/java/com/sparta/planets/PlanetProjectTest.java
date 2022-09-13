package com.sparta.planets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

class PlanetProjectTest {
    double auInKm = 1.496e+8;
    @Test
    @DisplayName("Testing earth mass, expecting true")
    void earthMass() {
        BigDecimal mass = new BigDecimal(5.976e+24).setScale(2, RoundingMode.UNNECESSARY);
        Assertions.assertEquals(mass, PlanetProject.EARTH.getMass());
    }

    @Test
    @DisplayName("Testing weight calc on Earth")
    void relativeWeightIndex() {
        double userWeight = 1234.00;
        Assertions.assertEquals(userWeight, PlanetProject.EARTH.getWeightOnPlanet(userWeight));
    }

    @Test
    @DisplayName("Testing distance from sun, expecting true")
    void distanceFromSunMercury () {
        BigDecimal distanceFromSun = new BigDecimal(149600000).setScale(2, RoundingMode.UNNECESSARY) ;
        Assertions.assertEquals(distanceFromSun, PlanetProject.EARTH.getDistanceFromSun());
    }

    @Test
    @DisplayName("Testing distance from sun expecting true")
    void distanceFromSunVenus() {
       BigDecimal distanceSun = new BigDecimal(0.72 * auInKm).setScale(2, RoundingMode.UNNECESSARY);
       Assertions.assertEquals(distanceSun, PlanetProject.VENUS.getDistanceFromSun());
    }

    @Test
    @DisplayName("Testing getName expecting true")
    void getEarth() {
        Assertions.assertEquals("EARTH", PlanetProject.EARTH.getPlanetName());
    }

    @Test
    @DisplayName("Testing getName for jupiter expecting true")
    void getJupiter() {
        Assertions.assertEquals("JUPITER", PlanetProject.JUPITER.getPlanetName());
    }

    @Test
    @DisplayName("Testing relative weight on Earth expecting true")
    void relativeWeightEarth() {
        Assertions.assertEquals(123, PlanetProject.EARTH.getWeightOnPlanet(123));
    }

    @Test
    @DisplayName("Testing relative weight on uranus expecting true")
    void relativeWeightUranus() {
        double userWeight = 123 * 0.92;
        Assertions.assertEquals(userWeight, PlanetProject.URANUS.getWeightOnPlanet(123));
    }

}