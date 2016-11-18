package ru.itis.tokenizer.hendlers;

import ru.itis.tokenizer.observer.TokenHandler;
import ru.itis.tokenizer.tokens.Number;
import ru.itis.tokenizer.tokens.Token;


public class TokenHandlerNumbersImpl implements TokenHandler {
    public void handleToken(Token token) {
        // token instanceof Number.class
        if (token.getClass().getName().equals(Number.class.getName())) {
            System.out.println("from: " + " " + getName() + " I'm on number! " + token);
        }
    }

//    public void handleToken(Token token) {
//        // token instanceof Number.class
//        System.out.println("from: " + " " + getName() + " I'm on number! " + token);
//    }

    public String getName() {
        return "NumberHandler";
    }

    public Class<?> getWorkClass() {
        return Number.class;
    }

}
