import java.awt.*;

abstract public class Car implements Movable{
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    protected double[] position = new double[2];
    protected double direction;

    public Car(double[] position){
        this.position = position;
    }

    public double[] getPosition(){
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

    protected void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    abstract public double speedFactor();

    protected double incrementSpeed(double amount){
        return getCurrentSpeed() + speedFactor() * amount;
    }


    protected double decrementSpeed(double amount){
        return getCurrentSpeed() - speedFactor() * amount;
    }

    public void gas(double amount) {
        currentSpeed = Math.min(incrementSpeed(amount), enginePower);
    }

    public void brake(double amount) {
        currentSpeed = Math.max(decrementSpeed(amount), 0);
    }
    public void move(){
        position[0] += currentSpeed * Math.cos(direction);
        position[1] += currentSpeed * Math.sin(direction);
    }
    public void turnLeft(){
        direction += Math.PI/2;
    }
    public void turnRight(){
        direction -= Math.PI/2;
    }
}

