package com.kojidev.epamhw.unit7;

import java.util.*;

public class Reader {

    private final Map<String, ResourceBundle> bundles = new HashMap<>();

    public String getValue(String fileName, String key) {
        if (!bundles.containsKey(fileName)) {
            synchronized (bundles) {
                bundles.put(fileName, ResourceBundle.getBundle("unit7/" + fileName));
            }
        }

        return bundles.get(fileName).getString(key);
    }
}
