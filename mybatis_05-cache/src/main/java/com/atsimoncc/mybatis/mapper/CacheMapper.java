package com.atsimoncc.mybatis.mapper;

import com.atsimoncc.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName: CacheMapper
 * Package: com.atsimoncc.mybatis.mapper
 * Description:
 */
public interface CacheMapper {

    /**
     * 根據員工 id 查詢員工訊息
     * @param empId
     * @return
     */
    Emp getEmpByEmpId(@Param("empId") Integer empId);

    /**
     * 新增員工訊息
     * @param emp
     */
    void insertEmp(Emp emp);

}
