package com.mitong.excel.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Set;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15-11-13
 */
public class Dao {
    public static void updateCid(Map<String, String> nameAndCid) {
        Connection connection = null;
        Statement statement;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:50294/mobiledcs_channel?characterEncoding=utf-8", "mobstat", "xH!dmobstatsa!oSX");
            statement = connection.createStatement();
            Set<String> keySet = nameAndCid.keySet();
            for (String name : keySet) {
                statement.executeUpdate("UPDATE touch_bdsource SET cid='" + nameAndCid.get(name) + "' WHERE channelvalue='" + name + "'");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
