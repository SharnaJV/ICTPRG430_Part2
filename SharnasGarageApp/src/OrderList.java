import java.util.ArrayList;
import java.util.List;

public class OrderList {

    /**
     * class to hold the orders
     */

    private List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public OrderList() {
        this.orders = new ArrayList<>();
    }

    // Method to add an order to the list
    public void addOrder(Order order) {
        orders.add(order);
    }

    // Method to display all orders in the list
    public void displayOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders to display.");
        } else {
            System.out.println("List of Orders:");
            for (Order order : orders) {
                System.out.println(order);
            }
        }
    }

}
