package cn.com;

import java.nio.ByteBuffer;

/*
* ByteBuffer类中的buffer.array方法返回的是后备数组的引用
* 所以修改content数组就会导致buffer中数据的改变
* */
public class Main1 {
    public static void main(String[] args){
        ByteBuffer buffer=ByteBuffer.allocate(1000);
        buffer.put((byte)'a');
        buffer.put((byte)'b');
        buffer.put((byte)'c');
        byte[] content=buffer.array();
        for(int i=0; i<content.length; i++)
            System.out.print(content[i]+" ");
        System.out.println();
        content[0]='d';
        content=buffer.array();
        for(int i=0; i<content.length; i++)
            System.out.print(content[i]+" ");
    }
}
