package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        View view = new View();
        controller.setView(view);
        view.setController(controller);
        controller.start();

//        try {
//            Files.write(Path.of("C:\\Users\\Emil_\\OneDrive\\Desktop\\text.txt"), List.of("hello", "world"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }
}
