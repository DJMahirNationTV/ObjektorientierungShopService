package Order;

import Product.Product;
import java.time.ZonedDateTime;
import java.util.List;
import lombok.With;


@With
public record Order(
        String id,
        List<Product> products,
        OrderStatus status,
        ZonedDateTime orderTimestamp
) {}
