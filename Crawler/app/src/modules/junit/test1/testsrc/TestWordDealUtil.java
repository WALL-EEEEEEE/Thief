package com.ai92.cooljunit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;

public class TestWordDealUtil{

    //测试wordFormat4DB正常运行的情况
    @Test public void wordFormat4DBNormal(){
        String target = "employeeInfo";
        String result = WordDealUtil.wordFormat4DB(target);

        assertEquals("employee_info",result);

    }

    //测试null时的处理情况
    @Test public void wordFormat4DBNull(){

        String target = null ;
        String result = WordDealUtil.wordFormat4DB(target);
        assertNull(result);




    }

    //测试空字符串的处理情况
    @Test public void wordFormat4DBEmpty(){
        String target = "";
        String result = WordDealUtil.wordFormat4DB(target);
        assertEquals("",result);

    }
    //测试当首字母大写时的情况
    @Test public void wordFormat4DBBegin(){
        String target = "EmployeeInfo";
        String result = WordDealUtil.wordFormat4DB(target);
        assertEquals("employee_info",result);

    }


    //测试当尾字幕为大写时的情况
    @Test public void wordFormat4DBEnd(){

            String target = "employeeInfoA";
            String result = WordDealUtil.wordFormat4DB(target);
            assertEquals("employee_info_a",result);


    }


    //测试多个相连的字母大写时的情况
     @Test public void wordFormat4DBTogether(){
          String target = "employeeAInfo";
          String result = WordDealUtil.wordFormat4DB(target);

          assertEquals("employee_a_info",result);

     }
}

