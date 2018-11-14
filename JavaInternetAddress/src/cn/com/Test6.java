package cn.com;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
//通过这段代码可以看出，Future对象并不是在线程启动之后才构造的
//线程池中的线程是在所有的callable都提交后才会启动
public class Test6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor=Executors.newFixedThreadPool(2);
		DemoThread thread=new DemoThread();
		DemoThread thread1=new DemoThread();
		Future<String> future1=executor.submit(thread);
		Future<String> future2=executor.submit(thread1);
		System.out.println(future1);
		System.out.println(future2);
		try {
			System.out.println(future1.get());
			System.out.println(future2.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		executor.shutdown();

	}

}
