public class Workshop extends Item{

    private Container<Car> container;

    private double[] position;

    public Workshop(double[] position, int capacity, int range) {
        super(position);
        container = new Container<>(capacity);
    }

    public void load(Car car) {
        container.load(car);
    }

    public Car unload(int index) {
        return container.unload(index);
    }

    public int numberOfItems() {
        return container.numberOfItems();
    }
}
