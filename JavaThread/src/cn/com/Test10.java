package cn.com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����һ���̳߳�,��СΪ2,Ĭ�������,�̳߳���û���κ��߳�.����߳�������󳬹���
		//�̳߳صĴ�С,��ôû�п�ʼ�������̻߳��Ŷӵȴ�
		ExecutorService pool=Executors.newFixedThreadPool(2);
		
		//���������߳�,�����ύ���̳߳�
		Demo10 thread1=new Demo10();
		Demo10 thread2=new Demo10();
		Demo10 thread3=new Demo10();
		
		//��3���߳��ύ���̳߳�
		Future future1=pool.submit(thread1);
		Future future2=pool.submit(thread2);
		Future future3=pool.submit(thread3);
		
		//֪ͨ�̳߳�û�и����������Ҫ�ύ��,������Ӱ����δ��ɵĹ���
		pool.shutdown();
		

	}

}
