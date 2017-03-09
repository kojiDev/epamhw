package com.kojidev.epamhw.unit3.fact.note;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class FactNoteConsole {

    private ResourceBundle bundle = ResourceBundle.getBundle("interface");
    private FactNote factNote = new FactNote();

    public FactNoteConsole(String[] args) {

        if (args.length > 0) {
            String localeCode = args[0];
        }

        Locale locale = getLocaleByLanguageCode(locale);

        if (locale == null) {
            ask("choose.locale", l -> factNote.setLocale(l));
        }


    }

    private void ask(String s) {
        System.out.println(s);
    }

    private void ask(String s, Consumer<Locale> o) {
        while (true) {
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                Locale locale = getLocaleByLanguageCode(br.readLine());
                if (locale != null) {
                    o.accept(locale);
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        FactNoteConsole console = new FactNoteConsole(args);

    }

    private Locale getLocaleByLanguageCode(String name) {
        for (Locale locale : factNote.getLocales()) {
            if (locale.getLanguage().equals(name)) {
                return locale;
            }
        }

        return null;
    }
}
