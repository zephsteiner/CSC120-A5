public class Passenger {
    
    private String name;
    public Car car;

    public Passenger(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void getOnCar(Car c) {
        try {c.addPassenger(this);
        this.car = c;} catch(Exception e) {
            System.out.println("This car is full!");
        }
    }

    public void getOffCar(Car c) {
        try {c.removePassenger(this);
        this.car = null;} catch (Exception e) {
            System.out.println(this.name + " is not on this car.");
        }
    }
}
