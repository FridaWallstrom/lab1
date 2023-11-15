import java.util.ArrayList;

public class Container<T extends Item> {

    private ArrayList<T> containedItems;
    private int capacity;

    public Container(int capacity) {
        this.capacity = capacity;
        containedItems = new ArrayList<T>();
    }

    public void load(T item) {
        if (containedItems.size() < capacity) {
            containedItems.add(item);
        } else {
            System.out.println("Couldn't add car :(");
        }
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
    }

    public int numberOfItems() {
        return containedItems.size();
    }

}
