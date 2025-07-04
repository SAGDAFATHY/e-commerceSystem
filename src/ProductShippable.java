public class ProductShippable extends Product implements Shippable{

    private double weight;
    public ProductShippable(String name, double price, int quantity,double weight)
    {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}
