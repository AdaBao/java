package cn.com;

public class Demo7 extends Thread{
	@Override
	public void run(){
		this.print();
	}
	
	//static��synchronized����,�������������
	public synchronized static void print(){
		for(int i=0; i<10; i++)
			System.out.print(i+" ");
		System.out.println();
	}

}
