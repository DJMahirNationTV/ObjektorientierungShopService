package Order;

import Product.Product;
import java.util.List;

public record Order(String id, List<Product> products) {
}
