package com.mitong.test.hadoop.fs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-11-30
 */
public class DeleteFile {
    public static void main(String[] args) throws IOException {
        String filePath = "hdfs://localhost:9000/user/writetest";
        Configuration conf = new Configuration();
        FileSystem fileSystem = FileSystem.get(URI.create(filePath), conf);
        fileSystem.delete(new Path(filePath), true);
    }
}
