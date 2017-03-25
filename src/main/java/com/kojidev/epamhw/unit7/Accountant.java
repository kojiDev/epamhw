package com.kojidev.epamhw.unit7;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Accountant {

    private Document data;

    public Accountant(String fileName) throws ParserConfigurationException, IOException, SAXException {
        data = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(fileName));
    }


    public void checkout(Account first, Account second) {
        first.setCash(getInitialCashFor(first));
        second.setCash(getInitialCashFor(second));

        Map<String, Account> accounts = new HashMap<>(2);
        accounts.put(first.getName(), first);
        accounts.put(second.getName(), second);

        NodeList transactions = data.getDocumentElement().getElementsByTagName("transaction");
        for (int i = 0; i < transactions.getLength(); i++) {
            Element tr = (Element)transactions.item(i);

            if (accounts.containsKey(tr.getAttribute("from")) &&
                    accounts.containsKey(tr.getAttribute("to"))) {
                Account from = accounts.get(tr.getAttribute("from"));
                Account to = accounts.get(tr.getAttribute("to"));

                Thread t = new Thread(() -> from.withdraw(Integer.valueOf(tr.getAttribute("amount"))));
                Thread t1 = new Thread(() -> to.deposite(Integer.valueOf(tr.getAttribute("amount"))));

                t.start();
                t1.start();
            }
        }
    }

    private int getInitialCashFor(Account account) {
        NodeList users = data.getDocumentElement().getElementsByTagName("user");
        for (int i = 0; i < users.getLength(); i++) {
            Element user = (Element)users.item(i);
            if (user.getAttribute("name").equals(account.getName())) {
                return Integer.valueOf(user.getAttribute("cash"));
            }
        }

        return 0;
    }

}
