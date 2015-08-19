package com.mitong.test.dao;

import com.mitong.test.model.User;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15/8/2
 */
public interface UserDao {
    User userLogin(String username, String password);
}
