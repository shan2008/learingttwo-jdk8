package com.yous.learningtwo.host;

import com.alibaba.fastjson.JSONObject;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.mysql.jdbc.StringUtils;

import org.apache.commons.codec.binary.Base64;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by syou on 2018/1/3.
 */
public class ZxingDemo {

    public static void main(String[] args) throws Exception {

      ExecutorService service = Executors.newCachedThreadPool();

       /* List<String>  a=new ArrayList<>();
        a.add("sas");
        a.toArray();
*/
        //http://blog.csdn.net/WuZuoDingFeng/article/details/77946489 JPG格式被修改ps 保存，，颜色编码变为CMYK，
        // ImageIO.read 报异常 Unsupported Image Type


        //getFileStr(wechat1);

        //decodeQcode(wechat1);
        // readPic(wechat1);

/*
        downLoad();

        String file = "D:\\Users\\syou\\Desktop\\sendlike\\米兰361.png";
        decodeQcode(file);*/

    }


    /**
     * 获取图片bitmap
     *
     * @param path
     */
    private static void loadImageBitmap(final String path) {
        try {
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setReadTimeout(10000);
            connection.setConnectTimeout(10000);
            if (connection.getResponseCode() == 200) {
                InputStream inputStream = connection.getInputStream();
                inputStream.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static String getFileStr(String filePath) throws IOException {
        File file = new File(filePath);

        if (!file.exists()) {
            return "";
        }
        byte[] bytes = new byte[(int) file.length()];
        String fileStr = "";
        try (InputStream inputStream = new FileInputStream(file)) {
            inputStream.read(bytes);

            fileStr = Base64.encodeBase64String(bytes);
            System.out.println(fileStr);
        }

        return fileStr;

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
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generateQrCode(String filePath, String fileName) throws Exception {
        JSONObject json = new JSONObject();
        json.put("URL", "www.baidu.com");
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
     *
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
     *
     * @param url
     * @return
     */
    public static InputStream getPicInputStream(String url) {
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        try {
            URL picUrl = new URL(url);
            connection = (HttpURLConnection) picUrl.openConnection();
            inputStream = connection.getInputStream();
        } catch (Exception e) {
        } finally {
            connection.disconnect();
        }
        return inputStream;
    }


    public static void decodeQcode(InputStream inputStream) {
        if (inputStream == null) {
            return;
        }
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
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static boolean isPicture(String picUrl) {
        if (StringUtils.isNullOrEmpty(picUrl)) {
            return false;
        }
        String suffix = picUrl.contains(".") ? picUrl.substring(picUrl.lastIndexOf('.')) : "";
        if (StringUtils.isNullOrEmpty(suffix)) {
            return false;
        }
        return Arrays.asList(".JPG", ".JPEG", ".PNG", ".GIF", ".BMP").contains(suffix.toUpperCase());

    }



    private static void downLoad() {


    }


}
