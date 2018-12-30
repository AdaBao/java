package cn.com;

import java.nio.ByteBuffer;

/*
* 测试ByteBuffer的mark和reset方法
* */
public class Main7 {
    public static void main(String[] args){

        ByteBuffer buffer=ByteBuffer.allocate(100);
        ByteBuffer buffer1=ByteBuffer.allocate(100);

        buffer.put((byte)'a');
        System.out.println("position: "+buffer.position());
        System.out.println("limit: "+buffer.limit());
        System.out.println("capacity: "+buffer.capacity());
        System.out.println("hasRemaining: "+buffer.hasRemaining());
        System.out.println();
        buffer.mark();
        buffer.put((byte)'b');
        System.out.println("position: "+buffer.position());
        System.out.println("limit: "+buffer.limit());
        System.out.println("capacity: "+buffer.capacity());
        System.out.println("hasRemaining: "+buffer.hasRemaining());
        buffer.reset();
        System.out.println();
        System.out.println("position: "+buffer.position());
        System.out.println("limit: "+buffer.limit());
        System.out.println("capacity: "+buffer.capacity());
        System.out.println("hasRemaining: "+buffer.hasRemaining());

        //书上有句话：这将应用于所有缓冲区。但是下面的测试证实这句话是错的
        System.out.println();
        System.out.println("position: "+buffer1.position());
        System.out.println("limit: "+buffer1.limit());
        System.out.println("capacity: "+buffer1.capacity());
        System.out.println("hasRemaining: "+buffer1.hasRemaining());
    }
}
