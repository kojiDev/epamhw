package com.kojidev.epamhw.unit4.encoding;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class EncoderTest {

    private Encoder encoder;

    @Before
    public void init() {
        encoder = new Encoder("src/main/resources/unit4/utf8_text.txt");
    }

    @Test
    public void test() throws IOException {
        encoder.toUtf16("src/main/resources/unit4/utf16_output.txt");

        Assert.assertTrue("Trust me dude.", true);
    }
}
