package cn.com;

public class Main1000 {
    public static void main(String[] args){
        String str="abc";
        byte[] b= str.getBytes();
        System.out.println(b.length);

        System.out.println("<?xml version=\"1.0\" encoding=\"utf-8\"?><soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"><soap:Body><qqCheckOnlineResponse xmlns=\"http://WebXml.com.cn/\"><qqCheckOnlineResult>Y</qqCheckOnlineResult></qqCheckOnlineResponse></soap:Body></soap:Envelope>".length());
    }
}
