import java.util.Arrays;

public class Cart {
    private Product[] products;

    public Cart(Product[] products) {
        this.products = products;
    }

    public double calculateTotalWeight() {
        return Arrays.stream(products)
                .mapToDouble(Product::getWeight)
                .sum();
    }

    private double calculateTotalDiscountedPrice() {
        return Arrays.stream(products)
                .mapToDouble(product -> {
                    if (product instanceof Promotion) {
                        return product.getPrice() - ((Promotion) product).getDiscountAmount();
                    }
                    return product.getPrice();
                })
                .sum();
    }

    public int calculateDeliveryCharge() {
        double totalWeight = calculateTotalWeight();
        double totalDiscountedPrice = calculateTotalDiscountedPrice();

        // Calculate base delivery charge based on weight
        int baseDeliveryCharge;
        if (totalWeight < 3) {
            baseDeliveryCharge = 1000;
        } else if (totalWeight < 10) {
            baseDeliveryCharge = 5000;
        } else {
            baseDeliveryCharge = 10000;
        }

        // Apply discount based on total discounted price
        if (totalDiscountedPrice >= 100000) {
            return  0; // Free delivery
        } else if (totalDiscountedPrice >= 30000) {
            return baseDeliveryCharge - 1000; // 1,000 discount
        } else {
            return baseDeliveryCharge;
        }
    }
}
