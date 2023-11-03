import java.awt.*;

public class Volvo240 extends Car {

    private final static double trimFactor = 1.25;
    protected Volvo240(double[] position) {
        super(position);
        nrDoors = 4;
        color = Color.black;
        enginePower = 100;
        modelName = "Volvo240";
        stopEngine();
    }

    public double speedFactor() {
        return enginePower * 0.01 * trimFactor;
    }

    protected void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    protected void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }
}