package ru.geekbrains.spring.shop;

import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> products;

    public Product getProduct(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().get();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
