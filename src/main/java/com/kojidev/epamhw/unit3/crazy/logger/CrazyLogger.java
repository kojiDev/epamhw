package com.kojidev.epamhw.unit3.crazy.logger;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class CrazyLogger {

    private StringBuilder storage;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY : HH-mm");

    private static final String ls = System.getProperty("line.separator");

    CrazyLogger() {
        this(1000);
    }

    CrazyLogger(int capacity) {
        storage = new StringBuilder(capacity);
    }

    void log(String message) {
        storage.append(LocalDateTime.now().format(formatter)).append(" - ").append(message).append(ls);
    }

    BufferedReader find(String needle) {
        String str = storage.toString();
        String pattern = "^(.*" + Pattern.quote(needle) + ".*)$";
        Pattern regex = Pattern.compile(pattern, Pattern.MULTILINE | Pattern.CASE_INSENSITIVE);
        Matcher matcher = regex.matcher(str);

        StringBuilder sb = new StringBuilder();

        while (matcher.find()) {
            sb.append(matcher.group()).append(ls);
        }

        StringReader sr = new StringReader(sb.toString());
        return new BufferedReader(sr);
    }


}
