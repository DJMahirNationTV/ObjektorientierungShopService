package Shop;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Order.Order;
import Order.OrderRepo;
import Order.OrderStatus;
import Product.Product;
import Product.ProductRepo;

public class ShopService {
    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;

    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public void placeOrder(String orderId, List<String> productIds) {
        List<Product> products = new ArrayList<>();

        for (String productId : productIds) {
            Optional<Product> productOpt = productRepo.getProductById(productId);
            Product product = productRepo.getProductById(productId)
                    .orElseThrow(() -> new IllegalArgumentException("Product with ID " + productId + " does not exist."));
            products.add(product);


            if (productOpt.isPresent()) {
                products.add(productOpt.get());
            } else {
                System.out.println(productId + " does not exist");
                return;
            }
        }

        Order newOrder = new Order(orderId, products, OrderStatus.IN_PROGRESS, ZonedDateTime.now());
        orderRepo.addOrder(newOrder);
        System.out.println("Order has been added");
    }
    public List<Order> getOrdersByStatus(OrderStatus status) {
        return orderRepo.getOrders()
                .stream()
                .filter(order -> order.status() == status)
                .toList();
    }
    public Order updateOrder(String orderId, OrderStatus newStatus) {
        Order existingOrder = orderRepo.getOrder(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order with ID " + orderId + " does not exist."));

        Order updatedOrder = existingOrder.withStatus(newStatus);

        orderRepo.addOrder(updatedOrder);
        return updatedOrder;
    }


}
