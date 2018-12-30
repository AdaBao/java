package cn.com;

import java.io.IOException;
import java.net.SocketOption;
import java.nio.channels.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 获取不同的socket channel所支持的socket选项
 */

public class Main13 {
    public static void main(String[] args){
        Set<NetworkChannel> networkChannels=new HashSet<>();
        try {
            networkChannels.add(SocketChannel.open());
            networkChannels.add(ServerSocketChannel.open());
            networkChannels.add(AsynchronousSocketChannel.open());
            networkChannels.add(AsynchronousServerSocketChannel.open());
            networkChannels.add(DatagramChannel.open());

            Iterator<NetworkChannel> iterator=networkChannels.iterator();
            while(iterator.hasNext()){
                NetworkChannel channel=iterator.next();
                System.out.println(channel.getClass().getSimpleName());
                Set<SocketOption<?>> options=channel.supportedOptions();
                Iterator<SocketOption<?>> iterator1=options.iterator();

                while(iterator1.hasNext()){
                    System.out.println(iterator1.next().name());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
