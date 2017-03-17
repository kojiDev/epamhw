package com.kojidev.epamhw.unit5.filemanager;

import java.io.IOException;

@FunctionalInterface
public interface ActionFunction {
    void run(String arg) throws IOException;
}
