package ru.kpfu.itis.tokenizer;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Token[] tokenize = new NativeTokenizerImpl(10).tokenize("kgo0902;</,.,/?!k1l45&");
        for (int i = 0; i < tokenize.length; i++) {
            if (tokenize[i] != null)
                System.out.println(tokenize[i]);
        }
    }
}
