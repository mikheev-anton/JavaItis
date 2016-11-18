package ru.itis.tokenizer.tokens;

public class Letter extends Token {

    private boolean isUpperFirst;

    public Letter() {
        super();
    }

    public Letter(int begin, int end, String text, boolean isUpperFirst) {
        super(begin, end, text);
        this.isUpperFirst = isUpperFirst;
    }
}
