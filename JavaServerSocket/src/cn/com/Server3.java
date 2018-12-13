package cn.com;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
* 这段程序也是一个时间服务器，所不同的是采用了多线程的方式
* 如果不采用多线程的方式，有可能因为前一个任务的阻塞而导致
* 后面任务迟迟不能得到执行，阻塞的原因可能是网络拥塞、程序
* 本身执行时间较长等原因。但是也不能为每个请求都提供一个线程，
* 比如说如果有恶意用户发送大量的请求，就会导致服务端存在有
* 大量的线程，过多的线程会耗光服务端的资源，所以需要使用线程池
* */
public class Server3 {
    public static void main(String[] args){
        //线程池的大小是50
        ExecutorService pool= Executors.newFixedThreadPool(50);
        try(ServerSocket server=new ServerSocket(3000)){
            while(true){
                    Socket connection=server.accept();
                    TellTimeThread newThread=new TellTimeThread(connection);
                    pool.submit(newThread);
            }
        }
        catch (IOException e){}
        pool.shutdown();
    }
}
