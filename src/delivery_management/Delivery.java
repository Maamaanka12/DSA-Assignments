package delivery_management;

abstract class Delivery {
    protected int distance;
    protected int weight;

    public Delivery() {
        distance = 0;
        weight = 0;
    }

    public Delivery(int distance, int weight) {
        this();
        this.distance = distance;
        this.weight = weight;
    }

    public abstract long calculateFee();
}
