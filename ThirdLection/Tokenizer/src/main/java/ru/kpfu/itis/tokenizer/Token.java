package ru.kpfu.itis.tokenizer;

public abstract class Token {
    protected int begin;
    protected int end;
    protected String text;

    public Token(int begin, char[] chars) {
        this.begin = begin;
        this.end = findEnd(begin, chars);
    }

    public int getBegin() {
        return begin;
    }

    public int getEnd() {
        return end;
    }

    public String getText() {
        return text;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public void setText(String text) {
        this.text = text;
    }

    protected abstract int findEnd(int begin, char[] chars);

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+" {" +
                "begin=" + begin +
                ", end=" + end +
                ", text='" + text + '\'' +
                '}';
    }
}
