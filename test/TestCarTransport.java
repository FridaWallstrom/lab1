import org.junit.*;

import static org.junit.Assert.assertEquals;

public class TestCarTransport {
    public CarTransport ct;
    @Before
    public void init(){
        ct = new CarTransport(new double[] {0,0}, 5);
    }
    @Test
    public void testSpeedFactor() {
        ct.raiseRamp();
        assertEquals(1.1, ct.speedFactor(), 0);
    }
    @Test
    public void testLoadIfPositionOutOfRange(){
        Saab95 car = new Saab95(new double[] {10, 10});
        ct.load(car);
        assertEquals(0, ct.numberOfItems(), 0);
    }

    @Test
    public void testUnloadIfPositionOutOfRange(){
        Saab95 car = new Saab95(new double[] {2, 1});
        ct.load(car);
        ct.unload();
        assertEquals(1, car.getPosition()[0], 0);
        assertEquals(0, car.getPosition()[1], 0);
    }
}
