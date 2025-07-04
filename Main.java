import java.time.LocalDate;

public class Main {
    private static Stock stock;
    private static Cart cart;
    private static ShippingService shippingService;

    public static void print(String text, double printPrice) {
        String padding = Utilities.calculatePadding(text, String.format("%.2f", printPrice));
        System.out.println(text + padding + printPrice);
    }

    public static void checkout(Customer customer, Cart cart) {
        if (cart.getTotalPrice() == 0) {
            System.err.println("Cart is empty.");
            return;
        }
        if (!customer.checkBalance(cart.getTotalPrice())) {
            System.err.println("Insufficient balance.");
            return;
        }
        if (!cart.isAllItemsNotExpired()) {
            return;
        }
        boolean isShipping = customer.isShipping();
        if (isShipping) {
            shippingService = new ShippingService(cart, customer.getShippingAddress());
            shippingService.print();
        }
        System.out.println("** Checkout receipt **");
        cart.print();
        System.err.println("------------------------------");
        double printPrice;
        double totalPrice = cart.getTotalPrice();
        printPrice = totalPrice;
        String text = "Subtotal";
        print(text, printPrice);
        double shippingCost = 0.0;
        if (isShipping) {
            text = "Shipping cost";
            shippingCost = shippingService.getShippingCost();
            printPrice = shippingCost;
            print(text, printPrice);
        }
        text = "Total";
        printPrice = (totalPrice + (isShipping ? shippingCost : 0));
        print(text, printPrice);
        customer.addBalance(- cart.getTotalPrice());
        System.out.println("Customer current balance = " + customer.getBalance());

    }

    public static void main(String[] args) {
        stock = Stock.getStock();
        Product milk = new Product("milk", 20.0, 1000.0, 100, true, LocalDate.of(2025, 7, 3));
        Product cheese = new Product("cheese", 10.0, 1000.0, 100, true, LocalDate.of(2025, 7, 10));
        Product laptop = new Product("laptop", 10000.0, 2000.0, 5, true);
        Product tv = new Product("tv", 100000.0, 6000.0, 10, true);
        Product scratchCard = new Product("scratchCard", 5.0, 50, 20, false);
        stock.addProduct(milk);
        stock.addProduct(cheese);
        stock.addProduct(laptop);
        stock.addProduct(tv);
        stock.addProduct(scratchCard);
        cart = new Cart();
        Customer customer = new Customer("John Doe", "123 Main St", "123-456-7890", 100100.0, true);
        // cart.add("Milk", 2);
        cart.add("cheese", 2);
        cart.add("tv", 1);
        cart.add("scratchCard", 1);
        checkout(customer, cart);
    }
}