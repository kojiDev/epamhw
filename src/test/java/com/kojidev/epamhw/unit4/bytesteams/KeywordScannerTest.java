package com.kojidev.epamhw.unit4.bytesteams;

import com.kojidev.epamhw.unit4.bytestreams.KeywordScanner;
import junitx.framework.FileAssert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static junit.framework.Assert.assertEquals;

public class KeywordScannerTest {

    private KeywordScanner ks;

    private Set<String> expectedKeywords = new HashSet<>(Arrays.asList(new String[]{
            "implements", "private", "import", "const", "for", "do", "while", "float", "long", "default", "public",
            "protected", "assert", "else", "continue", "catch", "if", "class", "case", "new", "package", "static",
            "void", "break", "byte", "this", "volatile", "int", "instanceof", "boolean", "throw", "char", "final",
            "short", "try", "return"
    }));

    @Before
    public void init() {
        ks = new KeywordScanner("src/main/resources/Scanner.java");
    }

    @Test
    public void testGetKeywords() throws IOException {
        Set<String> keyWords = ks.getKeyWords();
        assertEquals(keyWords, expectedKeywords);
    }

    @Test
    public void testDumpKeywords() throws IOException {

        String path = "src/main/resources/unit4/keywords_output.txt";
        ks.dumpKeywords(path);

        FileAssert.assertEquals(
                new File(path),
                new File("src/main/resources/unit4/expected_keywords_output.txt")
        );
    }





}
