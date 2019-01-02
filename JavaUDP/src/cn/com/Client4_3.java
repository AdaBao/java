package cn.com;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;
import java.util.Set;

/*
* 基于通道的UDP echo客户端
* 向服务器按序写入1-100
* */
public class Client4_3 {
    public static void main(String[] args){
        int numberReads=0;
        int n=0;
        SocketAddress remote=new InetSocketAddress("localhost",10001);
        try (DatagramChannel channel=DatagramChannel.open()){
            channel.configureBlocking(false);
            channel.connect(remote);
            ByteBuffer buffer=ByteBuffer.allocate(4);
            Selector selector=Selector.open();
            channel.register(selector, SelectionKey.OP_READ| SelectionKey.OP_WRITE);

            while(true){
                //发出的数据全部返回并读取
                if(numberReads==100) break;
                //为一个连接等待一分钟，准确的说是：如果select的结果是一直是空的，则会等待持续60秒
                //如果select至少有一个结果，就会立刻返回
                selector.select(60000);
                Set<SelectionKey> selectionKeys=selector.selectedKeys();
                //数据已全部发出，但是select的结果是空的，说明不太有可能再有结果返回了
                if(selectionKeys.isEmpty()&&n==100)
                    break;
                Iterator<SelectionKey> iterator=selectionKeys.iterator();
                while(iterator.hasNext()){
                    SelectionKey  selectionKey=iterator.next();
                    iterator.remove();
                    if(selectionKey.isReadable()){
                        buffer.clear();
                        DatagramChannel channel1= (DatagramChannel) selectionKey.channel();
                        channel1.read(buffer);
                        buffer.flip();
                        int echoValue=buffer.getInt();
                        System.out.println("Read "+echoValue);
                        numberReads++;
                    }

                    if(selectionKey.isWritable()){
                        buffer.clear();
                        DatagramChannel channel1=(DatagramChannel) selectionKey.channel();
                        buffer.putInt(++n);
                        buffer.flip();
                        channel1.write(buffer);
                        System.out.println("wrote "+n);

                        //如果数据全部写出，则切换为只读模式
                        if(n==100)
                            selectionKey.interestOps(SelectionKey.OP_READ);
                    }
                }
            }

            System.out.println("Send number: "+n);
            System.out.println("Echo number: "+numberReads);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
