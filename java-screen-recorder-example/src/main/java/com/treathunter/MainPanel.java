package com.treathunter;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    ImagePanel imagePn;
    ControlsPanel controlsPn;

    public MainPanel(){
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        initImagePanel();
        initControlsPanel();
        this.setPreferredSize(new Dimension(1280,720));
    }

    private void initImagePanel(){
        imagePn = new ImagePanel();
        this.add(imagePn);
    }

    private void initControlsPanel(){
        controlsPn = new ControlsPanel(imagePn);
        this.add(controlsPn);
    }
}
