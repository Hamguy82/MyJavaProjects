package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Controller {
    private View view;
    private File file = new File("C:\\");
    private File[] files;

    public void setView(View view) {
        this.view = view;
    }

    public void start() {
        view.create();
        setFile();
    }

    private void setFile() {
        files = file.listFiles();
        view.enabled(file.getParentFile() != null);
        view.setPathLabel(file.getPath());
        view.setFileList(
                Arrays.stream(files)
                        .map(f -> (f.isFile()? "F ": "D ") + f.getName())
                        .toArray(String[]::new));
    }

    public void handleOpenClick() {
        file = files[view.getSelectedIndex()];
        setFile();
    }

    public void handleBackButtonClick() {
        file = file.getParentFile();
        setFile();
    }

    public void handleSaveButtonClick() {
        try {
            Files.write(new File(file, "text.txt").toPath(), List.of("hello", "world"));
            setFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void handleReadButtonClick() {
        try {
            System.out.println(Files.readAllLines(files[view.getSelectedIndex()].toPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
