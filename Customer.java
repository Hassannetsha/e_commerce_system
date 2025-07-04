public class Customer {
    private String name;
    private String shippingAddress;
    private String phoneNumber;
    private double balance;


    public Customer(String name, String shippingAddress, String phoneNumber, double balance) {
        this.name = name;
        this.shippingAddress = shippingAddress;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
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


}
