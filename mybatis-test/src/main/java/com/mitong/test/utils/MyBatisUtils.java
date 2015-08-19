package com.mitong.test.utils;

import com.google.common.base.Preconditions;
import com.mitong.test.dao.UserDao;
import com.mitong.test.dao.impl.UserDaoImpl;
import com.mitong.test.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.*;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 15/8/10
 */

public class MyBatisUtils {
    private String resource;
    private SqlSessionFactory sessionFactory;
    private SqlSession sqlSession;
    private static MyBatisUtils myBatisUtils;
    private static final String DEFAULT_CONF_PATH = "/config.xml";

    private MyBatisUtils(String resource) throws Exception {
        Preconditions.checkArgument(resource!=null && !resource.isEmpty());
        this.resource = resource;
        init();
    }

    private MyBatisUtils() throws Exception {
        this.resource = DEFAULT_CONF_PATH;
        init();
    }

    public static MyBatisUtils getMyBatisUtils(String resource) throws Exception {
        myBatisUtils = new MyBatisUtils(resource);
        return myBatisUtils;
    }

    public static MyBatisUtils getMyBatisUtils() throws Exception {
        myBatisUtils = new MyBatisUtils();
        return myBatisUtils;
    }

    private void init() throws IOException {
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        sqlSession = sessionFactory.openSession();
    }

    public <T extends Serializable> T selectOne(String statement, Object parameter) {
        return sqlSession.selectOne(statement, parameter);
    }


}
