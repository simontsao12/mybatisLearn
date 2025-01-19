package com.atsimoncc.mybatis.test;
import com.atsimoncc.mybatis.pojo.User;
import com.atsimoncc.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.atsimoncc.mybatis.mapper.UserMapper;
/**
 * ClassName: MyBatisTest
 * Package: com.atsimoncc.mybatis.test
 * Description:
 */
public class MyBatisTest {

    @Test
    public void testInsert() throws IOException {
        // 獲取核心配置文件的輸入流
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        // 獲取 SqlSessionFactoryBuilder 物件
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 獲取 SqlSession 物件
        SqlSessionFactory factory = builder.build(is);
        // 獲取SQL的會話物件(不會自動提交) 是 MyBatis 提供的操作資料庫的物件
        // SqlSession session = factory.openSession();
        // 以下會自動提交
        SqlSession session = factory.openSession(true);

        /* -- 這段為 MyBatis 的介面導向設計 -- */
        // 獲取 UserMapper 的代理實現類物件 此種方式建立的 sql session 要自己管理交易(不會自動提交)
        UserMapper mapper = session.getMapper(UserMapper.class);
        // 呼叫 mapper 介面中的方法 實現新增用戶訊息的功能
        int result = mapper.insertUser();
        /*----------------------------*/

        /* 其他方式(使用較少): 提供 sql 及唯一標示找到 sql 並執行, 唯一標示是 namespace.sqlId */
        // int result = session.insert("com.atsimoncc.mybatis.mapper.UserMapper.insertUser");
        /* -------------------------------*/

        System.out.println("結果: " + result);
        // 提交(可在獲取會話物件時就設定自動提交)
        // session.commit();
        // 會話是一個過程 當前 sql 執行完後關閉
        session.close();
    }

    @Test
    public void testUpdate() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updateUser();
        sqlSession.close();
    }

    @Test
    public void testDelete() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser();
        sqlSession.close();
    }

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById();
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.getAllUsers();
        list.forEach(System.out::println);
        sqlSession.close();
    }
}
