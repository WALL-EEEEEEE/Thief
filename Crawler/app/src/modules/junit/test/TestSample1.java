import junit.framework.TestCase;
import java.lang.Exception;

public class TestSample1 extends TestCase{

    TestClass1 c = new TestClass1();

    protected void setUp() throws Exception{

        c.setA(2);
        c.setB(1);
    }


    protected void tearDown() throws Exception{

         c = null;
    }

    public void testAdd(){
         int result = c.add();
         assertEquals(3,result,0);
    }

}
