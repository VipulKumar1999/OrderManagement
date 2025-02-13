import java.util.Map;
import java.util.Scanner;

public class OrderImpl implements Order{

    public OrderImpl(){

        OrderSystemImpl orderSystemImpl = new OrderSystemImpl();

        for (Map.Entry<String, Integer> entry : orderSystemImpl.menuChart.entrySet()) {
            System.out.println("Item: " + entry.getKey() + ", Price: " + entry.getValue());
        }


        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the count of items you want to buy: ");
        int numberOfItems = sc.nextInt();
        System.out.println();
        for (int i = 0; i < numberOfItems; i++) {
            System.out.print("Enter the item name: ");
            String item = sc.next();
            System.out.print("Enter the quantity: ");
            Integer quantity = sc.nextInt();
            System.out.println();
            orderSystemImpl.addItemInCart(item,quantity);
        }
        System.out.print("Want to remove any item : ");

        String response = sc.next();
        System.out.println();
        if (response.equalsIgnoreCase("Yes")) {
            System.out.print("Count of items to remove : ");
            Integer count = sc.nextInt();
            System.out.println();
            for (int j = 0; j < count; j++) {
                System.out.print("Enter the item name: ");
                String removedItem = sc.next();
                orderSystemImpl.removeItemFromCart(removedItem);
                System.out.println();
            }
            System.out.print("Actual amount: ");
            System.out.println(orderSystemImpl.totalPrice(orderSystemImpl.cart));
            System.out.print("Discounted amount to pay: ");
            System.out.println(orderSystemImpl.purchase(orderSystemImpl.cart));

        } else {
            System.out.print("Actual amount: ");
            System.out.println(orderSystemImpl.totalPrice(orderSystemImpl.cart));
            System.out.print("Discounted amount to pay: ");
            System.out.println(orderSystemImpl.purchase(orderSystemImpl.cart));

        }
    }



    @Override
    public void showMenuCard() {


    }

}
