package com.mitong.test.hbase;

import com.mitong.test.hbase.entity.HCell;
import com.mitong.test.hbase.entity.HRow;
import com.mitong.test.hbase.exception.TableAlreadyExistsException;
import com.mitong.test.hbase.exception.TableNotYetExistsException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import java.io.IOException;
import java.util.List;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 16-1-21
 * @description
 */
public class HBaseClient {
    private Configuration configuration;

    private HTable hTable;

    private HBaseAdmin hBaseAdmin;

    public HBaseClient(String zookeeperAddress) throws IOException {
        this.configuration = HBaseConfiguration.create();
        this.configuration.set("hbase.zookeeper.quorum", zookeeperAddress);
        this.hBaseAdmin = new HBaseAdmin(this.configuration);
    }

    @Deprecated
    public HBaseClient(Configuration configuration) throws IOException {
        this.configuration = configuration;
        this.hBaseAdmin = new HBaseAdmin(this.configuration);
    }

    public boolean createTable(String tableName, String[] columnFamilyNames)
            throws IOException, TableAlreadyExistsException {
        if (this.hBaseAdmin.tableExists(tableName)) {
            throw new TableAlreadyExistsException("The table name: " + tableName + " already exists in HBase!");
        } else {
            HTableDescriptor tableDesc = new HTableDescriptor(TableName.valueOf(Bytes.toBytes(tableName)));
            for (int i = 0; i < columnFamilyNames.length; i++) {
                tableDesc.addFamily(new HColumnDescriptor(columnFamilyNames[i]));
            }
            hBaseAdmin.createTable(tableDesc);
            return true;
        }
    }

    public boolean putOneRow(String tableName, HRow row) throws IOException, TableNotYetExistsException {
        if (! this.hBaseAdmin.tableExists(tableName)) {
            throw new TableNotYetExistsException("The table name: " + tableName + " already exists in HBase!");
        } else {
            try {
                hTable = new HTable(this.configuration, tableName);
                if (row != null) {
                    Put put = new Put(Bytes.toBytes(row.getRowKey()));
                    List<HCell> cells = row.getCells();
                    if (cells != null) {
                        for (HCell cell : cells) {
                            Long ts = cell.getTs();
                            if (ts == null) {
                                put.add(Bytes.toBytes(cell.getFamily()), Bytes.toBytes(cell.getQualifier()),
                                        cell.getValue());
                            } else {
                                put.add(Bytes.toBytes(cell.getFamily()), Bytes.toBytes(cell.getQualifier()), ts,
                                        cell.getValue());
                            }
                        }
                    }
                    hTable.put(put);
                    return true;
                }
            } finally {
                if (hTable != null) {
                    hTable.close();
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException, TableAlreadyExistsException, TableNotYetExistsException {
        new HBaseClient("127.0.0.1").putOneRow("aaa",
                new HRow("row-2").addOneCell(new HCell("cf1", "ddd", Bytes.toBytes("123")))
                        .addOneCell(new HCell("cf2", "bbb", Bytes.toBytes("333"))));
    }
}
