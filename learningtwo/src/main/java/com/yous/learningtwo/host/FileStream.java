package com.yous.learningtwo.host;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by syou on 2018/4/3.
 */
public class FileStream {


    public static void main(String[] args) {
        File file = new File("D:\\Users\\syou\\Desktop\\test.txt");
        if (file.exists()) {
            System.out.println(true);
        }

        List<Integer> a = Stream.iterate(new int[]{0, 1}, t -> new int[]{t[1], t[0] + t[1]}).limit(20).map(t -> t[0]).collect(Collectors.toList());

        System.out.println(a);
        try (Stream<String> lines = Files.lines(Paths.get("D:\\Users\\syou\\Desktop\\test.txt"), Charset.defaultCharset())) {

            long distinctCount = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
            System.out.println(distinctCount);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
