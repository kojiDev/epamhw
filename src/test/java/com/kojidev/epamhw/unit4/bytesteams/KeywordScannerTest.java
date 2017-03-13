package com.kojidev.epamhw.unit4.bytesteams;

import org.junit.Before;
import org.junit.Test;
import java.util.Set;

public class KeywordScannerTest {

    KeywordScanner ks;

    @Before
    public void init() {
        ks = new KeywordScanner("Scanner.java");
    }

    @Test
    public void testGetKeywords() {
        Set<String> keyWords = ks.getKeyWords();

        //assert key words here
    }

    public void testDumpKeywords() {
        ks.dumpKeywords("output.txt");
        // assert here
    }





}
