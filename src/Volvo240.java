import java.awt.*;

/**
 * A subclass of Car
 */
public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;

    /**
     * The constructor
     * Calls Car
     * Sets some variables to represent the Volvo240
     * @param position is the position where the car starts
     * */
    protected Volvo240(double[] position) {
        super(position);
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }

    /**
     * Calculates and returns the speedFactor
     * @return speedFactor
     */
    public double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }

}