package com.mitong.test.dao.impl;

import com.mitong.test.dao.UserDao;
import com.mitong.test.model.User;
import com.mitong.test.utils.MyBatisUtils;

import java.util.List;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15/8/10
 */
public class UserDaoImpl implements UserDao {
    private static MyBatisUtils MY_BATIS_UTILS;

    static {
        try {
            MY_BATIS_UTILS = MyBatisUtils.getMyBatisUtils();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addUser(User user) {

    }

    public void deleteUser(User user) {

    }

    public void deleteUserById(int id) {

    }

    public User getUserById(int id) {
        return MY_BATIS_UTILS.selectOne("user.getUser", 1);
    }

    public void updateUser(User user) {

    }

    public List<User> listUsers() {
        return null;
    }
}
