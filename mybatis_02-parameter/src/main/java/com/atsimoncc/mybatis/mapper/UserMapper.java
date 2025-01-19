package com.atsimoncc.mybatis.mapper;

import com.atsimoncc.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * ClassName: UserMapper
 * Package: com.atsimoncc.mybatis.mapper
 * Description:
 * MyBatis 獲取參數值的兩種方式: #{}和${}
 * #{} 的本質是佔位符賦值而 ${} 的本質是字串拼接
 * 1. 若 mapper 介面方法的參數為單一字面量類型
 * 此時可以通過 #{} 和 ${} 以任意的內容獲取參數值
 * 一定要注意 ${} 的單引號問題
 * 2. 若 mapper 介面方法的參數為多個字面量類型
 * 此時 MyBatis 會將參數放在 map 集合中 以兩種方式存資料
 * (1) 以 arg0, arg1, ... 為 key 以參數為 value
 * (2) 以 param1, param2, ...為 key 以參數為 value
 * 因此只需要透過 #{} 和 ${} 訪問 map 集合的 key 就可以獲取相對應的值
 * 一定要注意 ${} 的單引號問題
 * 3. 若 mapper 介面方法的參數為 map 集合類型的參數(從 2 推出可使用的方法)
 * 只需要透過 #{} 和 ${} 訪問 map 集合的 key 就可以獲取相對應的值
 * 一定要注意 ${} 的單引號問題
 * 4. 若若 mapper 介面方法的參數為實體類型的參數
 * 只需要透過 #{} 和 ${} 訪問實體類中的屬性名就可以獲得對應的屬性值
 * 一定要注意 ${} 的單引號問題
 * 5. 可以在 mapper 介面方法的參數上設定 @Param 注解
 * 此時 MyBatis 會將這些參數方在 map 中 以兩種方式儲存
 * (1) 以 @Param 注解的 value 屬性值為鍵 以參數值為值
 * (2) 以 param1, param2 ...為鍵 以參數值為值
 * 只需要透過 #{} 和 ${} 訪問 map 集合的 key 就可以獲取相對應的值
 * 一定要注意 ${} 的單引號問題
 */
public interface UserMapper {
    /**
     * 根據用戶名查詢用戶訊息
     */
    User getUserByUsername(String username);

    /**
     * 驗證登入
     */
    User checkLogin(String username, String password);

    /**
     * 驗證登入(以Map集合作為參數)
     */
    User checkLoginByMap(Map<String, Object> map);

    /**
     * 新增用戶
     */
    void insertUser(User user);

    /**
     * 驗證登入(使用 @Param 注解 稱為命名參數 可以設定參數的 key)
     */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);
}
