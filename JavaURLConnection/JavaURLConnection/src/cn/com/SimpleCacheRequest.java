package cn.com;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.CacheRequest;

public class SimpleCacheRequest extends CacheRequest {
    ByteArrayOutputStream out=new ByteArrayOutputStream();
    @Override
    public OutputStream getBody() throws IOException {
        return this.out;
    }

    @Override
    public void abort() {}

    public byte[] getData(){
        if(out.size()==0)
            return null;
        else
            return out.toByteArray();
    }
}
