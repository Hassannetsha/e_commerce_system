public class Customer {
    private String name;
    private String shippingAddress;
    private String phoneNumber;
    private double balance;
    private boolean isShipping;

    public Customer(String name, String shippingAddress, String phoneNumber, double balance, boolean ship) {
        this.name = name;
        this.shippingAddress = shippingAddress;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.isShipping = ship;
    }

    public String getName() {
        return name;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getBalance() {
        return balance;
    }

    public boolean checkBalance(double price) {
        return balance >= price;
    }

    public void addBalance(double amount) {
        this.balance += amount;
    }

    public boolean isShipping() {
        return isShipping;
    }
}
