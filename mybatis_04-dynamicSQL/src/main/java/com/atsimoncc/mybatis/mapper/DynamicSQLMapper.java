package com.atsimoncc.mybatis.mapper;

import com.atsimoncc.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName: DynamicSQLMapper
 * Package: com.atsimoncc.mybatis.mapper
 * Description:
 */
public interface DynamicSQLMapper {

    /**
     * 根據條件查詢員工訊息
     * @param emp
     * @return
     */
    List<Emp> getEmpByCondition(Emp emp);

    /**
     * 使用 choose 查詢員工訊息
     * @param emp
     * @return
     */
    List<Emp> getEmpByChoose(Emp emp);

    /**
     * 批次新增員工訊息
     * @param emps
     */
    void insertMoretEmp(@Param("emps") List<Emp> emps);

    /**
     * 批次刪除員工訊息
     * @param empIds
     */
    void deletetMoretEmp(@Param("empIds") Integer[] empIds);

}
