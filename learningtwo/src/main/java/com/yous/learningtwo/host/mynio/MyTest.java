package com.yous.learningtwo.host.nio;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author syou
 * @date 2019/6/10.
 */
public class MyTest {

    @Test
    public void client() {
        try (SocketChannel clientChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898))) {
            ByteBuffer buf = ByteBuffer.allocate(1024);

            System.out.println("请输入:");
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNext()) {
                String content = new Date().toString() + ":\r\n" + scanner.next().toString();
                buf.put(content.getBytes());
                buf.flip();
                clientChannel.write(buf);
                buf.clear();
            }
        } catch (Exception e) {

        }
    }


    @Test
    public void server() {

        try (ServerSocketChannel serverChannel = ServerSocketChannel.open();) {
            serverChannel.bind(new InetSocketAddress(9898));

            Selector selector = Selector.open();
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);
            while(selector.select() > 0){
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                while(it.hasNext()){
                    SelectionKey sk = it.next();
                    if(sk.isAcceptable()){
                        SocketChannel sChannel = serverChannel.accept();
                        sChannel.configureBlocking(false);
                        sChannel.register(selector, SelectionKey.OP_READ);
                    }else if(sk.isReadable()){
                        SocketChannel sChannel = (SocketChannel) sk.channel();
                        ByteBuffer buf = ByteBuffer.allocate(1024);

                        int len = 0;
                        while((len = sChannel.read(buf)) > 0 ){
                            buf.flip();
                            System.out.println(new String(buf.array(), 0, len));
                            buf.clear();
                        }
                    }
                    it.remove();
                }
            }

        } catch (Exception e) {

        }


    }

}
