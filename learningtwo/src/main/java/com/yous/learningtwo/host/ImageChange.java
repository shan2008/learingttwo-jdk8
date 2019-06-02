package com.yous.learningtwo.host;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

/**
 * @author syou
 * @date 2019/4/4.
 */
public class ImageChange {


    @Test
    public void test() throws IOException {
        try {


        } catch (Exception e) {

        }

    }


    public void mergeImage(String bigPath, String smallPath, String x, String y) throws IOException {

        try {
            BufferedImage small = ImageIO.read(new File(smallPath));
            BufferedImage big = ImageIO.read(new File(bigPath));

            int bigW = big.getWidth();
            int bigH = big.getHeight();

            int smallW = small.getWidth();
            int smallH = small.getHeight();

            Graphics2D g = big.createGraphics();

            float fx = Float.parseFloat(x);
            float fy = Float.parseFloat(y);
            int x_i = (int) fx;
            int y_i = (int) fy;
            g.drawImage(small, x_i, y_i, small.getWidth(), small.getHeight(), null);
            g.dispose();
            ImageIO.write(big, "png", new File(bigPath));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void mergeImage2(String bigPath, String smallPath, int x, int y) throws IOException {
        try( FileOutputStream fout  = new FileOutputStream("D:\\Users\\syou\\Desktop\\新建文件夹\\hh.png")) {
            BufferedImage small = ImageIO.read(new File(smallPath));
            BufferedImage big = ImageIO.read(new File(bigPath));

            Graphics2D g = big.createGraphics();
            g.drawImage(small, x, y, small.getWidth(), small.getHeight(), null);
            g.dispose();


            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(big, "png", byteArrayOutputStream);
            byte[] bytes = byteArrayOutputStream.toByteArray();
            //将字节写入文件
            fout.write(bytes);
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
