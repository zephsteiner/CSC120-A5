/**
 * Class representing a train passenger
 */

public class Passenger {
    
    /** Name of passenger */
    private String name;

    /** Car on which the passender is */
    public Car car = null;


    /**
     * Creates a passenger with specified name
     * @param name Name of passenger
     */
    public Passenger(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the passenger
     * @return The passenger's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Adds a passenger to a car. This method makes use of the addPassenger method of the Car class
     * @param c What car to board
     */
    public void getOnCar(Car c) {
        if (this.car != null) {
            try {c.addPassenger(this);
            this.car = c;} catch(Exception e) {
                System.out.println("This car is full!");
            } 
        } else {
            System.out.println(this.name + " is already on a car. Try deboarding that car and try again.");}
    }

    /**
     * Removes a passenger from a car. This method makes use of the removePassenger method of the Car class
     * @param c What car to deboard
     */
    public void getOffCar(Car c) {
        try {c.removePassenger(this);
        this.car = null;} catch (Exception e) {
            System.out.println(this.name + " is not on this car.");
        }
    }
}
