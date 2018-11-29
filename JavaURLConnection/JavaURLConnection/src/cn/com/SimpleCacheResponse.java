package cn.com;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CacheResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class SimpleCacheResponse  extends CacheResponse {
    Map<String,List<String>> headers;
    SimpleCacheRequest request;
    public SimpleCacheResponse(Map<String,List<String>> headers,SimpleCacheRequest request){
        this.headers=headers;
        this.request=request;
    }
    @Override
    public Map<String, List<String>> getHeaders() throws IOException {
        return this.headers;
    }
    @Override
    public InputStream getBody() throws IOException {
        return new ByteArrayInputStream(request.getData());
    }
}
