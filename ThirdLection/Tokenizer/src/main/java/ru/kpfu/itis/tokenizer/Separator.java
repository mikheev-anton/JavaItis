package ru.kpfu.itis.tokenizer;

public class Separator extends Token {

    public static final String PATTERN = ",.?!:;-_\n \t";

    public Separator(int begin, char[] chars) {
        super(begin, chars);
    }

    @Override
    protected int findEnd(int begin, char[] chars) {
        return begin;
    }

//        @Override
//    public int findEnd(int begin, char[] chars) {
//        int end = 0;
//        for (int i = begin; i < chars.length; i++) {
//            char aChar = chars[i];
//            if (Separator.PATTERN.contains(String.valueOf(aChar))) {
//                end = i;
//            }
//            else break;
//        }
//        return end;
//    }
}
