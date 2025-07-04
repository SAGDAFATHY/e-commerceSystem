public class ItemCart {
    Product product;
    Integer quantity;
    public ItemCart(Product product, Integer quantity)
    {
        this.product = product;
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }
}