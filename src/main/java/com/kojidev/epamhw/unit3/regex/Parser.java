package com.kojidev.epamhw.unit3.regex;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Parser {

    public Parser(String s) {
        try {
            FileReader fr = new FileReader(s);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
