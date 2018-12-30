package cn.com;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/*
* 测试ByteBuffer中的大端模式和小端模式
* 测试ByteBuffer中的getChar方法
* */
public class Main3 {
    public static void main(String[] args){

        //big-endian
        ByteBuffer buffer=ByteBuffer.allocate(100);
        buffer.put((byte)0);
        buffer.put((byte)97);
        buffer.flip();
        char c= buffer.getChar();
        System.out.println(c);

        //little-endian
        ByteBuffer buffer1=ByteBuffer.allocate(100);
        buffer1.order(ByteOrder.LITTLE_ENDIAN);
        buffer1.put((byte)97);
        buffer1.put((byte)0);
        buffer1.flip();
        c= buffer1.getChar();
        System.out.println(c);
    }
}
