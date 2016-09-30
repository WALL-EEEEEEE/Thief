import junit.framework.*;

public class TestSuiteSample2{

    public static void main(String[] args){

        System.out.println("myTest1");
        myTest1();
        System.out.println("myTest2");
        myTest2();

    }

    public static void myTest1(){

        TestCase test = new TestClass2();
        TestResult result = new TestResult();
        result.addListener(new TestListener1());
        test.setName("test1");
        test.run(result);
        test.setName("test2");
        test.run(result);
    }


    public static void myTest2(){

        TestSuite suite = new TestSuite(TestClass2.class);
        TestResult result = new TestResult();
        result.addListener(new TestListener1());
        suite.run(result);
    }
}

