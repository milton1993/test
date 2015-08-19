package com.mitong.test.utils;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.sql.*;
import java.util.List;
import java.util.Map;

public class JDBCUtils {

    /**
     * <p>
     * Title:Database
     * </p>
     * <p>
     * Description: 此工具类用于JDBC连接数据库操作的封装
     * </p>
     *
     * @author tong.mi
     * @version 2.5
     * @date 2015/08/02
     *
     * */
    private static final Logger LOGGER = LoggerFactory.getLogger(JDBCUtils.class);
    private Connection connection; // Connection类的一个对象
    private String driverPath; // 驱动器路径
    private String url; // 数据库url
    private String userName; // 数据库用户名
    private String userPassword; // 数据库密码
    private String poolDriverPath; // 连接池的驱动路径
    private String poolName; // 连接池的名称
    private boolean judgeLink; // 用于判断连接为直接连接还是池连接

    /**
     * 构造方法，用于对数据库直接连接进行参数设置
     *
     * @param d String 用于传入驱动类路径
     * 				   u String 用于传入数据库的url
     * 				   n String 用于传入进入数据库的用户名
     * 	 			   p String 用于传入进入数据库的密码
     * */
    public JDBCUtils(String d, String u, String n, String p) {
        this.driverPath = d;
        this.url = u;
        this.userName = n;
        this.userPassword = p;
        this.judgeLink = true;
    }

    /**
     * 构造方法，用于对数据库池连接进行参数设置
     *
     * @param d String 用于传入连接池驱动类路径
     *         p String 用于传入连接池的名称
     * */
    public JDBCUtils(String d, String p) {
        this.poolDriverPath = d;
        this.poolName = p;
        this.judgeLink = false;
    }

    /**
     * 驱动数据库，并建立连接
     * */
    private void drive() {
        try {
            if (this.judgeLink) {
                Class.forName(driverPath);// "com.mysql.jdbc.Driver"
                this.connection = DriverManager.getConnection(url, userName, userPassword);// "jdbc:mysql://localhost:3308/hotel""root""mysql"
            } else {
                Class.forName(poolDriverPath);
                this.connection = DriverManager.getConnection(poolName);
            }
        } catch (ClassNotFoundException e) {
            LOGGER.error("Driver class not found", e);
        } catch (SQLException e) {
            LOGGER.error("Connection to database failed", e);
        }
    }

    /**
     * 接收insert、update、delete语句用于数据库的update操作，并返回操作结果
     *
     * @param sql String 用于执行的SQL语句
     * @return boolean true 表示操作成功 false 表示操作失败
     * */
    public boolean executeUpdate(String sql) {
        drive();
        try {
            Statement statement = this.connection.createStatement();
            statement.executeUpdate(sql);
            statement.close();
            return true;
        } catch (SQLException e) {
            LOGGER.error("SQL exception when excuting update to database", e);
        } finally {
            close();
        }
        return false;
    }

    /**
     * 接收select语句用于数据库的查询操作（各个字段内容类型不一致），返回查询结果到List中
     *
     * @param sql String 用于执行的SQL语句
     * @return List<Map<String, Object>> 每个map存放一条记录，key为字段名，value为数据内容
     *         														 list中存放所有记录的map
     * */
    public List<Map<String, Object>> executeQuery(String sql) {
        Preconditions.checkNotNull(sql, "sql can't be a null value");
        Preconditions.checkArgument(sql.length()==0, "sql can't be an empty string");
        List<Map<String, Object>> resultList = null;
        drive();
        try {
            resultList = Lists.newArrayList();
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {
                Map<String, Object> resultMap = Maps.newHashMap();
                String k;
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    k = metaData.getColumnName(i + 1);
                    Object t = (Object)resultSet.getObject(i + 1);
                    resultMap.put(k, t);
                }
                resultList.add(resultMap);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            LOGGER.error("SQL exception occurred when executing query", e);
        } finally {
            close();
        }
        return resultList;
    }

