package com.mitong.test.hadoop.fs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-11-30
 */
public class ListFileStatusOfDirectory {
    public static void main(String[] args) throws IOException {
        String directoryPath = "hdfs://localhost:9000/user";
        Configuration conf = new Configuration();
        FileSystem fileSystem = FileSystem.get(URI.create(directoryPath), conf);
        FileStatus[] statuses = fileSystem.listStatus(new Path(directoryPath));
        for (FileStatus status : statuses) {
            ShowFileStatus.printInfo(status);
        }
    }
}
