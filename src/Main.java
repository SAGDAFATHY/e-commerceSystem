import java.time.LocalDate;

public class Main {
    public static void Checkout(Customer customer,Cart cart)
    {
        if (cart.getItemCartList().isEmpty()) {
            System.out.println("The Cart is empty.");
            return;
        }

        if(!cart.IsAllItemsAvailable())
            return;

        if (cart.getSubtotal() > customer.getBalance()) {
            System.out.println("Customer's balance is insucient");
            return;
        }

        ShippingService shippingService = new ShippingService(cart.getProductShippable());
        shippingService.ShipmentNotice();
        customer.decreaseBalance(cart.getSubtotal()+shippingService.getShipping());
        System.out.println("** Checkout receipt **");
        for (ItemCart item : cart.getItemCartList()) {

            System.out.printf("%dx %-12s %.1f\n", item.getQuantity(), item.getProduct().getName(), item.getProduct().getPrice()*item.getQuantity());
        }
        System.out.println("----------------------");
        System.out.printf("%-16s %.0f\n", "Subtotal", cart.getSubtotal());
        System.out.printf("%-16s %.0f\n", "Shipping", shippingService.getShipping());
        System.out.printf("%-16s %.0f\n", "Amount", cart.getSubtotal()+shippingService.getShipping());
    }
    public static void main(String[] args) {

        System.out.println("Example 1");

        Customer customer = new Customer("Sagda", 10000);

        ProductShippableWithExpireDate cheese = new ProductShippableWithExpireDate("Cheese", 100, 10, 200, LocalDate.of(2025, 8, 1));
        ProductShippable tv = new ProductShippable("TV", 1000, 2, 85);
        ProductWithExpireDate biscuits = new ProductWithExpireDate("Biscuits", 150, 5, LocalDate.of(2026, 8, 1));
        Product card = new Product("Card", 10, 100);
        Cart cart = new Cart();



        cart.add(cheese, 2);
        cart.add(tv, 1);
        cart.add(biscuits, 1);
        cart.add(card, 3);
        Checkout(customer, cart);
        System.out.println("--------------------------------------------");

        System.out.println("Example 2");

        Customer c2 = new Customer("Nada", 5000);
        Cart cart2 = new Cart();
        Checkout(c2, cart2);
        System.out.println("--------------------------------------------");

        System.out.println("Example 3");

        Customer c3 = new Customer("Ahmed", 5000);
        Cart cart3 = new Cart();
        cart3.add(new ProductWithExpireDate("Expired Biscuits", 100, 5, LocalDate.of(2023, 1, 1)), 1);
        Checkout(c3, cart3);
        System.out.println("--------------------------------------------");

        System.out.println("Example 4");

        Customer c4 = new Customer("Mona", 8000);
        Cart cart4 = new Cart();
        cart4.add(new ProductShippable("TV", 7000, 1, 7), 2);

        System.out.println("--------------------------------------------");

        System.out.println("Example 5");

        Customer c5 = new Customer("Youssef", 100);
        Cart cart5 = new Cart();
        cart5.add(new ProductShippable("TV", 10000, 5, 8.5), 1);
        Checkout(c5, cart5);
    }
}