package com.kojidev.epamhw.unit4.streams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.regex.Matcher;

public class KeywordScanner extends BaseKeywordScanner {

    public KeywordScanner(String s) {
        super(s);
    }

    protected Map<String, Integer> getKeyWordsAndCount() throws IOException {

        StringJoiner sj = new StringJoiner("\n");
        Files.lines(Paths.get(path), StandardCharsets.UTF_8).forEach(sj::add);

        Matcher matcher = pattern.matcher(sj.toString());

        return getMap(matcher);
    }

    public void dumpKeywords(String outputFile) throws IOException {

        Map<String, Integer> hm = getKeyWordsAndCount();

        try(FileOutputStream fo = new FileOutputStream(outputFile)) {
            fo.write(getTextRepresentation().getBytes());
        }
    }
}
