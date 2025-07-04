public class ShippingService {
    Cart cart;
    private String shippingAddress;
    private double shippingCost = 30.0;

    public ShippingService(Cart cart, String shippingAddress) {
        this.cart = cart;
        this.shippingAddress = shippingAddress;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public double getShippingCost() {
        return shippingCost;
    }

    public boolean isShippingAvailable() {
        return cart.isAllItemsShippingAvailable();
    }

    public void print() {
        if (isShippingAvailable()) {
            System.out.println("** Shipment notice **");
            double totalWeight = cart.shippingPrint();
            String text = "Total package weight";
            String weight = String.format("%.2f", totalWeight / 1000) + "kg";
            String padding = Utilities.calculatePadding(text, weight);
            System.out.println(text + padding + weight);
        }
    }

}
