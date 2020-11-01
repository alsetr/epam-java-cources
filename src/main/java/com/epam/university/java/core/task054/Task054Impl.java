package com.epam.university.java.core.task054;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Task054Impl implements Task054 {

    @Override
    public BufferedImage grayscaleFilter(String inputFilePath, String outputFilePath) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(inputFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert image != null;
        int height = image.getHeight();
        int width = image.getWidth();
        int pixel;
        BufferedImage outputImage = new BufferedImage(width, height, 1);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixel = image.getRGB(j, i);
                int a = (pixel >> 24) & 0xff;
                int r = (pixel >> 16) & 0xff;
                int g = (pixel >> 8) & 0xff;
                int b = pixel & 0xff;
                int avg = (r + g + b) / 3;
                r = g = b = avg;
                pixel = (a << 24) | (r << 16) | (g << 8) | b;
                outputImage.setRGB(j, i, pixel);
            }
        }
        try {
            File f = new File(outputFilePath);
            ImageIO.write(outputImage, "jpg", f);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outputImage;
    }

    @Override
    public BufferedImage sepiaFilter(String inputFilePath, String outputFilePath) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(inputFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert image != null;
        int height = image.getHeight();
        int width = image.getWidth();
        int pixel;
        BufferedImage outputImage = new BufferedImage(width, height, 1);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixel = image.getRGB(j, i);
                int r = (pixel >> 16) & 0xff;
                int g = (pixel >> 8) & 0xff;
                int b = pixel & 0xff;
                int r1 = ((int) (0.393 * r + 0.769 * g + 0.189 * b));
                int g1 = ((int) (0.349 * r + 0.686 * g + 0.168 * b));
                int b1 = ((int) (0.272 * r + 0.534 * g + 0.131 * b));
                if (r1 > 255) {
                    r1 = 255;
                }
                if (g1 > 255) {
                    g1 = 255;
                }
                if (b1 > 255) {
                    b1 = 255;
                }
                int a = (pixel >> 24) & 0xff;
                pixel = (a << 24) | (r1 << 16) | (g1 << 8) | b1;
                outputImage.setRGB(j, i, pixel);
            }
        }
        try {
            File f = new File(outputFilePath);
            ImageIO.write(outputImage, "jpg", f);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outputImage;
    }

    @Override
    public BufferedImage reflectFilter(String inputFilePath, String outputFilePath) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(inputFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert image != null;
        int height = image.getHeight();
        int width = image.getWidth();
        int pixel;
        BufferedImage outputImage = new BufferedImage(width, height, 1);
        int half;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixel = image.getRGB(j, i);
                outputImage.setRGB(width - j - 1, i, pixel);
            }
        }
        try {
            File f = new File(outputFilePath);
            ImageIO.write(outputImage, "jpg", f);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return outputImage;
    }


    @Override
    public BufferedImage originalImage(String inputFilePath) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(inputFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    @Override
    public int getRed(int pixel) {
        return (pixel >> 16) & 0xff;
    }

    @Override
    public int getGreen(int pixel) {
        return (pixel >> 8) & 0xff;
    }

    @Override
    public int getBlue(int pixel) {
        return pixel & 0xff;
    }


}
