package com.yous.learningtwo.host;

import com.alibaba.fastjson.JSONObject;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by syou on 2018/1/3.
 */
public class ZxingDemo {

    public static void main(String[] args) throws Exception {
        String url = "https://dimg16.c-ctrip.com/images/Z00k0o000000eqj2u0406_W_300_0.jpg";
        String url2="d:\\Users\\syou\\Desktop\\my.jpg";
       // InputStream inputStream=getPicInputStream(url);
        decodeQcode(url2);
    }
    public static void decodeQcode(String filePath) {
        BufferedImage image;
        try {
            image = ImageIO.read(new File(filePath));
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
            Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            Result result = new MultiFormatReader().decode(binaryBitmap, hints);// 对图像进行解码
            System.out.println("URL： " + result.getText());
            System.out.println(result.getBarcodeFormat());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void generateQrCode(String filePath,String fileName) throws Exception {
        JSONObject json = new JSONObject();
        json.put("URL","www.baidu.com");
        json.put("author", "syou");
        String content = json.toJSONString();
        int width = 200;
        int height = 200;
        String format = "png";
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);
        Path path = FileSystems.getDefault().getPath(filePath, fileName);
        MatrixToImageWriter.writeToPath(bitMatrix, format, path);
        System.out.println("输出成功.");
    }

    /**
     * 下载图片
     * @param url
     * @throws Exception
     */
    public static void getPic(String url) throws Exception {
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            URL picUrl = new URL(url);
            URLConnection connection = picUrl.openConnection();
            inputStream = connection.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            File file = new File("d:\\Users\\syou\\Desktop\\my.jpg");
            outputStream = new FileOutputStream(file.getPath());
            while ((len = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, len);
            }
        } catch (Exception e) {

        } finally {
            outputStream.close();
            inputStream.close();
        }
    }

    /**
     * 获取图片流
     * @param url
     * @return
     */
    public static InputStream getPicInputStream(String url) {
        InputStream inputStream = null;
        try {
            URL picUrl = new URL(url);
            URLConnection connection = picUrl.openConnection();
            inputStream = connection.getInputStream();
        } catch (Exception e) {
        }
        return inputStream;
    }

    public static void decodeQcode(InputStream inputStream) {
        BufferedImage image;
        try {
            image = ImageIO.read(inputStream);
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
            Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            Result result = new MultiFormatReader().decode(binaryBitmap, hints);// 对图像进行解码
            System.out.println("URL： " + result.getText());
            System.out.println(result.getBarcodeFormat());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }
}
