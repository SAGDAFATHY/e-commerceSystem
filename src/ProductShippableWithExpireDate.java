import java.time.LocalDate;

public class ProductShippableWithExpireDate extends Product implements Shippable , Expirable{
    private LocalDate expiryDate;
    private double weight;
    public ProductShippableWithExpireDate(String name, double price, int quantity, double weight, LocalDate expiryDate)
    {
        super(name, price, quantity);
        this.expiryDate=expiryDate;
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}