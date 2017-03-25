package com.kojidev.epamhw.unit7;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ReaderTest {

    @Test
    public void test() {

        Reader reader = new Reader();

        List<Thread> list = new ArrayList<>();

        String[] fileNames = {"first", "second", "third"};
        String[] keys = {"foo", "bar", "far"};
        for (String fileName : fileNames) {
            for (String key : keys) {
                list.add(new Thread(() -> reader.getValue(fileName, key)));
            }
        }

        list.forEach(Thread::start);
    }
}
