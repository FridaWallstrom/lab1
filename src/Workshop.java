public class Workshop<T extends Car> extends Item{

    private Container<T> container;

    private double[] position;

    public Workshop(double[] position, int capacity, int range) {
        super(position);
        this.range = range;
        container = new Container<>(capacity, position, range);
    }

    /**
     * Loads a car into container
     * @param car
     */
    public void load(T car) {
        container.load(car);
    }

    /**
     * unloads a car from a certain index
     * @return
     */
    public T unload(int index) {
        return container.unload(index);
    }

    public int numberOfItems() {
        return container.numberOfItems();
    }
}
