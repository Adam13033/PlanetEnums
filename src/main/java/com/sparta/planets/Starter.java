package com.sparta.planets;

import java.math.BigDecimal;
import java.util.Scanner;

public class Starter {
    public static void start() {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Please select which planet you'd like to enquire about.");
            System.out.println("You can select mercury, venus, earth, mars, jupiter, saturn, uranus or neptune");
            String planetSelection = input
                    .nextLine()
                    .toUpperCase();
            System.out.println("Could I also ask your weight in pounds(lb), so that we can see how much you'd weigh on your planet?");
            Double userWeight = input.nextDouble();
            double testing = PlanetProject
                    .valueOf(planetSelection)
                    .getWeightOnPlanet(userWeight);
            BigDecimal distanceFromSun = PlanetProject
                    .valueOf(planetSelection)
                    .getDistanceFromSun();
            BigDecimal planetMass = PlanetProject
                    .valueOf(planetSelection)
                    .getMass();
            System.out.println("You chose: " + planetSelection + " , on this planet you'd weigh: " + testing + "lb");
            System.out.println(planetSelection + " is approximately " + distanceFromSun + "km from the sun!");
            System.out.println("And has a mass of: " + planetMass + "kg");

        } catch (java.util.InputMismatchException e) {
            System.out.println("Error: " + e);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e);
        }
    }

}
