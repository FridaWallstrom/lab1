import java.awt.*;
import java.util.ArrayList;

public class CarTransport extends Car {

    private Ramp ramp;
    private ArrayList<Car> transportedCars;

    private int sizeofRamp;

    public CarTransport(double[] position, int sizeofRamp) {
        super(position, 2, Color.decode("#da09cd"), 55, "Cartransportcar");
        ramp = new Ramp();
        transportedCars = new ArrayList<Car>();
        this.sizeofRamp = sizeofRamp;
    }

    public void move() {
        super.move();
        for (Car car : transportedCars) {
            car.setPosition(this.getPosition());
        }
    }

    public double speedFactor(){
        if (this.ramp.getAngle() != 0 ) {
            return enginePower * 0.02;
        }
        return 0;
    }

    public void raiseRamp() {
        if(getCurrentSpeed() == 0) {
            ramp.raise();
        }
    }

    public void lowerRamp() {
        ramp.lower();
    }

    public void loadCar(Car car) {
        if (car.getModelName() != "Cartransportcar" && transportedCars.size() < sizeofRamp) {
            if () {// kan bara lastas om nära
                transportedCars.add(car);
            } else {
                System.out.println("Car too far away");
            }
        } else {
            System.out.println("Couldn't add car :(");
        }
    }

    public Car unloadCar() { // positionen av bilen - nära biltransporten
        Car last = transportedCars.get(transportedCars.size() - 1);
        transportedCars.remove(transportedCars.size() - 1);
        return last;
    }

}
