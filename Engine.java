/**
 * Class representing a train engine
 */
public class Engine {
    
    /** What kind of fuel does the engine use? */
    private FuelType f;

    /** Current level of fuel in the engine */
    private double currentFuelLevel;

    /** How much fuel can the engine hold? */
    private double maxFuelLevel;

    /**
     * Creates an engine with specifid type and amount of fuel
     * @param fuel Kind of fuel for this engine
     * @param maxFuelLevel Amount of fuel the engine can hold
     */
    public Engine(FuelType fuel, double maxFuelLevel) {
        this.f = fuel;
        this.currentFuelLevel = maxFuelLevel;
        this.maxFuelLevel = maxFuelLevel;
    }

    /**
     * Gets the type of fuel the engine uses
     * @return The type of fuel the engine uses
     */
    public FuelType getFuelType() {
        return this.f;
    }

    /**
     * Gets the current fuel level of the engine
     * @return The current fuel level of the engine
     */
    public double getCurrentFuelLevel() {
        return this.currentFuelLevel;
    }

    /**
     * Gets the max fuel level of the engine
     * @return The maximum fuel level of the engine
     */
    public double getMaxFuelLevel() {
        return this.maxFuelLevel;
    }

    /**
     * Refuels the train engine up to the max fuel level
     */
    public void refuel() {
        this.currentFuelLevel = this.maxFuelLevel;
    }

    /**
     * Simulates the train going by reducing the current fuel level by ten percent of the maximum
     */
    public void go() {
        // reduces the amount of fuel by like 10 percent??? idk what this should do
        double tenpercent = this.maxFuelLevel/10;
        if (this.currentFuelLevel <= tenpercent) {
            throw new RuntimeException("Insufficent fuel level. Time to refuel!");
        }
        this.currentFuelLevel -= tenpercent;
        if (this.currentFuelLevel < 0) {
            this.currentFuelLevel = 0;
        }
    }
}