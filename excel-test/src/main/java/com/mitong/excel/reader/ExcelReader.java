package com.mitong.excel.reader;

import com.mitong.excel.util.Path;
import jxl.Workbook;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-11-13
 */
public class ExcelReader {
    public static Workbook readFile(String fileName) {
        Workbook result = null;
        try {
            InputStream inputStream = new FileInputStream(Path.getPath(fileName));
            result = Workbook.getWorkbook(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
