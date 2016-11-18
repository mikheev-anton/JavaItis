package ru.kpfu.itis.tokenizer;

public class NativeTokenizerImpl implements Tokenizer {

    private String text;

    private Token[] tokens;
    
    private int index;

    private static final float RATE_CAPACITY = 1.5f;

    public NativeTokenizerImpl(int capacity) {
        this.tokens = new Token[capacity];
        this.index = 0;
    }

    public Token[] tokenize(String text) {
        this.text = text;
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            Token token = null;
            if (Separator.PATTERN.contains(String.valueOf(aChar))) {
                token = new Separator(i, chars);
            } else if (aChar >= '0' && aChar <= '9') {
                token = new Number(i, chars);
            } else if (aChar >= 'A' && aChar <= 'Z' || aChar >= 'a' && aChar <= 'z' || aChar >= 'А' && aChar <= 'я') {
                token = new Word(i, chars);
            }
            else continue;

            i = token.getEnd();
            token.setText(text.substring(token.begin, token.end+1));
            addToken(token);
            index++;
        }

        return this.tokens;
    }
    
    private void addToken(Token token){
        if (index < tokens.length) 
            tokens[index] = token;
        else {
            extendArray();
            addToken(token);
        }
    }

    private void extendArray() {
        Token[] fullArray = this.tokens;
        Token[] newArrayToken = new Token[(int)(fullArray.length * RATE_CAPACITY)];
        for (int i = 0; i < fullArray.length; i++) {
            newArrayToken[i] = fullArray[i];
        }
        this.tokens = newArrayToken;
    }
}
