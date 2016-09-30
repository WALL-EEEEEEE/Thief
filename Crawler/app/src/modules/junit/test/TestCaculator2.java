
import junit.framework.TestCase;

public class TestCaculator2 extends TestCase{

    public void testAdd(){

         TestCaculator tcalcuator = new TestCaculator();
         double result  = tcalcuator.add(1,2);
         assertEquals(3,result,0);

    }

}
