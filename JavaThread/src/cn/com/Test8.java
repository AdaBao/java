package cn.com;

public class Test8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data={2,3,0,1,23,56,11,-9};
		Demo8 thread=new Demo8(data);
		thread.start();
		try {
			//������join����֮��,���̻߳���ͣ�ȴ�thread����߳�ִ�����
			thread.join();
			for(int i=0; i<data.length; i++)
				System.out.print(data[i]+" ");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
