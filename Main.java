import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Car saab = new Saab95(new double[] {1,0});
        Car volvo = new Volvo240(new double[] {10,20});
        saab.startEngine();
        saab.gas(10);
        saab.move();
        System.out.println(Arrays.toString(saab.getPosition()));
        saab.gas(3);
        saab.turnLeft();
        saab.move();
        System.out.println(Arrays.toString(saab.getPosition()));
    }
}
