package com.kojidev.epamhw.unit5.filemanager;

import java.io.IOException;

@FunctionalInterface
public interface ActionProcedure {
    void run() throws IOException;
}
