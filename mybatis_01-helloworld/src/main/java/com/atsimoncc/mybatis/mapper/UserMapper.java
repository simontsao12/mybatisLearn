package com.atsimoncc.mybatis.mapper;

import com.atsimoncc.mybatis.pojo.User;

import java.util.List;

/**
 * ClassName: UserMapper
 * Package: com.atsimoncc.mybatis.mapper
 * Description:
 */
public interface UserMapper {

    /**
     * 新增用戶
     */
    int insertUser();

    /**
     * 修改用戶
     */
    void updateUser();
    /**
     * 刪除用戶
     */
    void deleteUser();
    /**
     * 根據id查詢用戶
     */
    User getUserById();
    /**
     * 查詢全部用戶
     */
    List<User> getAllUsers();
}
