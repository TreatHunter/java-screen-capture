package com.treathunter;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("screen capture test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        MainPanel mainPn = new MainPanel();
        frame.add(mainPn);
        frame.setVisible(true);
        frame.setLocation(50,50);
        frame.pack();

    }
}
