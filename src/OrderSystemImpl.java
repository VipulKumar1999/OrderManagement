import java.util.HashMap;
import java.util.Map;

public class OrderSystemImpl implements OrderSystem {



    HashMap<String, Integer> cart = new HashMap<>();
    HashMap<String, Integer> menuChart = new HashMap<>();

    OrderSystemImpl(){

        menuChart.put("toffee",5);
        menuChart.put("biscuit",10);
        menuChart.put("Boost",120);
        menuChart.put("Chocolate", 15);
        menuChart.put("Soap",20);
        menuChart.put("oil",80);

    }
    @Override
    public double DiscountedPrice(String itemName) {
        double afterDiscountPrice;
        Integer  orderPrice = menuChart.get(itemName);


        if(orderPrice<=10){

            afterDiscountPrice= orderPrice - ((orderPrice * 10.0) / 100);

        }
        else if (orderPrice>10 && orderPrice<=20){
            afterDiscountPrice= orderPrice - ((orderPrice * 20.0) / 100);
        }

        else{
            afterDiscountPrice= orderPrice - ((orderPrice * 30.0) / 100);
        }
        return afterDiscountPrice;


    }

    @Override
    public void addItemInCart(String itemName, Integer quantity) {

        cart.put(itemName, quantity);

    }

    @Override
    public String removeItemFromCart(String itemName) {

        if(cart.containsKey(itemName)){
                cart.remove(itemName);
            }
        else{
            return "item not found in cart ! : ";
        }
        return "item removed from cart : "+ itemName;
    }
    double finalPrice=0.0;
    double actualPrice=0.0;
    public double totalPrice(HashMap<String, Integer> items) {



        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            String itemName = entry.getKey();
            double quantity = entry.getValue();
            actualPrice = actualPrice + quantity*menuChart.get(itemName);
        }
        return actualPrice;

    }

    @Override
    public double totalDiscountedPrice(HashMap<String, Integer> items) {



        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            String itemName = entry.getKey();
            double quantity = entry.getValue();
            double dp = DiscountedPrice(itemName);
            finalPrice = finalPrice + quantity*dp;
        }
        return finalPrice;

    }

    @Override
    public double purchase(HashMap<String, Integer> cart) {

        return totalDiscountedPrice(cart);
    }


}
