import java.time.LocalDate;

public class Product {

    private String name;
    private double price;
    private double weight;
    private int quantity;
    private boolean isShippable;
    private LocalDate expireDate = null;

    public Product(String name, double price, double weight, int quantity, boolean isShippable) {
        this(name, price, weight, quantity, isShippable, null);
    }

    public Product(String name, double price, double weight, int quantity, boolean isShippable, LocalDate expireDate) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
        this.isShippable = isShippable;
        this.expireDate = expireDate;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void edit(int count) {
        quantity -= count;
    }

    public boolean isAvailable(int count) {
        return quantity >= count;
    }

    public boolean isShippable() {
        return isShippable;
    }

    public LocalDate getExpireDate() {
        return expireDate;
    }

    public boolean isExpired() {
        return expireDate != null && LocalDate.now().isAfter(expireDate);
    }

}