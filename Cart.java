import java.util.List;
import java.util.ArrayList;

public class Cart {
    private List<OrderedProduct> products;
    private double totalPrice;
    private boolean isShipping = true;
    // This is for the customer is going to ship the product or not
    Stock stock;

    public Cart(boolean isShipping) {
        this.products = new ArrayList<>();
        this.totalPrice = 0.0;
        stock = Stock.getStock();
        this.isShipping = isShipping;
    }

    public void add(String productName, int quantity) {
        if (stock.editProduct(productName, quantity)) {
            Product product = stock.getProductByName(productName);
            if (product == null) {
                System.err.println("Product \'" + productName + "\' not found.");
                return;
            }
            OrderedProduct orderedProduct = new OrderedProduct(product, quantity);
            products.add(orderedProduct);
            totalPrice += product.getPrice() * quantity;
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

    private void printCartItems(java.util.function.BiFunction<OrderedProduct, Integer, String> valueProvider,
            String valueSuffix) {
        for (OrderedProduct product : products) {
            int itemQuantity = product.getQuantityOrdered();
            String item = itemQuantity + "x" + product.getName();
            String value = valueProvider.apply(product, itemQuantity) + valueSuffix;
            String padding = Utilities.calculatePadding(item, value);
            System.out.println(item + padding + value);
        }
    }

    public double printShippingDetails() {
        double totalWeight = 0.0;
        for (OrderedProduct product : products) {
            totalWeight += product.getWeight() * product.getQuantityOrdered();
        }
        printCartItems(
                (prod, qty) -> String.valueOf(prod.getWeight() * qty),
                "g");
        return totalWeight;
    }

    public void print() {
        printCartItems(
                (prod, qty) -> String.format("%.2f", prod.getPrice() * qty),
                "");
    }

    public boolean isAllItemsShippingAvailable() {
        for (OrderedProduct product : products) {
            if (!product.getProduct().isShippable()) {
                System.err.println("Shipping not available for the item \'" + product.getName() + "\' in the cart.");
                Utilities.continueSuccessfully = false;
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

    public boolean isShipping() {
        return isShipping;
    }
}
