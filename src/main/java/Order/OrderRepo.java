package Order;
import java.util.List;
import java.util.Optional;

public interface OrderRepo {
    void addOrder(Order order);
    void removeOrder(String id);
    Optional<Order> getOrder(String id);

    List<Order> getOrders();
}
