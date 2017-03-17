package com.kojidev.epamhw.unit5.filemanager;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    private Path currentPath = Paths.get(System.getProperty("user.home"), "Desktop");

    public List<Path> list() throws IOException {
        final List<Path> list = new ArrayList<>();
        Files.newDirectoryStream(currentPath).forEach(list::add);
        return list;
    }

    public String get(String fileName) throws IOException {
        return new String(Files.readAllBytes(getPath(fileName)));
    }

    private Path getPath(String fileName) {
        return fileName.startsWith("/") ? Paths.get(fileName) : Paths.get(currentPath.toString(), fileName);
    }

    public void edit(String fileName, String content) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(getPath(fileName), StandardCharsets.UTF_8)) {
            writer.write(content, 0, content.length());
        }
    }

    public void delete(String fileName) throws IOException {
        Files.delete(getPath(fileName));
    }

    public void cd(String path) {
        currentPath = getPath(path);
    }
}
