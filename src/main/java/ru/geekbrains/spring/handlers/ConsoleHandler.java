package ru.geekbrains.spring.handlers;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

@Component
public class ConsoleHandler implements Handler {

    private final Scanner scanner;

    public ConsoleHandler() {
        this.scanner = new Scanner(System.in);
        System.out.println("Enter command");
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
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
