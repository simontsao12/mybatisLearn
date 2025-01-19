package com.atsimoncc.mybatis.mapper;

import com.atsimoncc.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName: EmpMapper
 * Package: com.atsimoncc.mybatis.mapper
 * Description:
 */
public interface EmpMapper {

    /**
     * 根據 id 查詢員工訊息
     * @param empId
     * @return
     */
    Emp getEmpByEmpId(@Param("empId") Integer empId);

    /**
     * 獲取員工以及所對應的部門訊息
     * @param empId
     * @return
     */
    Emp getEmpAndDeptByEmpId(@Param("empId") Integer empId);

    /**
     * 透過分步查詢獲取員工以及所對應的部門訊息的第一步
     * @param empId
     * @return
     */
    Emp getEmpAndDeptByStepOne(@Param("empId") Integer empId);

    /**
     * 透過分步查詢部門以及部門中的員工訊息的第二步
     * @param deptId
     * @return
     */
    List<Emp> getDeptAndEmpByStepTwo(@Param("deptId") Integer deptId);
}
