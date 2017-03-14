package com.kojidev.epamhw.unit4.streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;

public class KeywordScannerChar extends BaseKeywordScanner {

    public KeywordScannerChar(String s) {
        super(s);
    }

    protected Map<String, Integer> getKeyWordsAndCount() throws IOException {

        StringBuilder sb = new StringBuilder();
        FileInputStream fs = new FileInputStream(path);
        int c;
        while ((c = fs.read()) != -1) {
            sb.append((char) c);
        }

        String input = sb.toString();
        Matcher matcher = pattern.matcher(input);

        HashMap<String, Integer> hm = new HashMap<>();

        return getMap(matcher);
    }

    public void dumpKeywords(String outputFile) throws IOException {

        Map<String, Integer> hm = getKeyWordsAndCount();

        try(FileOutputStream fo = new FileOutputStream(outputFile)) {
            fo.write(getTextRepresentation().getBytes());
        }
    }
}
