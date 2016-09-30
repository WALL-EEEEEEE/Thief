package com.ai92.cooljunit;

import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestWordDealUtilWithParam{

    private String expected;
    private String target;

    @Parameters
    public static Collection words(){

        return Arrays.asList(new Object[][]{
            {"employee_info","employeeInfo"},
            {null,null},
            {"",""},
            {"employee_info","EmployeeInfo"},
            {"employee_info_a","employeeInfoA"},
            {"employee_a_info","employeeAInfo"}

        });

    }

      /* 参数化测试必须的构造函数*/
       //@param expected 期望的测试结果,对应参数集中的第一个参数
       /*@param target   测试数据,对应参数集中的第二个参数*/

    public TestWordDealUtilWithParam(String expected,String target){
        this.expected = expected;
        this.target = target;

    }

       //测试将Java对象名称到数据库名称的转换
        @Test public void wordFormat4DB(){

            assertEquals(expected,WordDealUtil.wordFormat4DB(target));

        }
}
