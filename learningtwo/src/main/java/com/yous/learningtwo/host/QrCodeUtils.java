package com.yous.learningtwo.host;
import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.mysql.jdbc.StringUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by syou on 2018/1/22.
 */
public class QrCodeUtils {

    private QrCodeUtils(){

    }
    /**
     * 二位识别
     *
     * @param url
     * @return
     */
    public static boolean isQrcode(String url) {
        if (StringUtils.isNullOrEmpty(url)) {
            return false;
        }
        try {
            URL picUrl = new URL(url);
            URLConnection connection = picUrl.openConnection();
            InputStream inputStream = connection.getInputStream();
            Tuple<Boolean, String> result = decodeQcode(inputStream);
            return result.getItem1();
        } catch (Exception e) {
           // LoggingUtils.current().warn("isQrcode", e);
        }

        return false;
    }

    /**
     * 二维码解析，为二维码则解析出内容，二维码抛出NotFoundException异常
     *
     * @param inputStream
     * @return
     */
    public static Tuple<Boolean, String> decodeQcode(InputStream inputStream) {
        Tuple<Boolean, String> result = new Tuple<>();
        try {
            BufferedImage image = ImageIO.read(inputStream);
            LuminanceSource source = new BufferedImageLuminanceSource(image);
            Binarizer binarizer = new HybridBinarizer(source);
            BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
            Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
            hints.put(DecodeHintType.CHARACTER_SET, "UTF-8");
            Result content = new MultiFormatReader().decode(binaryBitmap, hints);
            result.setItem1(true);
            result.setItem2(content.getText());
        } catch (NotFoundException e) {
            result.setItem1(false);
        } catch (Exception e) {
            result.setItem1(false);
        }finally {
            try {
                inputStream.close();
            }catch (Exception e){
            }
        }

        return result;
    }

}
