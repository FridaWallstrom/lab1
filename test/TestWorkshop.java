import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertFalse;

public class TestWorkshop {

    public Workshop<Car> cw;
    public Workshop<Volvo240> vw;

    @Before
    public void init(){
        cw= new Workshop<>(new double[]{0,0}, 5, 5);
        vw = new Workshop<>(new double[]{10,10},5,5);
    }
    @Test
    public void TestCarsDontStack(){
        cw.load(new Saab95(new double[] {0,1}));
        cw.load(new Volvo240(new double[] {0,3}));

        Car volvo = cw.unload(cw.numberOfItems());
        Car saab = cw.unload(cw.numberOfItems());

        assertFalse(Arrays.equals(volvo.getPosition(), saab.getPosition()));
    }
}
