public class Ramp {
    private double minAngle;
    private double maxAngle;

    private double angle;

    public Ramp(double minAngle, double maxAngle) {
        this.minAngle = minAngle;
        this.maxAngle = maxAngle;
        this.angle = minAngle;
    }

    public Ramp() {
        minAngle = 0;
        maxAngle = 90;
        this.angle = minAngle;
    }

    public void lower(double angle) {
        if (this.angle - angle > minAngle) {
            this.angle -= angle;
        } else {
            this.angle = minAngle;
        }
    }

    public void lower() {
        angle = minAngle;
    }

    public void raise(double angle) {
        if (this.angle + angle < maxAngle) {
            this.angle += angle;
        } else {
            this.angle = maxAngle;
        }
    }

    public void raise() {
        angle = maxAngle;
    }

    public double getAngle() {
        return angle;
    }
}
