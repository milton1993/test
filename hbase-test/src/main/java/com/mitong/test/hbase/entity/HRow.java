package com.mitong.test.hbase.entity;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 16-1-21
 * @description
 */
public class HRow {
    private String rowKey;

    private List<HCell> cells;

    public String getRowKey() {
        return rowKey;
    }

    public void setRowKey(String rowKey) {
        this.rowKey = rowKey;
    }

    public List<HCell> getCells() {
        return cells;
    }

    public void setCells(List<HCell> cells) {
        this.cells = cells;
    }

    public HRow(String rowKey) {
        this.rowKey = rowKey;
    }

    public HRow(String rowKey, List<HCell> cells) {
        this.rowKey = rowKey;
        this.cells = cells;
    }

    public HRow addOneCell(HCell cell) {
        if (cells == null) {
            cells = Lists.newArrayList();
        }
        cells.add(cell);
        return this;
    }
}
