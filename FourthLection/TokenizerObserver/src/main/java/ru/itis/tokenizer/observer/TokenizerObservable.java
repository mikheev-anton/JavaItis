package ru.itis.tokenizer.observer;

import ru.itis.tokenizer.tokens.Token;

public interface TokenizerObservable {
    void addTokenHandler(TokenHandler handler);
    void removeHandlerByWorkClass(Class tokenClass);
    void notifyHandlers(Token token);
    void tokenize(String text);
}
