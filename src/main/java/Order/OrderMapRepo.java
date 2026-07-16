package Order;

import java.util.*;

public class OrderMapRepo implements OrderRepo {
    private final Map<String, Order> orders = new HashMap<>();

    @Override
    public void addOrder(Order order) {
        if (order != null) {
            orders.put(order.id(), order);
        }
    }

    @Override
    public void removeOrder(String id) {
        orders.remove(id);
    }

    @Override
    public Optional<Order> getOrder(String id) {
        return Optional.ofNullable(orders.get(id));
    }

    @Override
    public List<Order> getOrders() {
        return new ArrayList<>(orders.values());
    }
}
