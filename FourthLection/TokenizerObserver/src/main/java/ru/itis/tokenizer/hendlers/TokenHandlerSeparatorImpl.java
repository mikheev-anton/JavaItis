package ru.itis.tokenizer.hendlers;

import ru.itis.tokenizer.observer.TokenHandler;
import ru.itis.tokenizer.tokens.Separator;
import ru.itis.tokenizer.tokens.Token;

public class TokenHandlerSeparatorImpl implements TokenHandler {
    public void handleToken(Token token) {
        if (token.getClass().getName().equals(Separator.class.getName())) {
            System.out.println("from: " + " " + getName() + " I'm separator! " + token);
        }
    }

//    public void handleToken(Token token) {
//        System.out.println("from: " + " " + getName() + " I'm separator! " + token);
//    }

    public String getName() {
        return "SeparatorHandler";
    }

    public Class<?> getWorkClass() {
        return Separator.class;
    }
}
