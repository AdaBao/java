package cn.com;

import java.nio.ByteBuffer;

/*
* 测试ByteBuffer的duplicate方法
* */
public class Main6 {
    public static void main(String[] args){
        ByteBuffer buffer=ByteBuffer.allocate(5);
        ByteBuffer buffer1=buffer.duplicate();
        buffer.put((byte)'a');
        buffer.put((byte)'b');

        byte[] content1=buffer.array();
        byte[] content2=buffer1.array();

        for(int i=0; i<5; i++)
            System.out.print(content1[i]+" ");
        System.out.println();

        for(int i=0; i<5; i++)
            System.out.print(content2[i]+" ");
        System.out.println();

        System.out.println("buffer:");
        System.out.println("position: "+buffer.position());
        System.out.println("limit: "+buffer.limit());
        System.out.println("capacity: "+buffer.capacity());
        System.out.println("hasRemaining: "+buffer.hasRemaining());
        System.out.println("buffer1:");
        System.out.println("position: "+buffer1.position());
        System.out.println("limit: "+buffer1.limit());
        System.out.println("capacity: "+buffer1.capacity());
        System.out.println("hasRemaining: "+buffer1.hasRemaining());
    }
}
