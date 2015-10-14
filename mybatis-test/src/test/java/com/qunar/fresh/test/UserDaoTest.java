package com.qunar.fresh.test;

import com.mitong.test.dao.impl.UserDaoImpl;
import com.mitong.test.dao.UserDao;
import com.mitong.test.model.User;
import org.junit.Test;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15/8/11
 */
public class UserDaoTest {
    private UserDao userDao = new UserDaoImpl();

    @Test
    public void testGetUserById() {
        User user = userDao.getUserById(1);
        System.out.println(user);
    }
}
