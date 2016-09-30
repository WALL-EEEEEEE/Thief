import junit.framework.TestCase;


public class TestCaculator1 extends TestCase{

    public void testAdd(){

        TestCaculator tcalculator = new TestCaculator();
        double result = tcalculator.add(1,2);
        assertEquals(3,result,0);

    }

}


