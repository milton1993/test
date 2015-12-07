package com.mitong.excel.main;

import com.mitong.excel.dao.Dao;
import com.mitong.excel.parser.BdsourceCidParser;
import com.mitong.excel.reader.ExcelReader;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-11-13
 */
public class Main {
    public static void main(String[] args) {
        Dao.updateCid(BdsourceCidParser.getBdsourceAndCid(ExcelReader.readFile("bdsource_cid.xls")));
    }
}
