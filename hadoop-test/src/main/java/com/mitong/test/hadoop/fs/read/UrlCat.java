package com.mitong.test.hadoop.fs.read;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-11-30
 */
public class UrlCat {
    static {
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
    }

    public static void main(String[] args) {
        InputStream inputStream = null;
        try {
            inputStream = new URL("hdfs://localhost:9000/user/wordcount").openStream();
            IOUtils.copyBytes(inputStream, System.out, 4096, false);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            org.apache.hadoop.io.IOUtils.closeStream(inputStream);
        }
    }
}
