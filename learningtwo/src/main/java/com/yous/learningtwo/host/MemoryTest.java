package com.yous.learningtwo.host;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by syou on 2018/2/28.
 */
public class MemoryTest {

    public static void fillhead(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillhead(1000);
    }

}


class OOMObject {
    public byte[] placeholder = new byte[64 * 1024];
}

