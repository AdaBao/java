package cn.com;

import javax.net.ssl.HandshakeCompletedEvent;
import javax.net.ssl.HandshakeCompletedListener;

/*
* 实现握手结束事件的接口
* */
public class HandShakeCompletedImpl implements HandshakeCompletedListener {
    @Override
    public void handshakeCompleted(HandshakeCompletedEvent handshakeCompletedEvent) {
        System.out.println("握手成功! 使用的密码组是:");
        System.out.println(handshakeCompletedEvent.getCipherSuite());
        byte[] sessionId=handshakeCompletedEvent.getSession().getId();
        System.out.println("session id是:");
        for(int i=0; i<sessionId.length; i++){
            System.out.print(sessionId[i]+" ");
        }
    }
}
