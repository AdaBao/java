package cn.com;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
* Server7用于测试Logger类的使用，但是Logger可以使用在任何地方，并不
* 局限于网络编程中
* */
public class Server7 {

    //Logger是java所提供的日志操作类，getLogger能够获得指定name所对应的
    //Logger，如果name已存在，则直接返回Logger的引用，否则创建一个新的
    //Logger
    private final static Logger log=Logger.getLogger("requests");

    public static void main(String[] args){
        ExecutorService pool= Executors.newFixedThreadPool(10);

        try(ServerSocket server=new ServerSocket(3000)){
            while(true){
                Socket client=server.accept();
                TellTimeThread thread=new TellTimeThread(client);
                pool.submit(thread);

                //下面这两行用于测试RuntimeException
                /*int [] a=new int[2];
                System.out.println(a[2]);*/
            }
        }
        catch (IOException e) {
            log.log(Level.WARNING,"accept error",e);
        }
        catch(RuntimeException e){
            log.log(Level.SEVERE,"unexpected error",e);
        }
    }



    static class TellTimeThread implements Callable<Void> {
        Socket socket;
        public TellTimeThread(Socket socket){
            this.socket=socket;
        }
        @Override
        public Void call() throws Exception {
            Date now=new Date();
            if(socket!=null){
                log.log(Level.INFO,now+" "+socket.getRemoteSocketAddress());
                OutputStream out=socket.getOutputStream();
                OutputStreamWriter outputStreamWriter=new OutputStreamWriter(out);
                BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
                bufferedWriter.write(now.toString()+"\r\n");
                bufferedWriter.flush();
                bufferedWriter.close();
                socket.close();

            }
            return null;
        }
    }
}
