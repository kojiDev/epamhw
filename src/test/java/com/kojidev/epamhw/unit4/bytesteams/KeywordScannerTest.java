package com.kojidev.epamhw.unit4.bytesteams;

import com.kojidev.epamhw.unit4.bytestreams.KeywordScanner;
import junit.framework.Assert;
import junitx.framework.FileAssert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertEquals;

public class KeywordScannerTest {

    private KeywordScanner ks;

    private Set<String> expectedKeywords = new HashSet<>(Arrays.asList(new String[]{
            "import",
            "if"
    }));

    @Before
    public void init() {
        ks = new KeywordScanner("Scanner.java");
    }

    @Test
    public void testGetKeywords() {
        Set<String> keyWords = ks.getKeyWords();
        assertEquals(keyWords, expectedKeywords);
    }

    public void testDumpKeywords() {
        File file = ks.dumpKeywords("output.txt");
        FileAssert.assertEquals(file, new File("expected_output.txt"));
    }





}
