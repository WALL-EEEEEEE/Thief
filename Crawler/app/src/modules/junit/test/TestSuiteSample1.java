import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;


public class TestSuiteSample1{

    public static Test suite(){

        TestSuite suite = new TestSuite("Test for defualt package");
        suite.addTestSuite(TestSample1.class);
        suite.addTestSuite(TestSample2.class);
        return suite;

    }

    public static void main(String[] args){

         TestRunner.run( suite());
    }
}


