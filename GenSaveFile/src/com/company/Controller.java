package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Controller {
    private static final File FILE = new File("text.txt");

    public List<String> readFile() {
        try {
            return Files.readAllLines(FILE.toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveFile(List<String> someText) {
        try {
            Files.write(FILE.toPath(), someText);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void start() {
//        saveFile(IntStream.generate(() -> (int) (Math.random() * 100))
//                .limit(10)
//                .mapToObj(String::valueOf)
//                .toList());

//        saveFile(readFile().stream()
//                .mapToInt(Integer::valueOf)
//                .map(i -> i * 2)
//                .mapToObj(String::valueOf)
//                .toList());

//        System.out.println(readFile().stream()
//                .mapToInt(Integer::valueOf)
//                .average()
//                .orElse(-1));

//        saveFile(readFile().stream()
//                .mapToInt(Integer::parseInt)
//                .sorted()
//                .mapToObj(String::valueOf)
//                .toList());

//        int a = 4;
//        System.out.println("#".repeat(a));

//        saveFile(readFile().stream()
//                .mapToInt(Integer::parseInt)
//                .mapToObj("*"::repeat)
//                .toList());

//        saveFile(List.of(String.join(" ", readFile())));

        saveFile(readFile().stream()
                .map(s -> s.split(", "))
                .flatMap(Arrays::stream)
                .toList());

        saveFile(Arrays.stream(readFile().get(0).split(", "))
                .toList());
    }
}
