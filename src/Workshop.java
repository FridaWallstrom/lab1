public class Workshop<T extends Car> extends Item{

    private Container<T> container;

    private double[] position;

    public Workshop(double[] position, int capacity, int range) {
        super(position);
        container = new Container<>(capacity);
    }

    public void load(T car) {
        container.load(car);
    }

    public T unload(int index) {
        return container.unload(index);
    }

    public int numberOfItems() {
        return container.numberOfItems();
    }
}
