package cn.com;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/*
* 测试视图缓冲区
* */
public class Main4 {
    public static void main(String[] args){
        ByteBuffer buffer=ByteBuffer.allocate(10);
        CharBuffer cBuffer=buffer.asCharBuffer();
        cBuffer.append('a');
        cBuffer.append('b');
        cBuffer.append('c');
        cBuffer.append('d');
        cBuffer.append('e');
        System.out.println("c position: "+cBuffer.position());
        System.out.println("c limit: "+cBuffer.limit());
        System.out.println("c capacity: "+cBuffer.capacity());
        System.out.println("c hasRemaining: "+cBuffer.hasRemaining());
        System.out.println();
        System.out.println("position: "+buffer.position());
        System.out.println("limit: "+buffer.limit());
        System.out.println("capacity: "+buffer.capacity());
        System.out.println("hasRemaining: "+buffer.hasRemaining());

    }
}
