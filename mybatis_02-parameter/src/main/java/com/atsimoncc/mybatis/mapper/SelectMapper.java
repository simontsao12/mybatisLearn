package com.atsimoncc.mybatis.mapper;

import com.atsimoncc.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * ClassName: SelectMapper
 * Package: com.atsimoncc.mybatis.mapper
 * Description:
 */
public interface SelectMapper {
    /**
     * 若 sql 語法查詢的結果為多條時 一定不能以實體類類型作為方法的返回值
     * 否則會有異常 TooManyResultException
     * 若 sql 語法查詢的結果為一條時 此時可以使用實體類類型或 list 集合類型作為方法的返回值
     */

    /**
     * 根據 id 查詢用戶
     */
    User getUserById(@Param("id") Integer id);
    /**
     * 查詢所有的用戶訊息
     */
    List<User> getAllUsers();

    /**
     * 查詢用戶的總數量
     */
    Integer getCount();

    /**
     * 根據 id 查詢用戶訊息為 map 集合
     */
    Map<String, Object> getUserByIdToMap(@Param("id") Integer id);

    /**
     * 查詢所有的用戶訊息為 map 集合
     * 若查詢的資料為多條時 並且要將每條資料轉換為 map 集合
     * 此時有兩種解決方案(1用的比較多)
     * 1. 將 mapper 介面方法的返回值設定為泛型為 map 的 list 集合
     * 結果:
     * [{password=123456, gender=男, id=1, age=20, email=123@cc.com, username=admin}, {password=123456, gender=女, id=2, age=33, email=456@cc.com, username=root}, {password=123456, id=3, age=5, username=cc}]
     * 2. 可以將每條資料轉換的 map 集合放在一個大的 map 中 但是必須透過 @MapKey 注解
     * 將查詢的某個資料表欄位值作為大的 map 的 key
     * @MapKey("id")
     * Map<String, Object> getAllUsersToMap();
     * 結果:
     * {
     * 1={password=123456, gender=男, id=1, age=20, email=123@cc.com, username=admin},
     * 2={password=123456, gender=女, id=2, age=33, email=456@cc.com, username=root},
     * 3={password=123456, id=3, age=5, username=cc}
     * }
     */
    // List<Map<String, Object>> getAllUsersToMap();
    @MapKey("id") // 將查詢出的 map 放在一個大的 map 需要 key 以 @MapKey 設置資料表的欄位為 key
    Map<String, Object> getAllUsersToMap();
}
