import junit.framework.TestCase;

public class TestSample2 extends TestCase{


        protected   TestClass1 c = new TestClass1();

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

