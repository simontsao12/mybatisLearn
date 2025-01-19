package com.atsimoncc.mybatis;

import com.atsimoncc.mybatis.mapper.EmpMapper;
import com.atsimoncc.mybatis.pojo.Emp;
import com.atsimoncc.mybatis.pojo.EmpExample;
import com.atsimoncc.mybatis.utils.SqlSessionUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * ClassName: PageTest
 * Package: com.atsimoncc.mybatis
 * Description:
 */
public class PageTest {
    /**
     * PageInfo{
     * pageNum=1, pageSize=4, size=4,
     * startRow=1, endRow=4, total=30, pages=8,
     * list=Page{count=true, pageNum=1, pageSize=4, startRow=0, endRow=4, total=30, pages=8, reasonable=false, pageSizeZero=false}
     * [
     * Emp{empId=1, empName='a', age=null, gender='null', deptId=null},
     * Emp{empId=2, empName='a', age=null, gender='null', deptId=null},
     * Emp{empId=3, empName='a', age=null, gender='null', deptId=null},
     * Emp{empId=4, empName='a', age=null, gender='null', deptId=null}
     * ],
     * prePage=0, nextPage=2,
     * isFirstPage=true, isLastPage=false,
     * hasPreviousPage=false, hasNextPage=true,
     * navigatePages=5, navigateFirstPage=1,
     * navigateLastPage=5, navigatepageNums=[1, 2, 3, 4, 5]
     * }
     */

    @Test
    public void testPage() {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        // 查詢功能之前開啟分頁功能
        // (當前頁碼, 每頁顯示幾條)
        Page<Object> page = PageHelper.startPage(1, 4);
        List<Emp> list = mapper.selectByExample(null);
        // 查詢功能之後可以獲取分頁相關的所有資料(PageInfo 物件中的資訊有包含 Page 物件的資訊)
        // PageInfo<Emp> pageInfo = new PageInfo<Emp>(list);
        // navigatePages: 導航分頁的頁碼數量
        PageInfo<Emp> pageInfo = new PageInfo<Emp>(list, 5);
        list.forEach(System.out::println);
        System.out.println(pageInfo);
    }

}
