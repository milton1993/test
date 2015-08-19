package com.mitong.test.factory;

import com.mitong.test.dao.UserDao;
import com.mitong.test.dao.bean.UserDaoBean;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15/8/2
 */
public class DaoFactory {
    public static UserDao getUserDao() {
        return new UserDaoBean();
    }
}
