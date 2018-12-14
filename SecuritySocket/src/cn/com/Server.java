package cn.com;

import javax.net.ssl.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.*;
import java.security.cert.CertificateException;

/*
* Server是安全服务端
* */

/*
*   1 生成keystore文件
    keytool -genkeypair -alias "test" -keyalg "RSA" -keystore "E:\\server.keystore"
    密钥库口令:testtest
    密钥口令:testtest
    2 导出公钥证书
    keytool -export -alias test -keystore  "E:\\server.keystore"  -rfc -file E:\\"server.cer"
    3 truststore的生成以及公钥证书的导入
    keytool -import -alias test -file E:\\server.cer  -keystore E:\\server.truststore
    密钥库口令:testtest
* */


public class Server {
    public static void main(String[] args){
        try {
            KeyStore keyStore=KeyStore.getInstance("JKS");
            FileInputStream fileInputStream=new FileInputStream("E:\\server.keystore");
            String keyStorePass="testtest";
            String keyPass="testtest";
            keyStore.load(fileInputStream,keyStorePass.toCharArray());

            //KeyManagerFactory负责的是把服务器的证书给客户端(存疑)
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(keyStore,keyPass.toCharArray());

            SSLContext sslContext = SSLContext.getInstance("SSL");

            sslContext.init(kmf.getKeyManagers(), null, null);

            fileInputStream.close();

            SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();
            SSLServerSocket sslServerSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(3000);
            sslServerSocket.setNeedClientAuth(false);

            SSLSocket s = (SSLSocket)sslServerSocket.accept();

            InputStream in=s.getInputStream();
            int data=in.read();
            System.out.println(data);

            System.out.println(s.getSession().getCipherSuite());




            s.close();

        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnrecoverableKeyException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }
}
