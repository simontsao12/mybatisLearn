package com.atsimoncc.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName: SqlSessionUtil
 * Package: com.atsimoncc.mybatis.utils
 * Description:
 */
public class SqlSessionUtil {
    public static SqlSession getSqlSession() {

        SqlSession sqlSession = null;

        try {
            // 獲取核心配置文件的輸入流
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            // 獲取 SqlSessionFactoryBuilder 物件
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            // 獲取SqlSessionFactory 物件
            SqlSessionFactory factory = sqlSessionFactoryBuilder.build(is);
            // 獲取 SQL 的會話物件(會自動提交) 是 MyBatis 提供的操作資料庫的物件
            sqlSession =  factory.openSession(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return sqlSession;
    }
}
