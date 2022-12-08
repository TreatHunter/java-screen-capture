package com.treathunter;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ScreenCapture implements Runnable {
    private Rectangle screenShotDimensions = new Rectangle(0, 0, 500, 500);
    private Integer timeDelay = 1000;
    private BufferedImage currentFrame;
    private Boolean isUpdate = false;

    private synchronized void setIsUpdate(Boolean isUpdate){
        this.isUpdate = isUpdate;
    }

    public ScreenCapture() {
        super();
        setBlankImage();
    }

    private void setBlankImage() {
        currentFrame = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = currentFrame.createGraphics();
        g.setBackground(new Color(0,0,0,0));
        g.clearRect(0, 0, 500, 500);
    }

    public void setScreenShotDimensions(Integer leftBoundX, Integer leftBoundY, Integer rightBoundX, Integer rightBoundY) {
        screenShotDimensions = new Rectangle(leftBoundX, leftBoundY, rightBoundX - leftBoundX, rightBoundY - leftBoundY);
    }

    public void setFPS(Integer fps) {
        timeDelay = 1000 / fps;
    }

    public BufferedImage getCurrentFrame() {
        setIsUpdate(false);
        return currentFrame;
    }

    public synchronized Boolean isUpdate(){
        Boolean updateValue = isUpdate;
        setIsUpdate(false);
        return updateValue;
    }

    @Override
    public void run() {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
            return;
        }
        while(!Thread.interrupted()){
            try {
                Thread.sleep(timeDelay);
            } catch (InterruptedException e) {
                setBlankImage();
                return;
            }
            currentFrame = robot.createScreenCapture(screenShotDimensions);
            setIsUpdate(true);
        }
        setBlankImage();
    }
}
