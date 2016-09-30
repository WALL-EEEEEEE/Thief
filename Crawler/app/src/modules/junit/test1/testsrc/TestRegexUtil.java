package com.ai92.cooljunit;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.ArrayList;
import java.lang.IndexOutOfBoundsException;


public class TestRegexUtil{

    @Test
    public void checkEmail(){

        assertEquals(true,RegexUtil.checkEmail("add.dd@sina.com"));

    }

    @Test(timeout=10)
    public void checkEmail1(){

        assertEquals(true,RegexUtil.checkEmail("add.dd@sina.com"));
    }

    @Test(expected=IndexOutOfBoundsException.class)
    public void empty(){

        new ArrayList<Object>().get(1);
    }

}

