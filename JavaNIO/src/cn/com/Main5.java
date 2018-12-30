package cn.com;

import java.nio.ByteBuffer;

/*
* 测试ByteBuffer的压缩方法
* */
public class Main5 {
    public static void main(String[] args){
        ByteBuffer buffer=ByteBuffer.allocate(100);
        System.out.println("position: "+buffer.position());
        System.out.println("limit: "+buffer.limit());
        System.out.println("capacity: "+buffer.capacity());
        System.out.println("hasRemaining: "+buffer.hasRemaining());
        System.out.println();
        buffer.put((byte)'a');
        buffer.put((byte)'a');
        buffer.put((byte)'a');
        buffer.put((byte)'a');
        System.out.println("position: "+buffer.position());
        System.out.println("limit: "+buffer.limit());
        System.out.println("capacity: "+buffer.capacity());
        System.out.println("hasRemaining: "+buffer.hasRemaining());
        System.out.println();
        buffer.flip();
        buffer.get();
        //该方法会把position和limit之间的数据拷贝到
        //Buffer的开头，position=limit-position，limit=capacity
        //在网络里面，可能数据来不及全部输出，所以可以把为缓冲区
        //压缩，这样，没有来得及写出的数据就不会被覆盖
        buffer.compact();
        System.out.println("position: "+buffer.position());
        System.out.println("limit: "+buffer.limit());
        System.out.println("capacity: "+buffer.capacity());
        System.out.println("hasRemaining: "+buffer.hasRemaining());
    }
}
