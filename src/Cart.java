import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<ItemCart> itemCartList = new ArrayList<>();
    private List<ShippableCartItem> shippableList = new ArrayList<>();
    private double subtotal=0;


    public void add(Product product,Integer quantity)
    {
        if (quantity <= 0)
            System.out.println("Quantity must be greater than zero.");
        else if (quantity <= product.getQuantity()) {
            if (product instanceof Shippable) {
                    shippableList.add(new ShippableCartItem((Shippable)product,quantity));
            }
            subtotal+=(product.getPrice()*quantity);
            itemCartList.add(new ItemCart(product, quantity));
        }
        else
            System.out.println("Not enough stock for product: " + product.getName());
    }

    public List<ShippableCartItem> getProductShippable()
    {
        return shippableList;
    }

    public boolean IsAllItemsAvailable()
    {
        for (ItemCart item : itemCartList) {
            if (item.product.getQuantity() < item.getQuantity())
            {
                System.out.println("Not enough stock for product: " + item.getProduct().getName());
                System.out.println("Only " + item.getProduct().getQuantity() + " in stock.");
                return false;
            }
            if (item.getProduct() instanceof Expirable) {
                Expirable expirable = (Expirable) item.product;
                if(expirable.isExpired()) {
                    System.out.println("Product "+item.getProduct().getName()+" is Expired");
                    return false;
                }
            }
        }
        return true;
    }

    public List<ItemCart> getItemCartList()
    {
        return itemCartList;
    }

    public double getSubtotal(){
        return subtotal;
    }

}
