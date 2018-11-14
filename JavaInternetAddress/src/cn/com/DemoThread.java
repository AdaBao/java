package cn.com;

import java.util.concurrent.Callable;

public class DemoThread implements Callable<String>{

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		Thread.sleep(2000);
		return "hehe";
	}

}
