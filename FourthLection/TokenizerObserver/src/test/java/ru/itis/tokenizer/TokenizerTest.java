package ru.itis.tokenizer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TokenizerTest {

    private Tokenizer tokenizer;

    @Before
    public void setUp() throws Exception {
        tokenizer = new Tokenizer();
    }

    @Test
    public void testTokenize() throws Exception {
        tokenizer.tokenize(DataTokens.ALL_IN);
    }
}