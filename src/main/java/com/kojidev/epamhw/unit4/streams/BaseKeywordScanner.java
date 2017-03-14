package com.kojidev.epamhw.unit4.streams;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

abstract public class BaseKeywordScanner {

    protected final String path;

    protected static final Pattern pattern = Pattern.compile("\\b" + String.join("|", new String[] {
            "abstract", "continue", "for", "new", "switch", "assert", "default", "goto", "package", "synchronized",
            "boolean", "do", "if", "private", "this", "break", "double", "implements", "protected", "throw", "byte",
            "else", "import", "public", "throws", "case", "enum", "instanceof", "return", "transient", "catch",
            "extends", "int", "short", "try", "char", "final", "interface", "static", "void", "class", "finally",
            "long", "strictfp", "volatile", "const", "float", "native", "super", "while"
    }) + "\\b", Pattern.MULTILINE);

    public BaseKeywordScanner(String s) {
        path = s;
    }

    public Set<String> getKeyWords() throws IOException {
        return getKeyWordsAndCount().keySet();
    }

    abstract protected Map<String, Integer> getKeyWordsAndCount() throws IOException;

    abstract public void dumpKeywords(String outputFile) throws IOException;

    protected String getTextRepresentation() throws IOException {
        return getKeyWordsAndCount().entrySet().stream()
                .map(e -> e.getKey() + "\t\t" + e.getValue())
                .collect(Collectors.joining("\n"));
    }

    protected Map<String, Integer> getMap(Matcher matcher) {
        HashMap<String, Integer> hm = new HashMap<>();

        while (matcher.find()) {
            String key = matcher.group();
            Integer value = hm.get(key);
            value = value == null ? 1 : value + 1;
            hm.put(key, value);
        }

        return hm;
    }
}
