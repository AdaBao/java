package cn.com;

public class Demo5 extends Thread{
	int count=0;
	@Override
	public void run(){
		//this,��ǰ������
		synchronized(this){
			for(int i=0; i<10; i++)
				System.out.print(i);
		}
		System.out.println();
	}
}
