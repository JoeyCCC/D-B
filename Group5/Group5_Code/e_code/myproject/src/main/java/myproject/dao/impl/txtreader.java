package myproject.dao.impl;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;

public class txtreader {

    public static void visualizePath(String inputFilePath, String outputImagePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            BufferedImage image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = image.createGraphics();
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, image.getWidth(), image.getHeight());
            g2d.setColor(Color.RED);

            String line;

            int prevX = -1;
            int prevY = -1;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                int length = Integer.parseInt(parts[0]);
                int x = Integer.parseInt(parts[1]) * 30;
                int y = Integer.parseInt(parts[2]) * 30;

                if (prevX != -1 && prevY != -1) {
                    // 如果不是第一个点，绘制线段
                    g2d.drawLine(prevX, prevY, x, y);
                }

                prevX = x;
                prevY = y;
            }

            try {
                ImageIO.write(image, "png", new File(outputImagePath));
            } catch (IOException e) {
                e.printStackTrace();
            }

            g2d.dispose();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


