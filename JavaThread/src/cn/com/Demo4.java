package cn.com;

public class Demo4 extends Thread{
	
	@Override
	public void run(){
		//����Demo4ʵ�������߳�ͬһ��ʱ��ֻ��һ���߳��ܹ�����
		//synchronized�������ִ��,������"Ҫô����,Ҫô����"
		synchronized(Demo4.class){
			for(int i=0; i<10; i++)
		    {
				System.out.print(this.getName()+" ");
				System.out.println("000");
		    }
		}
		}
	}


