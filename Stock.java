import java.util.ArrayList;
import java.util.List;

public class Stock {
    private static Stock stock;
    private List<Product> products;

    private Stock() {
        this.products = new ArrayList<>();
    }

    public static Stock getStock() {
        if (stock == null) {
            stock = new Stock();
        }
        return stock;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product getProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        System.out.println("Product not found.");
        return null;
    }

    public boolean editProduct(String productName, int count) {
        Product Product = getProductByName(productName);
        int index = products.indexOf(Product);
        if (index != -1) {
            Product product = products.get(index);
            if (product.isAvailable(count)) {
                product.edit(count);
                return true;
            }
        }
        System.out.println("Product out of stock.");
        return false;
    }
}
