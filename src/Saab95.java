import java.awt.*;


/**
 * A subclass of Car
 */
public class Saab95 extends Car {

    /**
     * State of turbo(on/off)
     */
    private boolean turboOn;

    /**
     * The constructor
     * Calls Car
     * Sets some variables to represent the Saab95
     * and sets the speed to 0
     * @param position is the position where the car starts
     * */
    protected Saab95(double[] position) {
        super(position);
        nrDoors = 2;
        color = Color.red;
        enginePower = 125;
        turboOn = false;
        modelName = "Saab95";
        stopEngine();
    }

    /**
     * Sets the turbo to true
     */
    public void setTurboOn() {
        turboOn = true;
    }

    /**
     * Sets the turbo to false
     */
    public void setTurboOff() {
        turboOn = false;
    }


    /**
     * Calculates and returns the speedFactor
     * @return speedFactor
     */
    public double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return enginePower * 0.01 * turbo;
    }
}