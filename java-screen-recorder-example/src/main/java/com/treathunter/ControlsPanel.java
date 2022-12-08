package com.treathunter;

import javax.swing.*;
import java.awt.*;

public class ControlsPanel extends JPanel {
    private JButton captureButton;
    private ImagePanel imagePanel;
    private JLabel fpsLabel;
    private JSlider fpsSlider;
    private JLabel leftCornerXLabel;
    private JSlider leftCornerXSlider;
    private JLabel leftCornerYLabel;
    private JSlider leftCornerYSlider;
    private JLabel rightCornerXLabel;
    private JSlider rightCornerXSlider;
    private JLabel rightCornerYLabel;
    private JSlider rightCornerYSlider;


    public ControlsPanel(ImagePanel imagePanel) {
        this.imagePanel = imagePanel;
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setBorder(BorderFactory.createTitledBorder("Controls"));
        this.setPreferredSize(new Dimension(200, 500));
        initCaptureButton();
        initFPsSlider();
        initCoordsSliders();
    }

    private void initCaptureButton(){
        captureButton = new JButton("Start capturing");
        captureButton.addActionListener(el -> {
            if (captureButton.getText().equals("Start capturing")) {
                captureButton.setText("Stop capturing");
                imagePanel.startScreenCapture();
            } else {
                captureButton.setText("Start capturing");
                imagePanel.stopScreenCapture();
            }
        });
        this.add(captureButton);
    }

    private void initFPsSlider(){
        fpsLabel = new JLabel("Fps");
        this.add(fpsLabel);
        fpsSlider = new JSlider(JSlider.HORIZONTAL,1,140,60);
        fpsSlider.setMajorTickSpacing(10);
        fpsSlider.setMinorTickSpacing(1);
        fpsSlider.setPaintTicks(true);
        fpsSlider.addChangeListener(e -> {
            JSlider source = (JSlider)e.getSource();
            if (!source.getValueIsAdjusting()) {
                imagePanel.setFps(source.getValue());
            }
        });
        this.add(fpsSlider);
    }

    private void initCoordsSliders(){
        leftCornerXLabel = new JLabel("Left corner x");
        this.add(leftCornerXLabel);
        leftCornerXSlider = new JSlider(JSlider.HORIZONTAL,0,1500,0);
        leftCornerXSlider.setMajorTickSpacing(50);
        leftCornerXSlider.setMinorTickSpacing(5);
        leftCornerXSlider.setPaintTicks(true);
        leftCornerXSlider.addChangeListener(e -> {
            JSlider source = (JSlider)e.getSource();
            if (!source.getValueIsAdjusting()) {
                int leftCornerX = leftCornerXSlider.getValue();
                int leftCornerY = leftCornerYSlider.getValue();
                int rightCornerX = rightCornerXSlider.getValue();
                int rightCornerY = rightCornerYSlider.getValue();
                imagePanel.setScreenShotDimensions(leftCornerX,leftCornerY,rightCornerX,rightCornerY);
            }
        });
        this.add(leftCornerXSlider);

        leftCornerYLabel = new JLabel("Left corner y");
        this.add(leftCornerYLabel);
        leftCornerYSlider = new JSlider(JSlider.HORIZONTAL,0,1000,0);
        leftCornerYSlider.setMajorTickSpacing(50);
        leftCornerYSlider.setMinorTickSpacing(5);
        leftCornerYSlider.setPaintTicks(true);
        leftCornerYSlider.addChangeListener(e -> {
            JSlider source = (JSlider)e.getSource();
            if (!source.getValueIsAdjusting()) {
                int leftCornerX = leftCornerXSlider.getValue();
                int leftCornerY = leftCornerYSlider.getValue();
                int rightCornerX = rightCornerXSlider.getValue();
                int rightCornerY = rightCornerYSlider.getValue();
                imagePanel.setScreenShotDimensions(leftCornerX,leftCornerY,rightCornerX,rightCornerY);
            }
        });
        this.add(leftCornerYSlider);

        rightCornerXLabel = new JLabel("Right corner x");
        this.add(rightCornerXLabel);
        rightCornerXSlider = new JSlider(JSlider.HORIZONTAL,0,1500,1280);
        rightCornerXSlider.setMajorTickSpacing(50);
        rightCornerXSlider.setMinorTickSpacing(5);
        rightCornerXSlider.setPaintTicks(true);
        rightCornerXSlider.addChangeListener(e -> {
            JSlider source = (JSlider)e.getSource();
            if (!source.getValueIsAdjusting()) {
                int leftCornerX = leftCornerXSlider.getValue();
                int leftCornerY = leftCornerYSlider.getValue();
                int rightCornerX = rightCornerXSlider.getValue();
                int rightCornerY = rightCornerYSlider.getValue();
                imagePanel.setScreenShotDimensions(leftCornerX,leftCornerY,rightCornerX,rightCornerY);
            }
        });
        this.add(rightCornerXSlider);

        rightCornerYLabel = new JLabel("Right corner y");
        this.add(rightCornerYLabel);
        rightCornerYSlider = new JSlider(JSlider.HORIZONTAL,0,1000,720);
        rightCornerYSlider.setMajorTickSpacing(50);
        rightCornerYSlider.setMinorTickSpacing(5);
        rightCornerYSlider.setPaintTicks(true);
        rightCornerYSlider.addChangeListener(e -> {
            JSlider source = (JSlider)e.getSource();
            if (!source.getValueIsAdjusting()) {
                int leftCornerX = leftCornerXSlider.getValue();
                int leftCornerY = leftCornerYSlider.getValue();
                int rightCornerX = rightCornerXSlider.getValue();
                int rightCornerY = rightCornerYSlider.getValue();
                imagePanel.setScreenShotDimensions(leftCornerX,leftCornerY,rightCornerX,rightCornerY);
            }
        });
        this.add(rightCornerYSlider);
    }
}
