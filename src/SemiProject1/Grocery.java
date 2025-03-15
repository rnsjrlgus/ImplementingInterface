public class Grocery extends Product implements Promotion {
    public Grocery(String name, double price, double weight) {
        super(name, price, weight);
    }

    @Override
    public int getDiscountAmount() {
        return 2000;
    }
}
