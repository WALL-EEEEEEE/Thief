import junit.framework.TestCase;

public class MathTest extends TestCase{

    protected double fValue1;
    protected double fValue2;

    public MathTest(){

        super();
    }

    public MathTest(String testname){

        super(testname);
    }

    protected void setUp(){

        fValue1 = 2.0;
        fValue2 = 3.0;
    }

    public void testAdd(){

        double result = fValue1+fValue2;
        assertTrue(result==5.0);
    }


static class Main{

        public static void main1(
        ){

            TestCase  test = new MathTest("add"){

                public void runTest(){
                    testAdd();
                }
            };

            test.run();
        }

        public static void main2(){

            TestCase test = new MathTest("testAdd");
            test.run();

        }

    }

    public static void main(String[] args){

           System.out.println("test ...");
           MathTest.Main.main1();
           MathTest.Main.main2();

    }
}
