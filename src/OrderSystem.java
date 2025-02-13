
import java.util.ArrayList;
import java.util.HashMap;


public interface OrderSystem {


    public double DiscountedPrice(String itemName);

    public void addItemInCart(String itemName, Integer quantity);
    public String removeItemFromCart(String itemName);
    public double totalPrice(HashMap<String, Integer> items);
    public double totalDiscountedPrice(HashMap<String, Integer> items);

    public double purchase(HashMap<String, Integer> cart);


}
