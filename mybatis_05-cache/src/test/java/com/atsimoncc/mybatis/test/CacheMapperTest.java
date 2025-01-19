package com.atsimoncc.mybatis.test;

import com.atsimoncc.mybatis.mapper.CacheMapper;
import com.atsimoncc.mybatis.pojo.Emp;
import com.atsimoncc.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * ClassName: CacheMapperTest
 * Package: PACKAGE_NAME
 * Description:
 */
public class CacheMapperTest {

    /**
     * MyBatis 的一級緩存(預設開啟):
     * MyBatis的一級緩存是 SqlSession 級別的
     * 即透過同一個 SqlSession 查詢的資料會被緩存
     * 再次使用同一個 SqlSession 查詢同一條資料會從緩存中獲取
     * 使一級緩存失效的四種情況:
     * 1. 不同的 SqlSession 對應不同的一級緩存
     * 2. 同一個 SqlSession 但是查詢條件不同
     * 3. 同一個 SqlSession 兩次查詢期間執行了任一次增刪改操作(因為會自動清空緩存)
     * 4. 同一個 SqlSession 兩次查詢期間手動清空了緩存
     *
     * MyBatis 的二級緩存:
     * MyBatis 的二級緩存是 SqlSessionFactory 級別的
     * 即透過同一個 SqlSessionFactory 所獲取的 SqlSession 物件查詢的資料會被緩存
     * 再透過同一個 SqlSessionFactory 所獲取的 SqlSession 物件查詢相同的資料會從緩存中獲取
     * MyBatis 的二級緩存開啟條件:
     * 1. 在核心配置文件中 設置全域屬性 cacheEnabled="true" 預設為 true 不需要設置
     * 2. 在映射文件中設置標籤 <cache/>
     * 3. 二級緩存必須在 SqlSession 關閉或者提交之後有效
     * 4. 查詢的資料所轉換的實體類類型必須實現序列化介面
     * 使二級緩存失效的一種情況:
     * 兩次查詢期間執行了任一次增刪改操作 會使一級和二級緩存同時失效
     *
     */
    @Test
    public void testGetEmpById() {
        SqlSession sqlSession1 = SqlSessionUtil.getSqlSession();
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpByEmpId(1);
        System.out.println(emp1);
        sqlSession1.clearCache(); // 手動清空緩存
        // mapper1.insertEmp(new Emp(null, "清清", 20, "女"));
        Emp emp2 = mapper1.getEmpByEmpId(1);
        System.out.println(emp2);
        /*SqlSession sqlSession2 = SqlSessionUtil.getSqlSession();
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp3 = mapper2.getEmpByEmpId(1);
        System.out.println(emp3);*/
    }
    @Test
    public void testCache() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp emp1 = mapper1.getEmpByEmpId(1);
        System.out.println(emp1);
        sqlSession1.close();
        SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
        CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
        Emp emp2 = mapper2.getEmpByEmpId(1);
        System.out.println(emp2);
        sqlSession2.close();
    }

}
