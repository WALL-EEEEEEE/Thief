import junit.framework.TestSuite;
import junit.framework.Test;
import junit.textui.TestRunner;


public class TestAll extends TestSuite{


    public static Test suite(){

        TestSuite suite = new TestSuite("TestSuite Test");
        suite.addTestSuite(TestCaculator1.class);
        suite.addTestSuite(TestCaculator2.class);

        return suite;
    }

    public static void main(String args[]){

        TestRunner.run(suite());
    }
}
