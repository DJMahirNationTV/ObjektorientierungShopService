package Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OrderListRepo implements OrderRepo {
    private final List<Order> orders = new ArrayList<>();

    @Override
    public void addOrder(Order order) {
        if (order != null) {
            orders.add(order);
        }
    }

    @Override
    public void removeOrder(String id) {
        orders.removeIf(o -> o.id().equals(id));
    }
    @Override
    public List<Order> getOrders() {
        return new ArrayList<>(orders);
    }
    @Override
    public Optional<Order> getOrder(String id) {
        return orders.stream()
                .filter(o -> o.id().equals(id))
                .findFirst();
    }
}
