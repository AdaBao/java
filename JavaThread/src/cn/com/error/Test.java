package cn.com.error;

//���д�������쳣
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++){
			TestThread t=new TestThread();
			t.start();
			System.out.println(t.getStrLen());
		}

	}

}