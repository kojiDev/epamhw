package com.kojidev.epamhw.unit3.fact.note;

import java.util.*;

public class FactNote {

    private Locale[] locales = new Locale[] {
            Locale.ENGLISH,
            new Locale("ru", "RU"),
    };

    private Locale locale = locales[0];

    private ResourceBundle bundle = ResourceBundle.getBundle("fact");

    public Locale[] getLocales() {
        return locales;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String[] getQuestions() {
        return getValuesByPrefix("question");
    }

    public String showFactForQuestionNumber(int num) {
        String[] a = getFacts();
        return getFacts()[num];
    }

    private String[] getFacts() {
        return getValuesByPrefix("answer");
    }

    private String[] getValuesByPrefix(String prefix) {
        return Collections.list(bundle.getKeys()).stream()
                .filter(key -> key.indexOf(prefix) == 0)
                .sorted(Comparator.comparingInt(i -> Integer.parseInt(i.replaceAll("[\\D]", ""))))
                .map(key -> bundle.getString(key)).toArray(String[]::new);
    }
}