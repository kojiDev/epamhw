package com.kojidev.epamhw.unit4.bytestreams;

import sun.misc.IOUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class KeywordScanner {

    private final String path;

    private static final Pattern pattern = Pattern.compile("\\b" + String.join("|", new String[] {
            "abstract", "continue", "for", "new", "switch", "assert", "default", "goto", "package", "synchronized",
            "boolean", "do", "if", "private", "this", "break", "double", "implements", "protected", "throw", "byte",
            "else", "import", "public", "throws", "case", "enum", "instanceof", "return", "transient", "catch",
            "extends", "int", "short", "try", "char", "final", "interface", "static", "void", "class", "finally",
            "long", "strictfp", "volatile", "const", "float", "native", "super", "while"
    }) + "\\b", Pattern.MULTILINE);

    public KeywordScanner(String s) {
        path = s;
    }

    public Set<String> getKeyWords() throws IOException {
        return getKeyWordsAndCount().keySet();
    }

    private Map<String, Integer> getKeyWordsAndCount() throws IOException {

        StringBuilder sb = new StringBuilder();
        FileInputStream fs = new FileInputStream(path);
        int c;
        while ((c = fs.read()) != -1) {
            sb.append((char) c);
        }

        String input = sb.toString();
        Matcher matcher = pattern.matcher(input);

        HashMap<String, Integer> hm = new HashMap<>();

        while (matcher.find()) {
            String key = matcher.group();
            Integer value = hm.get(key);
            value = value == null ? 1 : value + 1;
            hm.put(key, value);
        }

        return hm;
    }

    public void dumpKeywords(String outputFile) throws IOException {

        Map<String, Integer> hm = getKeyWordsAndCount();

        try(FileOutputStream fo = new FileOutputStream(outputFile)) {
            fo.write(getTextRepresentation().getBytes());
        }
    }

    private String getTextRepresentation() throws IOException {
        return getKeyWordsAndCount().entrySet().stream()
                .map(e -> e.getKey() + "\t\t" + e.getValue())
                .collect(Collectors.joining("\n"));
    }
}
