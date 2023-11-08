import org.junit.*;

import java.awt.*;
import java.lang.reflect.Array;
import java.security.InvalidParameterException;
import java.util.Arrays;

import static org.junit.Assert.*;

public class CompleteTests{
    Saab95 saab;
    Volvo240 volvo;
    @Before
    public void init(){
        saab = new Saab95(new double[] {0,0});
        volvo = new Volvo240(new double[] {0,0});
    }

    @Test
    public void testPosition(){
        Saab95 car = new Saab95(new double[] {10,20});
        assertArrayEquals(new double[]{10, 20}, car.getPosition() , 0.0);
    }

    @Test
    public void testSaabNrDoors(){
        assertEquals(2, saab.getNrDoors(), 0);
    }

    @Test
    public void testGetEnginePower(){
        assertEquals(100, volvo.getEnginePower(), 0);
    }

    @Test
    public void testGetColor(){
        assertEquals(Color.black, volvo.getColor());
    }

    @Test
    public void testSetColor(){
        volvo.setColor(Color.GREEN);
        assertEquals(Color.GREEN, volvo.getColor());
    }

    @Test
    public void testStopEngineAndGetCurrentSpeed(){
        assertEquals(0, volvo.getCurrentSpeed(), 0);
    }

    @Test
    public void testStartEngine(){
        volvo.startEngine();
        assertEquals(0.1,volvo.getCurrentSpeed(), 0);
    }

    @Test
    public void testSaabSpeedFactor(){
        saab.setTurboOff();
        assertEquals(1.25, saab.speedFactor(), 0);
    }

    @Test
    public void testSaabTurbo(){
        saab.setTurboOn();
        assertEquals(1.625, saab.speedFactor(), 0);
    }

    @Test
    public void testVolvoSpeedFactor(){
        assertEquals(1.25, volvo.speedFactor(), 0);
    }

    @Test
    public void testVolvoGas(){
        volvo.gas(1);
        assertEquals(1.25, volvo.getCurrentSpeed(),0);
    }

    @Test
    public void testBrake(){
        volvo.brake(1);
        assertEquals(0, volvo.getCurrentSpeed(),  0);
    }

    @Test
    public void testMove() {
        double[] pos = volvo.getPosition();
        volvo.move();
        double[] new_pos = volvo.getPosition();
        assertEquals(pos, new_pos);
    }

    @Test
    public void testTurnLeft(){
        volvo.turnLeft();
        assertEquals(Math.PI/2, volvo.direction, 0);
    }

    @Test
    public void testTurnRight(){
        volvo.turnRight();
        assertEquals(-Math.PI/2, volvo.direction,0);
    }

    @Test
    public void testMoveFar(){
        volvo.turnLeft();
        volvo.gas(1);
        volvo.move();
        assertArrayEquals(new double[]{0, 1.25}, volvo.getPosition(), 0.00001);
    }

    @Test
    public void testGasAmountCantBeAbove1(){
        boolean thrown = false;
        try {
            volvo.gas(2);
        } catch (InvalidParameterException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }
    @Test
    public void testGasAmountCantBeBelow0(){
        boolean thrown = false;
        try {
            volvo.gas(-0.0001);
        } catch (InvalidParameterException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }
    @Test
    public void testBrakeAmountCantBeAbove1(){
        boolean thrown = false;
        try {
            volvo.brake(2);
        } catch (InvalidParameterException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }
    @Test
    public void testBrakeAmountCantBeBelow0(){
        boolean thrown = false;
        try {
            volvo.brake(-0.1);
        } catch (InvalidParameterException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void testCurrentSpeedCantExceedEnginePower(){
        volvo.incrementSpeed(10000);
        assertTrue(volvo.getCurrentSpeed() <= volvo.enginePower);
    }

    @Test
    public void testCurrentSpeedCantFallBelow0(){
        volvo.decrementSpeed(100000);
        assertTrue(volvo.getCurrentSpeed() >= 0);
    }


}
