package ru.geekbrains.spring.handlers;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleHandler implements Handler {

    private final Scanner scanner;

    public ConsoleHandler() {
        this.scanner = new Scanner(System.in);
        System.out.println("Enter command");
    }

    @Override
    public String command() {
        return scanner.next();
    }

    @Override
    public void close() {
        scanner.close();
    }
}
