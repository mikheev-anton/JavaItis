package ru.itis.tokenizer;

import ru.itis.tokenizer.hendlers.*;
import ru.itis.tokenizer.observer.TokenizerObservable;


public class Program {
    public static void main(String[] args) {
        String text = "a1/ 125 hhjg 21 .,Antd12....";
        TokenizerObservable tokenizer = new Tokenizer();
        tokenizer.addTokenHandler(new TokenHandlerNumbersImpl());
//        tokenizer.addTokenHandler(new TokenHandlerStandardOutputImpl());
        tokenizer.addTokenHandler(new TokenHandlerLettersImpl());
        tokenizer.addTokenHandler(new TokenHandlerSeparatorImpl());
        tokenizer.addTokenHandler(new TokensCollectionHandler());

        tokenizer.tokenize(text);
    }


}
