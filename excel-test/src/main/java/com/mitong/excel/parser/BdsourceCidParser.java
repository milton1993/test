package com.mitong.excel.parser;

import jxl.Sheet;
import jxl.Workbook;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-11-13
 */
public class BdsourceCidParser {

    public static Map<String, String> getBdsourceAndCid(Workbook workbook) {
        Map<String, String> result = new HashMap<String, String>();
        Sheet sheet = workbook.getSheet(0);
        for (int i = 2; i < sheet.getRows(); i++) {
            System.out.println(sheet.getCell(1, i).getContents());
            System.out.println(sheet.getCell(2, i).getContents());
            String name = sheet.getCell(1, i).getContents().toLowerCase();
            String downloadUrl = sheet.getCell(2, i).getContents();
            String cid = getCidFromDownloadUrl(downloadUrl);
            if (! "".equals(cid)) {
                result.put(name, cid);
            }
        }
        return result;
    }

    private static String getCidFromDownloadUrl(String url) {
        String fileName = url.substring(url.lastIndexOf("/") + 1, url.lastIndexOf("apk") - 1);
        String[] split = fileName.split("_");
        for (String tmp : split) {
            if (tmp.startsWith("C") && tmp.length() == 5) {
                return tmp;
            }
        }
        return "";
    }
}
