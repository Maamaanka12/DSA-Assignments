package delivery_management;

class ExpressDelivery extends Delivery {

    public ExpressDelivery(int distance, int weight) {
        super(distance, weight);
    }

    @Override
    public long calculateFee() {
        return 25L + 4L * distance + 2L * weight;
    }
}