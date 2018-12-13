package cn.com;

import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.Callable;

//每个线程为每个socket提供时间服务
public class TellTimeThread implements Callable<Void> {
    Socket socket;
    public TellTimeThread(Socket socket){
        this.socket=socket;
    }
    @Override
    public Void call() throws Exception {
        Date now=new Date();
        if(socket!=null){
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
