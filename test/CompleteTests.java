import org.junit.*;

import java.awt.*;
import java.lang.reflect.Array;
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
        assertArrayEquals(car.getPosition(), new double[]{10, 20}, 0.0);
    }
    @Test
    public void testSaabNrDoors(){
        assertEquals(saab.getNrDoors(),2, 0);
    }
    @Test
    public void testGetEnginePower(){
        assertEquals(volvo.getEnginePower(), 100, 0);
    }

    @Test
    public void testGetColor(){
        assertEquals(volvo.getColor(), Color.black);
    }

    @Test
    public void testSetColor(){
        volvo.setColor(Color.GREEN);
        assertEquals(volvo.getColor(), Color.GREEN);
    }

    @Test
    public void testStopEngineAndGetCurrentSpeed(){
        assertEquals(volvo.getCurrentSpeed(), 0, 0);
    }
    @Test
    public void testStartEngine(){
        volvo.startEngine();
        assertEquals(volvo.getCurrentSpeed(),0.1, 0);
    }

    @Test
    public void testSaabSpeedFactor(){
        saab.setTurboOff();
        assertEquals(saab.speedFactor(),1.25, 0);
    }

    @Test
    public void testSaabTurbo(){
        saab.setTurboOn();
        assertEquals(saab.speedFactor(), 1.625, 0);
    }

    @Test
    public void testVolvoSpeedFactor(){
        assertEquals(volvo.speedFactor(),1.25, 0);
    }

    @Test
    public void testVolvoGas(){
        volvo.gas(1);
        assertEquals(volvo.getCurrentSpeed(), 1.25, 0);
    }

    @Test
    public void testBrake(){
        volvo.brake(1);
        assertEquals(volvo.getCurrentSpeed(), 0, 0);
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
        assertEquals(volvo.direction,Math.PI/2, 0); // flippat
    }

    @Test
    public void testTurnRight(){
        volvo.turnRight();
        assertEquals(volvo.direction, -Math.PI/2,0);
    }

    @Test
    public void testMoveFar(){
        volvo.turnLeft();
        volvo.gas(1);
        volvo.move();
        assertArrayEquals(volvo.getPosition(), new double[]{0, 1.25}, 0.00001);
    }

}
