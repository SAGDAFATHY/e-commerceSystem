import java.util.List;

public class ShippingService {
    private List<ShippableCartItem> shippableCartItem;
    private double shipping = 30;

    public ShippingService(List<ShippableCartItem> shippableCartItem)
    {
        this.shippableCartItem = shippableCartItem;
    }
    public void ShipmentNotice() {
        double totalWeight = 0;

        System.out.println("** Shipment notice **");

        for (ShippableCartItem item : shippableCartItem) {
            double itemWeight = item.getProduct().getWeight() * item.getQuantity();

            System.out.printf("%dx %-12s %.1fg\n", item.getQuantity(), item.getProduct().getName(), itemWeight);
            totalWeight += itemWeight;
        }

        System.out.printf("Total package weight %.1fkg\n", totalWeight/1000);
    }
    public double getShipping() {
        return shipping;
    }

}
