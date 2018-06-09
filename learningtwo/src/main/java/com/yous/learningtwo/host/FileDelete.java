package com.yous.learningtwo.host;

import java.io.File;

/**
 * Created by syou on 2018/3/26.
 */
public class FileDelete {

    public static void main(String[] args) {
        fileDelete(new File("D:\\Users\\syou\\Desktop\\demo1"));
        System.out.println("删除文件完毕...");
    }

    /**
     * 删除文件和文件夹
     *
     * @param file
     */
    private static void fileDelete(File file) {
        if (!file.exists()) {
            return;
        }

        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                f.delete();
            } else {
                fileDelete(f);
                f.delete();
            }
        }
    }
}
