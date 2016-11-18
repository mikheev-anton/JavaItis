package ru.kpfu.itis.generic;

import ru.kpfu.itis.tokenizer.Number;

public class Main {
    public static void main(String[] args) {
        Q<X,Y,Z> xyz = new Q<X, Y, Z>(new X(),new Y(),new Z());
        System.out.println(xyz.allCalc());
    }
}
