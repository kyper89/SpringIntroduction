package ru.geekbrains.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import ru.geekbrains.spring.config.AppConfig;
import ru.geekbrains.spring.handlers.ConsoleHandler;
import ru.geekbrains.spring.handlers.Handler;
import ru.geekbrains.spring.shop.Cart;

import javax.annotation.PostConstruct;

@Component
public class App {

    private final Cart cart;
    private final Handler handler;

    @Autowired //нужна если несколько конструкторов
    public App(Cart cart, ConsoleHandler handler) {
        this.cart = cart;
        this.handler = handler;
    }

    @PostConstruct
    public void start() {

        while (true) {

            String command = handler.command();
            String[] commandArray = command.split("_", 2);
            if (commandArray.length < 2) {
                System.out.println("Incorrect command");
                continue;
            }

            int parameter = Integer.parseInt(commandArray[1]);
            switch (commandArray[0]) {
                case "put" -> cart.addProduct(parameter);
                case "delete" -> cart.deleteProduct(parameter);
                case "show" -> cart.showProduct(parameter);
                default -> System.out.println("Incorrect command");
            }
        }
    }

    public static void main(String[] args) {

        new AnnotationConfigApplicationContext(AppConfig.class);

    }
}
