package com.kojidev.epamhw.unit7;

import junit.framework.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class AccountantTest {

    @Test
    public void test() throws IOException, SAXException, ParserConfigurationException {
        Accountant accountant = new Accountant("src/main/resources/unit7/data.xml");
        Account ivan = new Account("ivan");
        Account pavel = new Account("pavel");
        accountant.checkout(ivan, pavel);

        Assert.assertEquals(ivan.getCash(), 1200);
        Assert.assertEquals(pavel.getCash(), 1300);
    }

}
