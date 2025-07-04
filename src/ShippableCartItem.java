class ShippableCartItem {
    Shippable product;
    int quantity;
    public ShippableCartItem(Shippable product,int quantity)
    {
        this.product =product;
        this.quantity =quantity;
    }

    public Shippable getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
}
