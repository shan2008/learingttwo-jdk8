package com.yous.learningtwo.host.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.junit.Test;

public class TestBlockingNIO2 {
    //客户端
    @Test
    public void client() throws IOException {
        try (SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
             FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);) {

            ByteBuffer buf = ByteBuffer.allocate(1024);
            while (inChannel.read(buf) != -1) {
                buf.flip();
                sChannel.write(buf);
                buf.clear();
            }

            sChannel.shutdownOutput();
            int len = 0;
            while ((len = sChannel.read(buf)) != -1) {
                buf.flip();
                System.out.println(new String(buf.array(), 0, len));
                buf.clear();
            }

        }

    }

    //服务端
    @Test
    public void server() throws IOException {
        try (  ServerSocketChannel ssChannel = ServerSocketChannel.open();
               FileChannel outChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
               SocketChannel sChannel = ssChannel.accept();){
            ssChannel.bind(new InetSocketAddress(9898));
            ByteBuffer buf = ByteBuffer.allocate(1024);

            while (sChannel.read(buf) != -1) {
                buf.flip();
                outChannel.write(buf);
                buf.clear();
            }

            //发送反馈给客户端
            buf.put("服务端接收数据成功".getBytes());
            buf.flip();
            sChannel.write(buf);
        }
    }

}
