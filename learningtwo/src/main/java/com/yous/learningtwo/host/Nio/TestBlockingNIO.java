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

/*
 * 一、使用 NIO 完成网络通信的三个核心：
 * 
 * 1. 通道（Channel）：负责连接
 * 		
 * 	   java.nio.channels.Channel 接口：
 * 			|--SelectableChannel
 * 				|--SocketChannel
 * 				|--ServerSocketChannel
 * 				|--DatagramChannel
 * 
 * 				|--Pipe.SinkChannel
 * 				|--Pipe.SourceChannel
 * 
 * 2. 缓冲区（Buffer）：负责数据的存取
 * 
 * 3. 选择器（Selector）：是 SelectableChannel 的多路复用器。用于监控 SelectableChannel 的 IO 状况
 * 
 */
public class TestBlockingNIO {

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
        }
    }

    //服务端
    @Test
    public void server() throws IOException {
        try (ServerSocketChannel ssChannel = ServerSocketChannel.open();
             FileChannel outChannel = FileChannel.open(Paths.get("2.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
             SocketChannel sChannel = ssChannel.accept();) {
            ssChannel.bind(new InetSocketAddress(9898));
            ByteBuffer buf = ByteBuffer.allocate(1024);
            while (sChannel.read(buf) != -1) {
                buf.flip();
                outChannel.write(buf);
                buf.clear();
            }
        }
    }

}
