import java.util.ArrayList;

public class Car {
    
    private ArrayList<Passenger> passengersOnboard;
    private int maxCapacity;

    public Car(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.passengersOnboard = new ArrayList<Passenger>(maxCapacity);
    }

    public int getCapacity() {
        return this.passengersOnboard.size();
    }

    public int seatsRemaining() {
        int seats = maxCapacity - this.passengersOnboard.size();
        return seats;
    }

    public void addPassenger(Passenger p) {
        this.passengersOnboard.add(p);
        // check if there's space, exception if not -> move to next car?
        p.car = this;
    }

    public void removePassenger(Passenger p) {
        try {
            this.passengersOnboard.remove(p);
        } catch (Exception e) {
            System.out.println(p + " not found.");
        }
    }

    public void printManifest() {
        System.out.println("Manifest:");
        if (!passengersOnboard.isEmpty()) {
            for (Passenger p: passengersOnboard) {
                System.out.println("- " + p.getName());
            }
        } else {
            System.out.println("This car is empty.");
        }
    }
}