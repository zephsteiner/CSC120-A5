import java.util.ArrayList;

/**
 * Class to represent a train 
 */
public class Train {
    
    /** Engine associated with the train */
    public final Engine engine;

    /** List of cars attatched to the engine */
    private ArrayList<Car> cars;

    /** How many passengers fit on the train? */
    private int maxCapacity;
    
    /**
     * 
     * @param fuelType Kind of fuel used by engine
     * @param fuelCapacity How much fuel the engine can hold
     * @param nCars Number of desired cars for the train
     * @param passengerCapacity How many passengers can fit on the train
     */
    public Train(FuelType fuelType, double fuelCapacity, int nCars, int passengerCapacity) {
        this.engine = new Engine(fuelType, fuelCapacity);
        this.cars = new ArrayList<Car>(nCars);
        this.maxCapacity = passengerCapacity;
        if (passengerCapacity%nCars != 0) {
            int carCapacity = passengerCapacity/(nCars-1);
            int cabooseCapacity = passengerCapacity%(nCars-1);
            //System.out.println("carCapacity: " + carCapacity + " & cabooseCapacity: " + cabooseCapacity);
            for (int i = 0; i < (nCars-1); i++) {
                //System.out.println(i);
                Car c = new Car(carCapacity);
                this.cars.add(c);
                // System.out.println("Added car with capacity " + carCapacity);
            }
            Car caboose = new Car(cabooseCapacity);
            this.cars.add(caboose);
            // System.out.println("Added caboose with capacity " + cabooseCapacity);
        } else {
            int carCapacity = passengerCapacity/nCars;
            for (int i = 0; i < nCars; i++) {
                Car c = new Car(carCapacity);
                this.cars.add(c);
                // System.out.println("Added car with capacity " + carCapacity);
            }
        }
    }

    /**
     * Gets the engine object associated with the train
     * @return The engine object associated with the train
     */
    public Engine getEngine() {
        return this.engine;
    }

    /**
     * Gets a car object
     * @param i The number of the desired car
     * @return The desired car object
     */
    public Car getCar(int i) {
        return this.cars.get(i);
    }

    /**
     * Gets the maximum capacity of the train
     * @return The maximum capacity of the train
     */
    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    /**
     * Checks how many seats the train has remaining
     * @return Number of seats remaining on the train
     */
    public int seatsRemaining() {
        int seatsLeft = 0;
        for (Car c : cars) {
            seatsLeft += c.seatsRemaining();
        }
        return seatsLeft;
    }

    /**
     * Allows a passenger to board the train. This method checks if there is space in cars going down the line from the engine
     * @param p The passenger attempting to board
     */
    public void boardTrain(Passenger p) {
        for (Car c : cars) {
            try {
                c.addPassenger(p);
                break;
            } catch (Exception e) {
                continue;
            }

        }
    }

    /**
     * Prints a manifest of all passengers on the train
     */
    public void printManifest() {
        System.out.println("Train Manifest:");
        for (Car c : cars) {
            System.out.println("------------------");
            c.printManifest();
        }
    }

    /**
     * Testing
     * @param args
     */
    public static void main(String[] args) {
        Train t = new Train(FuelType.STEAM, 10.0, 3, 13);
        // System.out.println(t.cars);
        Passenger p1 = new Passenger("Lisa");
        Passenger p2 = new Passenger("Maureen");
        Passenger p3 = new Passenger("Kathy");
        t.getCar(0).addPassenger(p1);
        t.getCar(0).addPassenger(p2);
        t.getCar(0).addPassenger(p3);
        t.printManifest();

    }
}
