package cn.com;

public class Demo6 extends Thread{
	@Override
	public void run(){
		this.print();
	}
	
	//synchronized�������÷�Χ�ǵ�ǰ��ʵ��
	private synchronized void print(){
		for(int i=0; i<10; i++)
			System.out.print(i+" ");
		System.out.println();
	}

}
