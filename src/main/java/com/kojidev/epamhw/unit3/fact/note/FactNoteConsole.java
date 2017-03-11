package com.kojidev.epamhw.unit3.fact.note;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;

public class FactNoteConsole {

    private static ResourceBundle bundle = ResourceBundle.getBundle("fact");
    private static FactNote factNote = new FactNote();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Locale locale = null;

        if (args.length > 0) {
            locale = getLocaleByLanguageCode(args[0]);
        }

        if (locale == null) {
            System.out.println(bundle.getString("choose.language"));
            for (Locale l : factNote.getLocales()) {
                System.out.println(String.format("[%s] - %s", l.getLanguage(), l.getDisplayLanguage()));
            }
            locale = askLocale(br);
        }

        factNote.setLocale(locale);

        String fact = null;

        if (args.length > 1) {
            fact = factNote.showFactForQuestionNumber(Integer.valueOf(args[1]));
        }

        if (fact == null) {
            String[] qs = factNote.getQuestions();
            for (int i = 0; i < qs.length; i++) {
                System.out.println(String.format("[%d] - %s", i, qs[i]));
            }
            fact = askFact(br);
        }

        System.out.println(fact);

    }

    private static String askFact(BufferedReader br) throws IOException {
        return factNote.showFactForQuestionNumber(Integer.valueOf(br.readLine()));
    }

    private static Locale getLocaleByLanguageCode(String name) {
        for (Locale locale : factNote.getLocales()) {
            if (locale.getLanguage().equals(name)) {
                return locale;
            }
        }

        return null;
    }

    private static Locale askLocale(BufferedReader br) {
        while (true) {
            try {
                Locale locale = getLocaleByLanguageCode(br.readLine());
                if (locale != null) {
                    return locale;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
