package cn.com;

import java.util.LinkedList;
import java.util.List;

//�߳�thread2������strList�����Ԫ��,�߳�thread1���ģ��Ƴ���strList�е�Ԫ��
//�߳�thread2�����Ԫ��֮��ʹ��notify֪ͨthread1�������Լ�wait���߳�thread1
//���Ƴ����е�Ԫ��֮��ʹ��notify֪ͨthread2�������Լ�wait��
//�����������ߺ�������֮��Ĺ�ϵ
public class Test9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> strList=new LinkedList();
		
		Demo9_1 thread1=new Demo9_1(strList);
		Demo9_2 thread2=new Demo9_2(strList);
		thread1.start();
		thread2.start();
		
		
		
	}

}
