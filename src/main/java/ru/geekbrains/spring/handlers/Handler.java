package ru.geekbrains.spring.handlers;

import org.springframework.stereotype.Component;

@Component
public interface Handler extends AutoCloseable{
    String command();
}

