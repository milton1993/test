package com.mitong.test.service;

import com.mitong.test.model.User;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15/8/2
 */
public interface UserService {
    User userLogin(String username, String password);
}
