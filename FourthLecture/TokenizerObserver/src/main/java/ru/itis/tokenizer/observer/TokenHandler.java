package ru.itis.tokenizer.observer;


import ru.itis.tokenizer.tokens.Token;

public interface TokenHandler {
    void handleToken(Token token);
    String getName();
    Class<?> getWorkClass();
}
