package ru.geekbrains.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.spring.config.AppConfig;
import ru.geekbrains.spring.shop.Cart;

public class App {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Cart cart = context.getBean("cart", Cart.class);
        while (true) {

            String command = cart.getHandler().command();
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
}
