package com.kojidev.epamhw.unit4.encoding;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Encoder {

    private String path;

    public Encoder(String path) {
        this.path = path;
    }

    public void toUtf16(String outputFilePath) throws IOException {
        try(BufferedWriter bw =
                    new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFilePath), StandardCharsets.UTF_16));
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)))) {

            char[] buffer = new char[16384];
            int read;
            while ((read = br.read(buffer)) != -1) {
                bw.write(buffer, 0, read);
            }
        }
    }
}
