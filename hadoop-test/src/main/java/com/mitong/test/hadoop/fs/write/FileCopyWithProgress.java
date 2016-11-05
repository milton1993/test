package com.mitong.test.hadoop.fs.write;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;

import java.io.*;
import java.net.URI;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-11-30
 */
public class FileCopyWithProgress {
    public static void main(String[] args) throws IOException {
        String localSrc = "/home/milton/todo";
        String dest = "hdfs://localhost:9000/user/writetest";
        InputStream in = new BufferedInputStream(new FileInputStream(localSrc));
        Configuration conf = new Configuration();
        FileSystem fileSystem = FileSystem.get(URI.create(dest), conf);
        OutputStream out = fileSystem.create(new Path(dest), new Progressable() {
            @Override
            public void progress() {
                System.out.print(".");
            }
        });
        IOUtils.copyBytes(in, out, 4096, true);
    }
}
