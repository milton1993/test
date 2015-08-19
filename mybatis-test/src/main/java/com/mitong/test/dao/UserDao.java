package com.mitong.test.dao;

import com.mitong.test.model.User;

import java.util.List;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15/8/10
 */
public interface UserDao {
    void addUser(User user);
    void deleteUser(User user);
    void deleteUserById(int id);
    User getUserById(int id);
    void updateUser(User user);
    List<User> listUsers();
}