    /**
     * 接收select语句用于数据库的查询操作（各个字段内容类型一致，均为泛型T），返回查询结果到List中
     *
     * @param sql String 用于执行的SQL语句
     * 			c Class 用于传入T的类型
     * @return List<Map<String, T>> 每个map存放一条记录，key为字段名，value为数据内容
     *         														 list中存放所有记录的map
     * */
    public <T extends Serializable> List<Map<String, T>> executeQuery(String sql, @SuppressWarnings("rawtypes") Class c) {
        List<Map<String, T>> resultList = null;
        drive();
        try {
            resultList = Lists.newArrayList();
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData metaData;
            metaData = resultSet.getMetaData();
            while (resultSet.next()) {
                Map<String, T> resultMap = Maps.newHashMap();
                String k;
                for (int i = 0; i < metaData.getColumnCount(); i++) {
                    k = metaData.getColumnName(i + 1);
                    @SuppressWarnings("unchecked")
                    T t = (T)resultSet.getObject(i + 1);
                    resultMap.put(k, t);
                }
                resultList.add(resultMap);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            LOGGER.error("SQL exception occurred when executing query", e);
        } finally {
            close();
        }
        return resultList;
    }

    /**
     * 接收查询语句，用于分页查询mysql数据库中的内容，其中，各个字段内容类型不一致
     *
     *  @param sql String 用于执行的SQL语句 page int 用于限制查询的数据的范围
     *                  itemNumPerPage int 每页的数据数量
     *  @return List<Map<String, Object>> 每个map存放一条记录，key为字段名，value为数据内容
     *         														 list中存放所有记录的map
     * */
    public List<Map<String, Object>> pageQueryInMysql(String sql, int page,
                                                      int itemNumPerPage) {
        List<Map<String, Object>> resultList = null;
        drive();
        try {
            resultList = Lists.newArrayList();
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql + " limit "
                    + (page * itemNumPerPage) + ", " + itemNumPerPage);
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {
                Map<String, Object> resultMap = null;
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    resultMap = Maps.newHashMap();
                    resultMap.put(metaData.getColumnName(i),
                            (Object) resultSet.getString(metaData.getColumnName(i)));
                }
                resultList.add(resultMap);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            LOGGER.error("SQL Exception when executing page query", e);
        } finally {
            close();
        }
        return resultList;
    }

