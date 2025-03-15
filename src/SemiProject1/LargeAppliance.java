public class LargeAppliance extends Product implements Promotion {
    public LargeAppliance(String name, double price, double weight) {
        super(name, price, weight);
    }

    @Override
    public int getDiscountAmount() {
        return 0;
    }
}
