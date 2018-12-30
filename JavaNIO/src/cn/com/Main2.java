package cn.com;

import java.nio.ByteBuffer;

/*
* ByteBuffer测试
* */
public class Main2 {
    public static void main(String[] args){
        ByteBuffer buffer=ByteBuffer.allocate(10);
        buffer.put((byte)'a');
        buffer.put((byte)'b');
        buffer.put((byte)'c');
        buffer.put((byte)'d');
        System.out.println("position: "+buffer.position());
        System.out.println("limit: "+buffer.limit());
        System.out.println("capacity: "+buffer.capacity());
        System.out.println("hasRemaining: "+buffer.hasRemaining());

        buffer.limit(6);
        buffer.put((byte)'e');
        buffer.put((byte)'f');

        //BufferOverflowException,不能超过limit
        //buffer.put((byte)'g');

        System.out.println();
        System.out.println("position: "+buffer.position());
        System.out.println("limit: "+buffer.limit());
        System.out.println("capacity: "+buffer.capacity());
        System.out.println("hasRemaining: "+buffer.hasRemaining());

        buffer.flip();
        System.out.println();
        System.out.println("position: "+buffer.position());
        System.out.println("limit: "+buffer.limit());
        System.out.println("capacity: "+buffer.capacity());
        System.out.println("hasRemaining: "+buffer.hasRemaining());

        System.out.println();
        byte[] content=buffer.array();
        for(int i=0; i<content.length; i++){
            System.out.print(content[i]+" ");
        }
        System.out.println();
        System.out.println("position: "+buffer.position());
        System.out.println("limit: "+buffer.limit());
        System.out.println("capacity: "+buffer.capacity());
        System.out.println("hasRemaining: "+buffer.hasRemaining());

        System.out.println();
        byte b=buffer.get();
        System.out.println(b);
        System.out.println();
        System.out.println("position: "+buffer.position());
        System.out.println("limit: "+buffer.limit());
        System.out.println("capacity: "+buffer.capacity());
        System.out.println("hasRemaining: "+buffer.hasRemaining());

        System.out.println();
        buffer.flip();
        System.out.println("position: "+buffer.position());
        System.out.println("limit: "+buffer.limit());
        System.out.println("capacity: "+buffer.capacity());
        System.out.println("hasRemaining: "+buffer.hasRemaining());

        buffer.limit(6);
        System.out.println();
        System.out.println("position: "+buffer.position());
        System.out.println("limit: "+buffer.limit());
        System.out.println("capacity: "+buffer.capacity());
        System.out.println("hasRemaining: "+buffer.hasRemaining());

        System.out.println();
        System.out.println(buffer.get());
        System.out.println("position: "+buffer.position());
        System.out.println("limit: "+buffer.limit());
        System.out.println("capacity: "+buffer.capacity());
        System.out.println("hasRemaining: "+buffer.hasRemaining());

        System.out.println();
        buffer.rewind();
        System.out.println("position: "+buffer.position());
        System.out.println("limit: "+buffer.limit());
        System.out.println("capacity: "+buffer.capacity());
        System.out.println("hasRemaining: "+buffer.hasRemaining());

        System.out.println();
        buffer.clear();
        System.out.println("position: "+buffer.position());
        System.out.println("limit: "+buffer.limit());
        System.out.println("capacity: "+buffer.capacity());
        System.out.println("hasRemaining: "+buffer.hasRemaining());
        System.out.println();
        //-------------------------------------------------------------

        byte[] data={1,2,3,4,5};
        ByteBuffer buffer1=ByteBuffer.wrap(data);
        content=buffer1.array();
        for(int i=0; i<content.length; i++)
            System.out.print(content[i]+" ");
        data[0]=0;
        System.out.println();
        for(int i=0; i<content.length; i++)
            System.out.print(content[i]+" ");
        System.out.println();

        byte[] dst=new byte[10];
       buffer1.get(dst,5,3);
        for(int i=0; i<dst.length; i++)
            System.out.print(dst[i]+" ");

    }
}
