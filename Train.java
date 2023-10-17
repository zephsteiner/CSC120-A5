import java.util.ArrayList;

public class Train {
    
    public final Engine engine;
    private ArrayList<Car> cars;
    private int maxCapacity;
    
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

    public Engine getEngine() {
        return this.engine;
    }

    public Car getCar(int i) {
        return this.cars.get(i);
    }

    public int getMaxCapacity() {
        return this.maxCapacity;
    }

    public int seatsRemaining() {
        int seatsLeft = 0;
        for (Car c : cars) {
            seatsLeft += c.seatsRemaining();
        }
        return seatsLeft;
    }

    public void printManifest() {
        System.out.println("Train Manifest:");
        for (Car c : cars) {
            System.out.println("------------------");
            c.printManifest();
        }
    }

    //catch the get on get off method exceptions
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