    /**
     * 接收查询语句，用于分页查询mysql数据库中的内容，其中，各个字段内容类型一致，均为泛型T
     *
     *  @param sql String 用于执行的SQL语句 page int 用于限制查询的数据的范围
     *                  itemNumPerPage int 每页的数据数量
     *                  c Class 用于传入T的类型
     *  @return List<Map<String, T>> 每个map存放一条记录，key为字段名，value为数据内容
     *         														 list中存放所有记录的map
     * */
    @SuppressWarnings("unchecked")
    public <T extends Serializable> List<Map<String, T>> pageQueryInMysql(String sql, int page,
                                                                          int itemNumPerPage, @SuppressWarnings("rawtypes") Class c) {
        List<Map<String, T>> resultList = null;
        drive();
        try {
            resultList = Lists.newArrayList();
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql + " limit "
                    + (page * itemNumPerPage) + ", " + itemNumPerPage);
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {
                Map<String, T> resultMap = null;
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    resultMap = Maps.newHashMap();
                    resultMap.put(metaData.getColumnName(i),
                            (T) resultSet.getString(metaData.getColumnName(i)));
                }
                resultList.add(resultMap);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            LOGGER.error("SQL Exception when executing page query", e);
        } finally {
            close();
        }
        return resultList;
    }

    /**
     * 接收查询语句，用于分页查询Oracle数据库中的内容，其中，各个字段内容类型不一致
     *
     * @param tableName String 用于查询的数据库表的名称 page int 用于限制查询的数据的范围
     * 				   itemNumPerPage int 每页的数据数量
     * @return List<Map<String, Object>> 每个map存放一条记录，key为字段名，value为数据内容
     *         														 list中存放所有记录的map
     * */
    public List<Map<String, Object>> pageQueryInOracle(String tableName,
                                                       int page, int itemNumPerPage) {
        drive();
        List<Map<String, Object>> resultList = null;
        try {
            resultList = Lists.newArrayList();
            Statement statement = this.connection.createStatement();
            String temp = "select count(*) as cnt from " + tableName;
            ResultSet resultSet = statement.executeQuery(temp);
            resultSet.next();
            int count = resultSet.getInt("CNT");
            int all = page * itemNumPerPage;
            if (count < all) {
                // 最后一页的记录数 = （总记录数 % 每页显示记录数）
                itemNumPerPage = count % itemNumPerPage;
            }
            String sql = "select * from (" + " select code,idx,rownum as rn"
                    + " from " + tableName + " where rownum <= " + all
                    + " order by rownum desc)" + " where rownum <= "
                    + itemNumPerPage + " order by rn asc";
            resultSet = statement.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {
                Map<String, Object> resultMap = null;
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    resultMap = Maps.newHashMap();
                    String columnName = metaData.getColumnName(i);
                    resultMap.put(columnName, resultSet.getObject(columnName));
                }
                resultList.add(resultMap);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            LOGGER.error("SQL Exception occurred when executing page query", e);
        } finally {
            close();
        }
        return resultList;
    }

    /**
     * 接收查询语句，用于分页查询Oracle数据库中的内容，其中，各个字段内容类型一致，均为泛型T
     *
     * @param tableName String 用于查询的数据库表的名称 page int 用于限制查询的数据的范围
     * 				   itemNumPerPage int 每页的数据数量
     * 					c Class 用于传入泛型T的类型
     * @return List<Map<String, T>> 每个map存放一条记录，key为字段名，value为数据内容
     *         														 list中存放所有记录的map
     * */
    @SuppressWarnings("unchecked")
    public <T extends Serializable> List<Map<String, T>> pageQueryInOracle(String tableName,
                                                                           int page, int itemNumPerPage, @SuppressWarnings("rawtypes") Class c) {
        drive();
        List<Map<String, T>> resultList = null;
        try {
            resultList = Lists.newArrayList();
            Statement statement = this.connection.createStatement();
            String temp = "select count(*) as cnt from " + tableName;
            ResultSet resultSet = statement.executeQuery(temp);
            resultSet.next();
            int count = resultSet.getInt("CNT");
            int all = page * itemNumPerPage;
            if (count < all) {
                // 最后一页的记录数 = （总记录数 % 每页显示记录数）
                itemNumPerPage = count % itemNumPerPage;
            }
            String sql = "select * from (" + " select code,idx,rownum as rn"
                    + " from " + tableName + " where rownum <= " + all
                    + " order by rownum desc)" + " where rownum <= "
                    + itemNumPerPage + " order by rn asc";
            resultSet = statement.executeQuery(sql);
            ResultSetMetaData metaData = resultSet.getMetaData();
            while (resultSet.next()) {
                Map<String, T> resultMap = null;
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                    resultMap = Maps.newHashMap();
                    String columnName = metaData.getColumnName(i);
                    resultMap.put(columnName, (T) resultSet.getObject(columnName));
                }
                resultList.add(resultMap);
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            LOGGER.error("SQL exception occurred when executing page query", e);
        } finally {
            close();
        }
        return resultList;
    }

    /**
     * 用于执行事务，保证多个语句同时执行
     *
     * @param list List<String> 存放用于执行的所有SQL语句
     * @return boolean true 表示操作成功 false 表示操作失败
     * */
    public boolean executeTransaction(List<String> list) {
        drive();
        Statement statement = null;
        try {
            statement = this.connection.createStatement();
            this.connection.setAutoCommit(false);
            for (int i = 0; i < list.size(); i++) {
                statement.executeUpdate(list.get(i));
            }
            return true;
        } catch (SQLException e) {
            LOGGER.error("SQL exception occurred when executing transaction", e);
            try {
                this.connection.rollback();
            } catch (SQLException e1) {
                LOGGER.error("SQL exception occurred when rolling back transaction", e1);
            }
        } finally {
            try {
                this.connection.commit();
            } catch (SQLException e) {
                LOGGER.error("SQL exception occurred when committing transaction", e);
            }
            try {
                statement.close();
            } catch (SQLException e) {
                LOGGER.error("SQL exception occurred when closing statement", e);
            }
            close();
        }
        return false;
    }

    /**
     * 执行批量语句，用于多个语句的同时执行
     *
     * @param list List<String> 存放用于执行的所有SQL语句
     * @return boolean true 表示操作成功
     * 								  false 表示操作失败
     * */
    public boolean executeBatch(List<String> list) {
        drive();
        try {
            Statement stmt = this.connection.createStatement();
            for (int i = 0; i < list.size(); i++) {
                stmt.addBatch(list.get(i));
            }
            stmt.executeBatch();
            stmt.close();
            return true;
        } catch (SQLException e) {
            LOGGER.error("SQL exception occurred when executing batch", e);
        } finally {
            close();
        }
        return false;
    }

    /**
     * 此方法用于向数据库中存入图片
     *
     * @param filePath String 传入文件路径
     * 		   		   tableName String 传入要上传到的数据库表名
     * 		   		   firstColumnName String 传入第一个字段名称
     * 		   	       secondColumnName String 传入第二个字段，即用于存储图片的字段的名称
     * 		   		   firstColumnContent String 传入第一个字段应存入的内容
     * @return boolean true 表示图片储存成功
     * 								  false 表示图片储存失败
     * */
    public boolean saveImage(String filePath, String tableName,
                             String firstColumnName, String secondColumnName,
                             String firstColumnContent) {
        drive();
        boolean bSave = false;
        try {
            File f = new File(filePath);
            FileInputStream input = new FileInputStream(f);
            PreparedStatement pstmt = this.connection.prepareStatement("insert into "+ tableName
                    +" ("+ firstColumnName +", "+ secondColumnName +") values (?, ?)");
            pstmt.setString(1, firstColumnContent);
            pstmt.setBinaryStream(2, input, (int) f.length());
            bSave = pstmt.execute();
            pstmt.close();
            bSave = true;
        } catch (SQLException e) {
            LOGGER.error("SQL exception occurred when saving image", e);
        } catch (FileNotFoundException e) {
            LOGGER.error("File not found exception occurred when saving image", e);
        } finally {
            close();
        }
        return bSave;
    }

    /**
     * 此方法用于从Oracle数据库中读取图片并存储到本地硬盘中
     *
     * @param filePath String 传入要存储的图片在本地硬盘上的路径
     * 		   		   tableName String 传入图片所在的数据库中的表的名称
     * 		   		   firstColumnName String 传入第一个字段名称
     * 		 		   secondColumnName String 传入第二个字段，即用于存储图片的字段的名称
     * 				   firstColumnContent String 传入第一个字段里用于判断行的内容
     * @return boolean true 表示读取并存储成功
     * 								  false 表示读取并存储失败
     * */
    public boolean imageToFile(String filePath, String tableName,
                               String firstColumnName, String secondColumnName,
                               String firstColumnContent) {
        boolean bImage = false;
        drive();
        try {
            File f = new File(filePath);
            FileOutputStream output = new FileOutputStream(f);
            String sql = "select "+ secondColumnName +" from "+ tableName
                    +" where "+ firstColumnName +"=" + firstColumnContent;
            PreparedStatement pstmt = this.connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            byte[] b = new byte[1024];
            InputStream input = rs.getBinaryStream(secondColumnName);
            int len = 0;
            while((len = input.read(b))>0) {
                output.write(b, 0, len);
            }
            input.close();
            output.close();
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            LOGGER.error("SQL exception occurred when transferring image to file", e);
        } catch (IOException e) {
            LOGGER.error("IO exception occurred when transferring image to file", e);
        } finally {
            close();
        }
        return bImage;
    }

    /**
     * 关闭数据库
     * */
    private void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            LOGGER.error("SQL exception occurred when closing connection to database", e);
        }
    }
}

