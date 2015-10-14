package com.mitong.test.factory;

import com.mitong.test.service.UserService;
import com.mitong.test.service.bean.UserServiceBean;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15/8/2
 */
public class ServiceFactory {
    public static UserService getUserService() {
        return new UserServiceBean();
    }
}
