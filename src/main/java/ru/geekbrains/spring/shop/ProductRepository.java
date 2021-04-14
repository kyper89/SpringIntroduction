package ru.geekbrains.spring.shop;

import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ProductRepository {

    private final List<Product> products;

    // блок инициализации
    {
        products = Product.generateProduct(5);
    }

    public Product getProduct(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().get();
    }

    public List<Product> getProducts() {
        return products;
    }



}
