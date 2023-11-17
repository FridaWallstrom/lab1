import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestRamp {
    public Ramp ramp;
    @Before
    public void init(){
        ramp = new Ramp(0, 10);
    }

    @Test
    public void testGetAnglesGivesCorrectAngle(){
        assertEquals(0,ramp.getAngle(),0);
    }

    @Test
    public void testLowerWithAngle() {
        ramp.raise();
        ramp.lower(5);
        assertEquals(5, ramp.getAngle(), 0);
    }

    @Test
    public void testLowerWithoutAngle() {
        ramp.lower();
        assertEquals(0, ramp.getAngle(), 0);
    }

    @Test
    public void testRaiseWithoutAngle() {
        ramp.raise();
        assertEquals(10, ramp.getAngle(),0);

    }

    @Test
    public void testRaiseWithAngle() {
        ramp.raise(6);
        assertEquals(6,ramp.getAngle(),0);
    }

    @Test
    public void testRaiseWithAngleMAX() {
        ramp.raise(999);
        assertEquals(10,ramp.getAngle(),0);
    }

    @Test
    public void testRaiseWithAngleMIN() {
        ramp.raise(-999);
        assertEquals(0, ramp.getAngle(),0);
    }

    @Test
    public void testLowerWithAngleMIN() {
        ramp.raise();
        ramp.lower(999);
        assertEquals(0, ramp.getAngle(), 0);
    }

    @Test
    public void testLowerWithAngleMAX() {
        ramp.lower(-999);
        assertEquals(0, ramp.getAngle(), 0);
    }
}
