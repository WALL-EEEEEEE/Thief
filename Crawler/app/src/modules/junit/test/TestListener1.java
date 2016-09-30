import junit.framework.*;

public class TestListener1 implements TestListener{

    public void addError(Test test,Throwable b){

        System.out.println("Error:"+test);

    }

    public void addFailure(Test test,AssertionFailedError t){

        System.out.println("Failed:"+test+t);


    }

    public void endTest(Test test){

        System.out.println("EndTest:"+test);
    }

    public void startTest(Test test){

        System.out.println("StartTest:"+test);

    }

}
