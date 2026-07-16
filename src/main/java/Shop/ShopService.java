package Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import Order.Order;
import Order.OrderRepo;
import Product.Product;
import Product.ProductRepo;

public class ShopService {
    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;

    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public void placeOrder(Order order) {
        List<Product> products = new ArrayList<>();

        for (String productId : productIds) {
            Optional<Product> productOpt = productRepo.getProducts(productId);
            if (productOpt.isPresent()) {
                products.add(productOpt.get());
            } else {
                System.out.println(productId + " does not exist");
                return;
            }
        }

        Order newOrder = new Order(order.id(), products);
        orderRepo.addOrder(newOrder);
        System.out.println("Order has been added");
    }
}
