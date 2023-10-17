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
        if (this.passengersOnboard.size() == maxCapacity) {
            throw new RuntimeException("Car is full.");
        } 
        this.passengersOnboard.add(p);
        // check if there's space, exception if not -> move to next car? do this in train
    }

    public void removePassenger(Passenger p) {
        if (!this.passengersOnboard.contains(p)) {
            throw new RuntimeException("Passenger not found.");
        }
        this.passengersOnboard.remove(p);
    }

    public String toString() {
        return "Car with capacity " + this.maxCapacity;
    }

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

    public void printManifest() {
        System.out.println(this.getManifest());
    }

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