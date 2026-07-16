package Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepo {
    private List<Product> products;

    public ProductRepo() {
        this.products = new ArrayList<>();
    }
    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }

        this.products.add(product);
    }
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(this.products);
    }
}
