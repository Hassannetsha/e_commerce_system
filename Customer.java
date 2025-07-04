public class Customer {
    private String name;
    private String shippingAddress;
    private String phoneNumber;
    private double balance;
    private boolean isShipping;

    public Customer(String name, String ShippingAddress, String phoneNumber, double balance, boolean ship) {
        this.name = name;
        this.shippingAddress = ShippingAddress;
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

    public void addBalance(int amount) {
        this.balance += amount;
    }

    public boolean isShipping() {
        return isShipping;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", ShippingAddress='" + shippingAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }
}
