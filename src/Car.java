import java.awt.*;
import java.security.InvalidParameterException;

/**
 * A class defining a basic car model with speed and direction on a 2d plane.
 */
abstract public class Car implements Movable{
    /**
     * The number of doors on the car
     */
    protected int nrDoors;
    /**
     * The engine power of the car
     */
    protected double enginePower;
    /**
     * The current speed of the car
     */
    protected double currentSpeed;
    /**
     * The color of the car
     */
    protected Color color;
    /**
     * The car model name
     */
    protected String modelName;
    /**
     * The position of the car
     */
    protected double[] position;
    /**
     * The direction of the car
     */
    protected double direction;

    /**
     * The constructor of the class
     */
    public Car(double[] position) {
        this.position = position;
    }

    /**
     *  Getters:
     */
     public double[] getPosition() {
        return position;
    }

    public int getNrDoors() {
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }


    public Color getColor() {
        return color;
    }

    /**
     *  Setters:
     */
    protected void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }


    public void stopEngine() {
        currentSpeed = 0;
    }

    /**
     * Returns the speedFactor of a car.
     * Can use enginePower
     * @return Returns the speedFactor
     */
    abstract public double speedFactor();

    /**
     * Returns a new speed by taking the old speed and
     * increasing(addition) it by amount relative to the speedFactor
     *
     * @param amount the amount which the speed should increase
     * @return returns the new total speed
     */
    protected double incrementSpeed(double amount) {
        return getCurrentSpeed() + speedFactor() * amount;
    }

    /**
     * Returns a new speed by taking the old speed and
     * decreasing(subtraction) it by amount relative to the speedFactor
     *
     * @param amount the amount which the speed should decrease
     * @return returns the new total speed
     */
    protected double decrementSpeed(double amount) {
        return getCurrentSpeed() - speedFactor() * amount;
    }

    /**
     * Increases the speed of the car
     * @param amount should be in the range [0,1] or exception is thrown
     */
    public void gas(double amount) {
        if (amount >= 0 && amount <= 1) {
            currentSpeed = Math.min(incrementSpeed(amount), enginePower);
        } else {
            throw new InvalidParameterException();
        }
    }

    /**
     * Decreases the speed of the car
     * @param amount should be in the range [0,1] or exception is thrown
     */
    public void brake(double amount) {
        if (amount >= 0 && amount <= 1) {
            currentSpeed = Math.max(decrementSpeed(amount), 0);
        } else {
            throw new InvalidParameterException();
        }
    }

    /**
     * Changes the position of the car with
     */
    public void move() {
        position[0] += currentSpeed * Math.cos(direction);
        position[1] += currentSpeed * Math.sin(direction);
    }

    /**
     * Changes the direction of the car
     */
    public void turnLeft() {
        direction += Math.PI/2;
    }

    /**
     * Changes the direction of the car
     */
    public void turnRight() {
        direction -= Math.PI/2;
    }
}

