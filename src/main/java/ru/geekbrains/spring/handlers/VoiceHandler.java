package ru.geekbrains.spring.handlers;

import org.springframework.stereotype.Component;

@Component
public class VoiceHandler implements Handler{
    @Override
    public String command() {
        return "";
    }

    @Override
    public void close() throws Exception {

    }
}
