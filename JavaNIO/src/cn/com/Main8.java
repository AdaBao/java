package cn.com;
import java.nio.CharBuffer;

/*
* 测试Buffer的相等性
* */
public class Main8 {
    public static void main(String[] args){
        CharBuffer buffer1=CharBuffer.wrap("123456");
        CharBuffer buffer2=CharBuffer.wrap("3456");
        buffer1.get();
        buffer1.get();

        System.out.println(buffer1.equals(buffer2));
        System.out.println(buffer1.compareTo(buffer2));

        buffer1.get();
        System.out.println(buffer1.equals(buffer2));
        System.out.println(buffer1.compareTo(buffer2));

        CharBuffer buffer3=CharBuffer.wrap("123");
        CharBuffer buffer4=CharBuffer.wrap("12");
        System.out.println(buffer3.equals(buffer4));
        System.out.println(buffer3.compareTo(buffer4));


    }
}
