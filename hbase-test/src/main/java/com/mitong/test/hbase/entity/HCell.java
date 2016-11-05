package com.mitong.test.hbase.entity;

import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.KeyValue;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 16-1-21
 * @description
 */
public class HCell {
    private String family;

    private String qualifier;

    private Long ts;

    private byte[] value;

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getQualifier() {
        return qualifier;
    }

    public void setQualifier(String qualifier) {
        this.qualifier = qualifier;
    }

    public byte[] getValue() {
        return value;
    }

    public void setValue(byte[] value) {
        this.value = value;
    }

    public Long getTs() {
        return ts;
    }

    public void setTs(Long ts) {
        this.ts = ts;
    }

    public HCell(String family, String qualifier, Long ts, byte[] value) {
        this.family = family;
        this.qualifier = qualifier;
        this.ts = ts;
        this.value = value;
    }

    public HCell(String family, String qualifier, byte[] value) {
        this.family = family;
        this.qualifier = qualifier;
        this.value = value;
    }

    public HCell(KeyValue keyValue) {
        keyValue.getFamilyArray();
    }
}
