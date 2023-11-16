import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestScania {
    public Scania scania;
    @Before
    public void init(){
        scania = new Scania(new double[] {10,10});

    }


    @Test
    public void testRaiseRamp() {
        assertEquals(0, scania.ramp.getAngle(),0);
    }

    @Test
    public void testSpeedFactor() {
        assertEquals(0.5, scania.speedFactor(), 0);
    }

    @Test
    public void testSpeedFactorIsZero() {
        scania.raiseRamp(70);
        assertEquals(0, scania.speedFactor(), 0);
    }

    @Test
    public void testLowerRamp() {
        scania.raiseRamp(70);
        scania.lowerRamp(20);
        assertEquals(50, scania.ramp.getAngle(), 0);
    }

}
