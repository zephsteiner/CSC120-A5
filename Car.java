import java.util.ArrayList;

/**
 * Class representing a train car
 */
public class Car {
    
    /** List of passengers aboard */
    private ArrayList<Passenger> passengersOnboard;

    /** How many massengers fit in the car? */
    private int maxCapacity;

    /**
     * Creates a car with specified maximum passenger capacity
     * @param maxCapacity The number of passengers that fit in the train car
     */
    public Car(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.passengersOnboard = new ArrayList<Passenger>(maxCapacity);
    }

    /**
     * Gets the maximum capacity of the car
     * @return The maximum capacity of the car
     */
    public int getCapacity() {
        return this.maxCapacity;
    }

    /**
     * Finds the number of seats remaining in the car
     * @return The number of seats remaining in the car
     */
    public int seatsRemaining() {
        int seats = maxCapacity - this.passengersOnboard.size();
        return seats;
    }

    /**
     * Allows a passenger to board the car
     * @param p The passenger boarding the car
     */
    public void addPassenger(Passenger p) {
        if (this.passengersOnboard.size() == maxCapacity) {
            throw new RuntimeException("Car is full.");
        } 
        if (this.passengersOnboard.contains(p)) {
            throw new RuntimeException("Already on board.");
        }
        this.passengersOnboard.add(p);
        // check if there's space, exception if not -> move to next car? do this in train
    }

    /**
     * Allows a passenger to deboard the car
     * @param p The passenger deboarding the car
     */
    public void removePassenger(Passenger p) {
        if (!this.passengersOnboard.contains(p)) {
            throw new RuntimeException("Passenger not found.");
        }
        this.passengersOnboard.remove(p);
    }

    /**
     * Object to String
     * @return toString()
     */
    public String toString() {
        return "Car with capacity " + this.maxCapacity;
    }

    /**
     * Creates a manifest of the passengers currently aboard a specified car
     * @return A formatted string containing the names of all the passengers on a car
     */
    public String getManifest() {
        //System.out.println("Car Manifest:");
        StringBuilder manifest = new StringBuilder("Car Manifest:");
        if (!passengersOnboard.isEmpty()) {
            //String[] manifest = new String[maxCapacity+1];
            for (Passenger p: passengersOnboard) {
                manifest.append("\n- " + p.getName());
                //System.out.println("- " + p.getName());
            }
        } else {
            manifest.append("\nThis car is empty.");
            //System.out.println("This car is empty.");
        }
        return manifest.toString();
    }

    /**
     * Prints a manifest of passengers aboard a car
     */
    public void printManifest() {
        System.out.println(this.getManifest());
    }

    /**
     * For testing
     * @param args
     */
    public static void main(String[] args) {
        Car car1 = new Car(10);
        Passenger p1 = new Passenger("Lisa");
        Passenger p2 = new Passenger("Maureen");
        Passenger p3 = new Passenger("Kathy");
        car1.addPassenger(p1);
        car1.addPassenger(p2);
        car1.addPassenger(p3);
        car1.printManifest();
    }
}