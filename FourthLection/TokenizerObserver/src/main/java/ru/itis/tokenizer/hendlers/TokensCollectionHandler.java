package ru.itis.tokenizer.hendlers;


import ru.itis.tokenizer.observer.TokenHandler;
import ru.itis.tokenizer.tokens.Token;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TokensCollectionHandler implements TokenHandler {
    private List<Token> tokens;

    public TokensCollectionHandler() {
        tokens = new ArrayList<Token>();
    }

    public void handleToken(Token token) {
        tokens.add(token);
    }

    public Token[] getToken(){
        return this.tokens.toArray(new Token[tokens.size()]);
    }

    public String getName() {
        return "Collection";
    }

    public Class<?> getWorkClass() {
        return Token.class;
    }
}
