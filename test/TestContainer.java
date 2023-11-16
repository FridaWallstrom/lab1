import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestContainer {
    public Container<Item> itemContainer;

    @Before
    public void init(){
        itemContainer = new Container<Item>(5);
    }


    @Test
    public void testNumberOfItems(){
        assertEquals(0,itemContainer.numberOfItems(),0 );
    }

    @Test
    public void testLoad() {
        Item items = new Item(new double[]{10,10});
        itemContainer.load(items);
        assertEquals(1, itemContainer.numberOfItems(),0);
    }

    @Test
    public void testUnload() {
        Item items = new Item(new double[]{10, 74583});
        itemContainer.load(items);
        Item a = itemContainer.unload(1);
        assertEquals(a, items);
    }

    @Test
    public void testUpdatePosition() {
        Item items = new Item(new double[]{10,10});
        itemContainer.load(items);
        itemContainer.updatePosition(new double[]{1, 1});
        Item a = itemContainer.unload(1);
        assertEquals(items.getPosition(), a.getPosition());
    }



}
