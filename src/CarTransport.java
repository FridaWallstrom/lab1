import java.awt.*;
import java.awt.geom.Point2D;

public class CarTransport extends Car {

    private Ramp ramp;
    private Container<Car> transportedCars;
    private int range = 5;


    public CarTransport(double[] position, int sizeofRamp) {
        super(position, 2, Color.decode("#da09cd"), 55, "Cartransportcar");
        ramp = new Ramp();
        transportedCars = new ArrayList<Car>();
        this.sizeofRamp = sizeofRamp;
    }

    public void move() {
        super.move();
        transportedCars.updatePosition(this.getPosition());
    }

    public double speedFactor() {
        if (this.ramp.getAngle() != 0) {
            return enginePower * 0.02;
        }
        return 0;
    }

    public void raiseRamp() {
        if (getCurrentSpeed() == 0) {
            ramp.raise();
        }
    }

    public void lowerRamp() {
        ramp.lower();
    }

    public void loadCar(Car car) {
        if (car.getModelName() != "Cartransportcar" && transportedCars.size() < sizeofRamp) {
            if (Point2D.distance(this.getPosition()[0], this.getPosition()[1], car.getPosition()[0], car.getPosition()[1]) <= 5) {
                transportedCars.add(car);
            } else {
                System.out.println("Car too far away to load");
            }
        } else {
            System.out.println("Couldn't add car :(");
        }
    }

    public Car unload() {
        if (ramp.getAngle() == 0) {
            int index = transportedCars.numberOfItems();
            double[] unloadPosition = {this.getPosition()[0] + index, this.getPosition()[1]};
            Car last = transportedCars.unload(index);
            last.setPosition(unloadPosition);
            return last;
        }
        System.out.println("Can't unload car, ramp is not lowered");
        return null;
    }

}
