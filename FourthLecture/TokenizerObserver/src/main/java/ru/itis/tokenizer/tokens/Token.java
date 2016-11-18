package ru.itis.tokenizer.tokens;

public abstract class Token {
    private int begin;
    private int end;
    private String text;

    public Token() {
    }

    public Token(int begin, int end, String text) {
        this.begin = begin;
        this.end = end;
        this.text = text;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Token token = (Token) o;

        if (begin != token.begin) return false;
        if (end != token.end) return false;
        return !(text != null ? !text.equals(token.text) : token.text != null);

    }

    @Override
    public int hashCode() {
        int result = begin;
        result = 31 * result + end;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        return result;
    }

    public String toString() {
        return this.text+" on position begin: "+begin+" , end: "+end;
    }
}
