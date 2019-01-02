package cn.com;

import java.io.IOException;
import java.net.*;

/*
* 使用UDP实现时间客户端，但是超时了
* 使用TCP都超时，所以正常......
* */
public class DayTimeUDPClient {
    public static void main(String[] args){
        try(DatagramSocket socket=new DatagramSocket(0)) {
            socket.setSoTimeout(10000);
            InetAddress address=InetAddress.getByName("time.nist.gov");
            DatagramPacket request=new DatagramPacket(new byte[1],1,address,13);
            byte[] data=new byte[1024];
            DatagramPacket response=new DatagramPacket(data,data.length);
            socket.send(request);
            socket.receive(response);
            String result=new String(response.getData(),0,response.getLength(),"ASCII");
            System.out.println(result);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
