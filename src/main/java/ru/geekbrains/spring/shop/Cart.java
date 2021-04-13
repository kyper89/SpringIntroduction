package ru.geekbrains.spring.shop;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import ru.geekbrains.spring.handlers.Handler;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {

    private ProductRepository repository;
    private Handler handler;
    private final List<Product> products = new ArrayList<>();

    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ProductRepository getRepository() {
        return this.repository;
    }

    public Handler getHandler() {
        return handler;
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
}
