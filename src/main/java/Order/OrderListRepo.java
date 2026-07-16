package Order;

import java.util.List;
import java.util.Optional;

public class OrderListRepo implements OrderRepo {
    private List<Order> orders;

    @Override
    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public void removeOrder(Order order) {
        orders.removeIf(o -> o.equals(order));
    }
    @Override
    public List<Order> getOrders() {
        return orders;
    }
    @Override
    public Optional<Order> getOrder(String id) {
        return orders.stream()
                .filter(o -> o.id().equals(id))
                .findFirst();
    }
}
