package com.atsimoncc.mybatis.mapper;

import com.atsimoncc.mybatis.pojo.Dept;
import com.atsimoncc.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName: DeptMapper
 * Package: com.atsimoncc.mybatis.mapper
 * Description:
 */
public interface DeptMapper {

    /**
     * 透過分步查詢獲取員工以及所對應的部門訊息的第二步
     * @param deptId
     * @return
     */
    Dept getEmpAndDeptByStepTwo(@Param("deptId") Integer deptId);

    /**
     * 查詢部門以及部門中的員工訊息
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByDeptId(@Param("deptId") Integer deptId);

    /**
     * 透過分步查詢部門以及部門中的員工訊息的第一步
     * @param deptId
     * @return
     */
    Dept getDeptAndEmpByStepOne(@Param("deptId") Integer deptId);

}
