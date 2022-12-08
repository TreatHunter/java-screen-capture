package com.treathunter;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    private ScreenCapture screenCapture;
    private Thread screenCaptureThread;
    private Thread updateImageThread;

    public ImagePanel() {
        this.setPreferredSize(new Dimension(1000, 500));
        this.setBorder(BorderFactory.createTitledBorder("Screen"));
        screenCapture = new ScreenCapture();
    }

    public void setFps(Integer fps) {
        screenCapture.setFPS(fps);
    }

    public void setScreenShotDimensions(Integer leftBoundX, Integer leftBoundY, Integer rightBoundX, Integer rightBoundY) {
        screenCapture.setScreenShotDimensions(leftBoundX, leftBoundY, rightBoundX, rightBoundY);
    }

    public void startScreenCapture() {
        screenCapture.setFPS(60);
        screenCapture.setScreenShotDimensions(0, 0, 1280, 720);
        screenCaptureThread = new Thread(screenCapture);
        screenCaptureThread.start();
        updateImageThread = new Thread(() -> {
            while (!Thread.interrupted()) {
                if (screenCapture.isUpdate()) {
                    repaint();
                }
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        updateImageThread.start();
    }

    public void stopScreenCapture() {
        screenCaptureThread.interrupt();
        screenCaptureThread.interrupt();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(screenCapture.getCurrentFrame().getScaledInstance(1280, 720, Image.SCALE_FAST), 25, 25, 975, 475, null);
    }
}
