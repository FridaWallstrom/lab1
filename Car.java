import java.awt.*;

abstract public class Car implements Movable{
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    protected double[] position = new double[2];
    protected double direction = 0;
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

    abstract protected void incrementSpeed(double amount);

    abstract protected void decrementSpeed(double amount);

    // TODO fix this method according to lab pm
    public void gas(double amount) {
        incrementSpeed(amount);
    }

    // TODO fix this method according to lab pm
    public void brake(double amount) {
        decrementSpeed(amount);
    }
    public void move(){
        position[0] += currentSpeed * Math.cos(direction);
        position[1] += currentSpeed * Math.sin(direction);
    }
    public void turnLeft(){
        direction += Math.PI/8;

    }
    public void turnRight(){
        direction -= Math.PI/8;
    }
}

