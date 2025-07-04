import java.util.List;
import java.util.ArrayList;

public class Cart {
    private List<OrderedProduct> products;
    private double totalPrice;
    Stock stock;

    public Cart() {
        this.products = new ArrayList<>();
        this.totalPrice = 0.0;
        stock = Stock.getStock();
    }

    public void add(String productName, int quantity) {
        if (stock.editProduct(productName, quantity)) {
            Product product = stock.getProductByName(productName);
            OrderedProduct orderedProduct = new OrderedProduct(product, quantity);
            products.add(orderedProduct);
            totalPrice += product.getPrice();
        } else {
            System.err.println("Product out of stock.");
        }

    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<OrderedProduct> getProducts() {
        return new ArrayList<>(products);
    }

    public double shippingPrint() {
        double totalWeight = 0.0;
        for (OrderedProduct product : products) {
            int itemQuantity = product.getQuantityOrdered();
            double itemWeight = product.getWeight() * itemQuantity;
            totalWeight += itemWeight;
            String item = itemQuantity + "x" + product.getName();
            String weight = itemWeight + "g";
            String padding = Utilities.calculatePadding(item, weight);
            System.out.println(item + padding + weight);
        }
        return totalWeight;
    }

    public void print() {
        for (OrderedProduct product : products) {
            int itemQuantity = product.getQuantityOrdered();
            double itemPrice = product.getPrice() * itemQuantity;
            String item = itemQuantity + "x" + product.getName();
            String weight = String.format("%.2f", itemPrice);
            String padding = Utilities.calculatePadding(item, weight);
            System.out.println(item + padding + weight);
        }
    }

    public boolean isAllItemsShippingAvailable() {
        for (OrderedProduct product : products) {
            if (!product.getProduct().isShippable()) {
                System.err.println("Shipping not available for the item \'" + product.getName() + "\' in the cart.");
                return false;
            }
        }
        return true;
    }

    public boolean isAllItemsNotExpired() {
        for (OrderedProduct product : products) {
            if (product.isExpired()) {
                System.out.println("Item \'" + product.getName() + "\' is expired and cannot be shipped.");
                return false;
            }
        }
        return true;
    }
}
