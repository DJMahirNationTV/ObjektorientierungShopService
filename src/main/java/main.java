import Order.OrderMapRepo;
import Order.OrderRepo;
import Product.Product;
import Product.ProductRepo;
import Shop.ShopService;

import java.util.Scanner;

import java.util.*;

public class main {
    public static void main(String[] args) {
        // INIT
        Scanner input = new Scanner(System.in);
        // Code
        ProductRepo productRepo = new ProductRepo();
        productRepo.addProduct(new Product("1", "Bleistift", 29.99));
        productRepo.addProduct(new Product("2", "Hänchen", 10.99));
        productRepo.addProduct(new Product("3", "HP Laptop Intel I9 mit 16GB RAM", 139.99));

        OrderRepo orderRepo = new OrderMapRepo();

        ShopService shopService = new ShopService(productRepo, orderRepo);

        System.out.println("---Success purchase---");
        shopService.placeOrder("order-001", List.of("1", "2"));

        System.out.println("---Failed purchase---");
        shopService.placeOrder("order-002", List.of("1", "asuodh"));

        String write = input.nextLine();
        if (write == "get") {
            String get = orderRepo.getOrders().toString();
            System.out.println(get);
        }


    }
}
