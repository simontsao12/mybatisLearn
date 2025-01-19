package com.atsimoncc.mybatis.test;

import com.atsimoncc.mybatis.mapper.SelectMapper;
import com.atsimoncc.mybatis.pojo.User;
import com.atsimoncc.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * ClassName: SelectMapperTest
 * Package: com.atsimoncc.mybatis.test
 * Description:
 */
public class SelectMapperTest {

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void testGetAllUser() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        List<User> list = mapper.getAllUsers();
        list.forEach(System.out::println);
    }

    @Test
    public void testGetCount() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = mapper.getCount();
        System.out.println(count);
    }

    @Test
    public void testGetUserByIdToMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
        // Map<String, Object> map = mapper.getUserByIdToMap(1);
        // {password=123456, gender=男, id=1, age=20, email=123@cc.com, username=admin}
        Map<String, Object> map = mapper.getUserByIdToMap(3);
        // {password=123456, id=3, age=5, username=cc} null 不會有 key value
        System.out.println(map);
    }

    @Test
    public void testGetAllUserToMap() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);

        /**
         * [{password=123456, gender=男, id=1, age=20, email=123@cc.com, username=admin}, {password=123456, gender=女, id=2, age=33, email=456@cc.com, username=root}, {password=123456, id=3, age=5, username=cc}]
         */
        // List<Map<String, Object>> map = mapper.getAllUsersToMap();

        /**
         * {
         * 1={password=123456, gender=男, id=1, age=20, email=123@cc.com, username=admin},
         * 2={password=123456, gender=女, id=2, age=33, email=456@cc.com, username=root},
         * 3={password=123456, id=3, age=5, username=cc}
         * }
         */
        Map<String, Object> map = mapper.getAllUsersToMap();
        System.out.println(map);
    }
}
