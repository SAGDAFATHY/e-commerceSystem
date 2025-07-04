import java.time.LocalDate;

public class ProductWithExpireDate extends Product implements Expirable {
    private LocalDate expiryDate;

    public ProductWithExpireDate(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}