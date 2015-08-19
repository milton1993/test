package com.mitong.test.dao.bean;

import com.mitong.test.dao.UserDao;
import com.mitong.test.model.User;
import com.mitong.test.utils.JDBCUtils;
import com.mitong.test.utils.MD5;

import java.util.List;
import java.util.Map;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15/8/2
 */
public class UserDaoBean implements UserDao {
    private static final JDBCUtils JDBC_UTILS = new JDBCUtils("com.mysql.jdbc.Driver",
            "jdbc:mysql://localhost:3306/user_manage","root","mysql");
    public User userLogin(String username, String password) {
        List<Map<String, Object>> result =
                JDBC_UTILS.executeQuery("select * from user where username='" + username + "'");
        if(result != null && result.size() == 1) {
            Map<String, Object> record = result.get(0);
            String passwordFromDatabase = (String)record.get("password");
            String passwordUserInput = MD5.GetMD5Code(password);
            if(passwordFromDatabase.equals(passwordUserInput)) {
                return User.getBuilder().
                        buildUsername(username).
                        buildPassword(passwordUserInput).
                        buildIsadmin((Integer)record.get("isadmin")).build();
            }
        }
        return null;
    }
}
