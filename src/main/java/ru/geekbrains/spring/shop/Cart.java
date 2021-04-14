package ru.geekbrains.spring.shop;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {

    private final ProductRepository repository;
    private final List<Product> products = new ArrayList<>();

    public Cart(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductRepository getRepository() {
        return this.repository;
    }

    public void addProduct(int id) {
        products.add(repository.getProduct(id));
        System.out.println("Product added");
    }

    public void deleteProduct(int id) {
        products.remove(repository.getProduct(id));
        System.out.println("Product delete");
    }

    public void showProduct(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count && i < products.size(); i++) {
            sb.append(products.get(i)).append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    @Lookup
    public Cart getNewCart() {
        return null;
    }
}
