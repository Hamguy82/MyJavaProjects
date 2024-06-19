package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class View {
    private Controller controller;
    private JList<String> fileList;
    private JLabel pathLabel;
    private JButton backButton;
    private JFrame frame;

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void create() {
        frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        pathLabel = new JLabel();
        pathLabel.setBounds(10, 10, 700, 30);
        frame.add(pathLabel);

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(670, 150, 100, 40);
        frame.add(saveButton);

        saveButton.addActionListener(e -> controller.handleSaveButtonClick());

        backButton = new JButton("Back");
        backButton.setBounds(670, 200, 100, 40);
        frame.add(backButton);

        backButton.addActionListener(e -> controller.handleBackButtonClick());

        JButton readButton = new JButton("Read");
        readButton.setBounds(670, 250, 100, 40);
        frame.add(readButton);

        readButton.addActionListener(e -> controller.handleReadButtonClick());

        fileList = new JList<>();
        JScrollPane scrollList = new JScrollPane(fileList);
        scrollList.setBounds(10, 50, 650, 500);
        frame.add(scrollList);
        fileList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getClickCount() >= 2) {
                    controller.handleOpenClick();
                }
            }
        });
        frame.setVisible(true);
    }

    public void setFileList(String[] strings) {
        fileList.setListData(strings);
    }

    public void setPathLabel(String path) {
        pathLabel.setText(path);
        frame.setTitle(path);
    }

    public int getSelectedIndex() {
        return fileList.getSelectedIndex();
    }

    public void enabled(boolean isEnabled) {
        backButton.setEnabled(isEnabled);
    }


}
