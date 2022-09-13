## <b> Planet Enum Project </b>


### Project overview 
This project was created in the image of the following criteria:
- Create an enum 'Planet', containing 8 values representing the planets in the solar system
- Each value should contain the following:
  - Name of the planet
  - Average distance from the sun
  - Mass
  - Relative weight index
- Include a method which takes in a weight and returns weight on selected planet by multiplying the input value(s) by the
   relative weight index of the selected planet.


## How  it works 
The application works by initially prompting you to input a planet, as a user you'll have a selection of the following:
- Mercury
- Venus
- Earth
- Mars
- Jupiter
- Saturn
- Uranus
- Pluto

When inputting one of th above values, you'll be prompted to enter your weight in pounds(lb). Once entered, your input value will
be multiplied by the relative weight index for that planet returning how much you'd weigh on that planet.

When all values have been entered and submitted, all relevant data associated to enum will be returned informing of

## What it looks like

### Main method 
My main method effectively serves as a switchboard for user interaction and navigation through the application.
As is visible below, the user is prompted to input  a planet initially, followed by a prompt for weight.
The planetary value input is screened and input to the appropriate methods inside of PlanetProject.
```java
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
```

The below snippet is the data structure of the enum, which as specifications instructed containes
the relevant data for retrieval and usage by the user: 

```java
    MERCURY("Mercury", 3.303e+23, 0.4, 0.38),
    VENUS("VENUS", 4.869e+24, 0.72, 0.91),
    EARTH("EARTH", 5.976e+24, 1, 1),
    MARS("MARS",6.421e+23 , 1.5245, 0.38),
    JUPITER("JUPITER", 1.9e+27, 5.2, 2.34),
    SATURN("SATURN",5.688e+26 , 9.54, 1.06),
    URANUS("URANUS",8.686e+25 , 19.2, 0.92),
    NEPTUNE("NEPTUNE", 1.024e+26, 30.06, 0.06);
```

We later have our variables declared, as well as our constructor which ensures correct formation and entry of data:
```java
 private final String planetName;
    private final double mass;
    private double distanceFromSun;
    private double relativeWeightIndex;

    PlanetProject(String planetName, double mass, double distanceFromSun, double relativeWeightIndex) {
        this.planetName = planetName;
        this.mass = mass;
        this.distanceFromSun = distanceFromSun;
        this.relativeWeightIndex = relativeWeightIndex;
    }

```

Following on from here, we have our means of data retrieval, referred to as 'getters', or 'accessors'.
With the data being excessively long, I opted into using <b> BigDecimal </b> on the basis that I'm able
to trim excess data off, while remaining accurate in figures returned.
Without having done this, the data returned to the user is very messy and illegible, providing little use to the user.
```java
    public BigDecimal getDistanceFromSun() {

        BigDecimal distance = new BigDecimal(distanceFromSun * 1.496e+8).setScale(2, RoundingMode.UNNECESSARY);
        return distance;
    }
    public BigDecimal getMass() {
        BigDecimal planetMass = new BigDecimal(mass);
        planetMass = planetMass .setScale(2, RoundingMode.UNNECESSARY);
        return planetMass;
    }
```

The final method contained within my PlanetProject enum serves the purpose of obtaining
the relative weight of the user on their selected planet:

```java
    protected double getWeightOnPlanet(double weight) {
        return weight * relativeWeightIndex;
        }
```