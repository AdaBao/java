package cn.com.callback;

//���д�������쳣
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++){
			TestThread t=new TestThread();
			t.start();
		}
	}
	public static void printLen(int len){
		System.out.println(len);
	}

}
