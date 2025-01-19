package com.atsimoncc.mybatis;

import com.atsimoncc.mybatis.mapper.EmpMapper;
import com.atsimoncc.mybatis.pojo.Emp;
import com.atsimoncc.mybatis.pojo.EmpExample;
import com.atsimoncc.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
/**
 * ClassName: MBGTest
 * Package: com.atsimoncc.mybatis
 * Description:
 */
public class MBGTest {

    @Test
    public void testMBG() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        // 根據 id 查詢數據
        // Emp emp = mapper.selectByPrimaryKey(1);
        // System.out.println(emp);

        // 查詢所有數據 沒有條件就是查詢所有
        // List<Emp> list = mapper.selectByExample(null);
        // list.forEach(System.out::println);

        // 根據條件查詢數據
        // EmpExample example = new EmpExample();
        // 奢華版使用 qbc(query by criteria) 方式 所以需要建立一個條件物件
        // example.createCriteria().andEmpNameEqualTo("張三").andAgeGreaterThanOrEqualTo(20);
        // example.or().andGenderEqualTo("男");
        // List<Emp> list = mapper.selectByExample(example);
        // list.forEach(System.out::println);

        Emp emp = new Emp(1, "小黑", null, "女");
        // 測試普通修改功能
        // mapper.updateByPrimaryKey(emp);
        // 測試選擇性修改
        mapper.updateByPrimaryKeySelective(emp);
    }

}