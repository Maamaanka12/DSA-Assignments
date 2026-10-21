
class RegularDelivery extends Delivery {

    public RegularDelivery(int distance, int weight) {
        super(distance, weight);
    }

    @Override
    public long calculateFee() {
        return 10L + 2L * distance + weight;
    }
}
