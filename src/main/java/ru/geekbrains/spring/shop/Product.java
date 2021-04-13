package ru.geekbrains.spring.shop;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Product {

    private final int id;
    private final String title;
    private final BigDecimal cost;

    public Product(int id, String title, BigDecimal cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    public static List<Product> generateProduct(int count) {

        List<Product> products = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            products.add(new Product(i, "Product_" + i, new BigDecimal(String.format("%d.%d", i, i))));
        }

        return products;
    }

    @Override
    public String toString() {
        return title + ", cost=" + cost;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getCost() {
        return cost;
    }
}
