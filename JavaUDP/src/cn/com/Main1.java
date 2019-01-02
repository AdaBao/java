package cn.com;

import java.net.DatagramPacket;

/*
* 测试DatagramPacket的数据部分，从输出结果的可以得知
* 数据报中的数据不是私有的
* */

public class Main1 {
    public static void main(String[] args){
        byte [] data={0,1,2,4,5};
        DatagramPacket packet=new DatagramPacket(data,data.length);
        byte [] data1=packet.getData();
        for(int i=0; i<5; i++)
            System.out.print(data1[i]+" ");
        System.out.println();
        data[0]=6;
        byte [] data2=packet.getData();
        for(int i=0; i<5; i++)
            System.out.print(data2[i]+" ");
        System.out.println();
        System.out.println(data);
        System.out.println(data1);
        System.out.println(data2);
    }
}
