package com.kojidev.epamhw.unit5.filemanager;

import java.io.IOException;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class FileManagerConsole {

    private static final String ANSI_RESET = "\u001B[0m";
    //private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";

    private static final String SEPARATOR = new String(new char[20]).replace("\0", "=");

    private static final FileManager manager = new FileManager();
    private static final Scanner scanner = new Scanner(System.in);
    private static final ResourceBundle bundle = ResourceBundle.getBundle("filemanager", Locale.ENGLISH);

    enum ActionType {
        LIST(() -> {
            print(SEPARATOR);
            print(manager.list());
            print(SEPARATOR);
        }),
        SHOW((s) -> print(manager.get(s))),
        EDIT((s) -> {
            manager.edit(s, ask("ask.text"));
            print("saved");
        }),
        DELETE((s) -> {
            manager.delete(s);
            print("deleted");
        }),
        CD((s) -> {
            manager.cd(s);
            print(manager.list());
        }),
        HELP(() -> {
            print("title");
            print("help");
            for (ActionType type : ActionType.values()) {
                String command = type.toString().toLowerCase();
                print("command." + command, command);
            }
        }),
        EXIT(() -> {
            print("bye");
            System.exit(0);
        });

        private ActionProcedure prod;
        private ActionFunction func;

        ActionType(ActionFunction func) {
            this.func = func;
        }

        ActionType(ActionProcedure prod) {
            this.prod = prod;
        }

        void run() throws IOException {
            prod.run();
        }

        void run(String arg) throws IOException {
            func.run(arg);
        }
    }

    public static void main(String[] args) {

        try {
            ActionType.HELP.run();
            while (true) {
                execute();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void execute() throws IOException {

        final String[] input = ask("run").split(" ");

        final ActionType action = ActionType.valueOf(input[0].toUpperCase());

        if (input.length > 1) {
            action.run(input[1]);
            return;
        }

        action.run();
    }

    private static String ask(String question) {
        print(question);
        return scanner.nextLine();
    }

    private static void print(List<Path> list) {
        ListIterator<Path> it = list.listIterator();
        while (it.hasNext()) {
            Path path = it.next();
            print(path.getFileName().toString());
        }
    }

    private static void error(String message) {
        print(ANSI_RED + message + ANSI_RESET);
    }

    private static void print(String message, Object... params) {
        print(String.format(getString(message), params));
    }

    private static void print(String message) {
        message = getString(message);
        System.out.println(message);
    }

    private static String getString(String string) {
        if (bundle.containsKey(string)) {
            string = bundle.getString(string);
        }

        return string;
    }

}
