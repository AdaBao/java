package cn.com;

import java.util.Enumeration;
import java.util.Vector;

/*
* Vector 是矢量队列，它是JDK1.0版本添加的类。继承于AbstractList，实现了List, RandomAccess, Cloneable这些接口。
Vector 继承了AbstractList，实现了List；所以，它是一个队列，支持相关的添加、删除、修改、遍历等功能。
Vector 实现了RandmoAccess接口，即提供了随机访问功能。RandmoAccess是java中用来被List实现，为List提供快速访问功能的。
在Vector中，我们即可以通过元素的序号快速获取元素对象；这就是快速随机访问。
Vector 实现了Cloneable接口，即实现clone()函数。它能被克隆。
和ArrayList不同，Vector中的操作是线程安全的
* */
public class Main {
    public static void main(String[] args){
        Vector<String> vector=new Vector(2);
        System.out.println("向量大小: "+vector.capacity());
        vector.add("aaa");
        vector.add("bbb");
        vector.add("ccc");
        vector.addElement("ddd");//和add方法的区别只在于add有boolean类型的返回值
        System.out.println("向量大小: "+vector.capacity());
        Enumeration<String> vEnum=vector.elements();
        while(vEnum.hasMoreElements()){//遍历
            System.out.println(vEnum.nextElement());
        }
        System.out.println("--------------------------------------------------------------");
        System.out.println(vector.elementAt(2));//随机访问


    }
}
