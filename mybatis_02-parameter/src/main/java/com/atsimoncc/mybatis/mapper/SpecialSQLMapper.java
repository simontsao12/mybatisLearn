package com.atsimoncc.mybatis.mapper;

import com.atsimoncc.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName: SpecialSQLMapper
 * Package: com.atsimoncc.mybatis.mapper
 * Description:
 */
public interface SpecialSQLMapper {

    /**
     * 根據用戶名進行模糊查詢
     */
    List<User> getUserByLike(@Param("name") String name);

    /**
     * 批量刪除
     */
    void deleteMoreUser(@Param("ids") String ids);

    /**
     * 動態設定表名 查詢用戶訊息
     */
    List<User> getUserList(@Param("tableName") String tableName);

    /**
     * 新增用戶並獲取自增的主鍵
     */
    void insertUser(User user);

}
