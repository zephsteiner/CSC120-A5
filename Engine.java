public class Engine {
    
    private FuelType f;
    double currentFuelLevel;
    double maxFuelLevel;

    public Engine(FuelType fuel, double maxFuelLevel) {
        this.f = fuel;
        this.currentFuelLevel = maxFuelLevel;
        this.maxFuelLevel = maxFuelLevel;
    }

    public FuelType getFuelType() {
        return this.f;
    }

    public double getCurrentFuelLevel() {
        return this.currentFuelLevel;
    }

    public double getMaxFuelLevel() {
        return this.maxFuelLevel;
    }

    public void refuel() {
        this.currentFuelLevel = this.maxFuelLevel;
    }

    public void go() {
        // reduces the amount of fuel by like 10 percent??? idk what this should do
        double tenpercent = this.maxFuelLevel/10;
        if (this.currentFuelLevel == 0) {
            throw new RuntimeException("Fuel level zero. Time to refuel!");
        }
        this.currentFuelLevel -= tenpercent;
        if (this.currentFuelLevel < 0) {
            this.currentFuelLevel = 0;
        }
    }
}