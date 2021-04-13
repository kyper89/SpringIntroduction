package ru.geekbrains.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.geekbrains.spring.shop.Cart;
import ru.geekbrains.spring.shop.Product;
import ru.geekbrains.spring.shop.ProductRepository;
import ru.geekbrains.spring.handlers.ConsoleHandler;
import ru.geekbrains.spring.handlers.Handler;

@Configuration
public class AppConfig {

    @Bean(name = "productRepository")
    public ProductRepository productRepository() {
        ProductRepository productRepository = new ProductRepository();
        productRepository.setProducts(Product.generateProduct(5));
        return productRepository;
    }

    @Bean(name = "cart")
    public Cart cart(ProductRepository repository, Handler handler) {
        Cart cart = new Cart() ;
        cart.setRepository(repository);
        cart.setHandler(handler);
        return cart;
    }

    @Bean(name = "handler")
    public Handler handler() {
        return new ConsoleHandler();
    }
}
