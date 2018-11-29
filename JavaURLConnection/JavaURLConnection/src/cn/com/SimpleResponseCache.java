package cn.com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* ResponseCache中的get方法根据URI获取缓存，put方法用来存放缓存，每一个URI所对应的缓存用一个CacheResponse对象来表示，
* get方法会返回URI所对应的CacheResponse对象，CacheResponse的getBody方法会被调用以获取缓存内容，实际上，getBody方法
* 需要CacheRequest对象，因为缓存内容是存储于CacheRequest对象之中的（不完全准确），同时CacheRequest对象也是ResponseCache对象的put方法
* 的返回类型，在CacheRequest对象中亦存在getBody方法，这个方法的返回值是一个输出流，这个输出流会被写入所要缓存的数据，
* 所以说CacheRequest对象是缓存的channel（通道），因为CacheRequest对象保存了缓存的引用
*  */
public class SimpleResponseCache extends ResponseCache {
    Map<URI,SimpleCacheResponse>  cacheResponses=new HashMap<>();
    @Override
    public CacheResponse get(URI uri, String rqstMethod, Map<String, List<String>> rqstHeaders) throws IOException {
        //可以确定get方法用的是值比较而不是引用比较
        SimpleCacheResponse response=cacheResponses.get(uri);
        if(response!=null)
        {
            System.out.println("-------------------------------------------------------------------------");
            System.out.println("Cache is called:");
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(response.getBody(),"GBK"));
            String line=null;
            while((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }
            bufferedReader.close();
            System.out.println("-------------------------------------------------------------------------");
            return response;
        }
        else
            return null;
    }

    @Override
    public CacheRequest put(URI uri, URLConnection conn) throws IOException {
        SimpleCacheRequest cacheRequest=new SimpleCacheRequest();
        Map<String,List<String>>  headers=conn.getHeaderFields();
        SimpleCacheResponse  cacheResponse=new SimpleCacheResponse(headers,cacheRequest);
        cacheResponses.put(uri,cacheResponse);
        return cacheRequest;
    }
}
