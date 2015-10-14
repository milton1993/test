package com.mitong.test.service.bean;

import com.google.common.base.Preconditions;
import com.mitong.test.dao.UserDao;
import com.mitong.test.factory.DaoFactory;
import com.mitong.test.model.User;
import com.mitong.test.service.UserService;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15/8/2
 */
public class UserServiceBean implements UserService {
    private static final UserDao USER_DAO = DaoFactory.getUserDao();
    public User userLogin(String username, String password) {
        Preconditions.checkNotNull(username, "username can't be a null value");
        Preconditions.checkNotNull(password, "password can't be a null value");
        return USER_DAO.userLogin(username, password);
    }
}
