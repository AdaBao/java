package cn.com;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

public class Client {
    public  static void main(String[] args){
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS");
            FileInputStream fileInputStream=new FileInputStream("E:\\server.truststore");
            String keyStorePass="testtest";
            String keyPass="testtest";
            keyStore.load(fileInputStream,keyStorePass.toCharArray());
            //TrustManagerFactory负责的是检查服务端的证书(存疑)
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            tmf.init(keyStore);

            SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, tmf.getTrustManagers(), null);

            SSLSocketFactory socketFactory = sslContext.getSocketFactory();
            SSLSocket socket = (SSLSocket) socketFactory.createSocket("localhost", 3000);
            socket.startHandshake();
            OutputStream out=socket.getOutputStream();
            out.write(10);
            out.flush();

            System.out.println(socket.getSession().getCipherSuite());

            Certificate[] certificates= socket.getSession().getPeerCertificates();
            PublicKey publicKey=certificates[0].getPublicKey();
            System.out.println(publicKey.getAlgorithm());
            System.out.println(publicKey.getEncoded());
            System.out.println(publicKey.getFormat());
            socket.close();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }

    }
}
