package com.kojidev.epamhw.unit3.fact.note;

import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

public class FactNoteTest {

    private FactNote fn;

    @Before
    public void setup() {
        fn = new FactNote();
    }

    @Test
    public void testFactNoteClass() {

        Locale[] locales = fn.getLocales();

        fn.setLocale(locales[0]);

        String[] questions = fn.getQuestions();
        assertFalse("Facts array should not be empty", questions.length == 0);

        String fact = fn.showFactForQuestionNumber(2);
        assertEquals(fact, "Hydrogen");
    }
}
