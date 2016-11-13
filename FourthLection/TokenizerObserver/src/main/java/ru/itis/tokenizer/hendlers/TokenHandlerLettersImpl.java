package ru.itis.tokenizer.hendlers;

import ru.itis.tokenizer.observer.TokenHandler;
import ru.itis.tokenizer.tokens.Letter;
import ru.itis.tokenizer.tokens.Separator;
import ru.itis.tokenizer.tokens.Token;

public class TokenHandlerLettersImpl implements TokenHandler{

    public void handleToken(Token token) {
        if (token.getClass().getName().equals(Letter.class.getName())) {
            System.out.println("from: " + " " + getName() + " I'm word! " + token);
        }
    }

//    public void handleToken(Token token) {
//        System.out.println("from: " + " " + getName() + " I'm word! " + token);
//    }

    public String getName() {
        return "LettersHandler";
    }

    public Class<?> getWorkClass() {
        return Letter.class;
    }
}
