public class OrderedProduct {
    private Product product;
    private int quantity;

    public OrderedProduct(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantityOrdered() {
        return quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    public double getPrice() {
        return product.getPrice();
    }

    public double getWeight() {
        return product.getWeight();
    }

    public String getName() {
        return product.getName();
    }

    public boolean isShippable() {
        return product.isShippable();
    }

    public boolean isExpired() {
        return product.isExpired();
    }

    @Override
    public String toString() {
        return "OrderedProduct{" +
                "product=" + product +
                ", quantity=" + quantity +
                ", totalPrice=" + getTotalPrice() +
                '}';
    }
}
