import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Container<T extends Item> {

    private ArrayList<T> containedItems;
    private int capacity;
    double[] position;

    int range;

    public Container(int capacity, double[] position, int range) {
        this.capacity = capacity;
        containedItems = new ArrayList<T>();
        this.position = position;
        this.range = range;
    }

    public void load(T item) {
        if (Point2D.distance(position[0], position[1], item.getPosition()[0], item.getPosition()[1]) <= range) {
            if (containedItems.size() < capacity) {
                containedItems.add(item);
                item.setPosition(position);
                return;
            }
        }
        System.out.println("Couldn't add car :(");
    }

    public T unload(int index) {
        T last = containedItems.get(index - 1);
        containedItems.remove(index - 1);
        return last;
    }

    public void updatePosition(double[] position) {
        for (T item : containedItems) {
            item.setPosition(position);
        }
        this.position = position;
    }

    public int numberOfItems() {
        return containedItems.size();
    }

}
