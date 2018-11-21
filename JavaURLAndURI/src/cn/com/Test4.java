package cn.com;



import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;
//从URL中获取数据
public class Test4 {
    public static void main(String[] args){
        try {
            URL url=new URL("http://www.baidu.com");
            Class[] types=new Class[3];
            types[0]=String.class;
            types[1]= Reader.class;
            types[2]= InputStream.class;

            Object o=url.getContent(types);

            if(o instanceof  String){
                System.out.println("It is String");
                System.out.println(o);
            }else if(o instanceof  Reader){
                System.out.println("It is Reader");
                Reader reader=(Reader)o;
                int c;
                while((c=reader.read())!=-1){
                    System.out.print((char) c);
                }
                reader.close();
            }else if(o instanceof InputStream){
                System.out.println("It is InputStream");
                InputStreamReader isReader=new InputStreamReader((InputStream) o);
                int c;
                while((c=isReader.read())!=-1){
                    System.out.print((char) c);
                }
                isReader.close();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }}
