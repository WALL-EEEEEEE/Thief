package com.ai92.cooljunit;

import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runner.JUnitCore;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.*;

public class RunWithTest{

    private static String log;
    public static class ExampleRunner extends Runner{

        public ExampleRunner(Class<?> klass){

             log+="initialize";

        }

        @Override
        public void run(RunNotifier notifier){

             log+="run";
        }
        @Override
        public Description getDescription(){

            log+="plan";
            return Description.createSuiteDescription("example");

        }

    }

    @RunWith(ExampleRunner.class)
    public static class ExampleTest{

    }



    @Test public void run(){
        log = "";
        JUnitCore.runClasses(ExampleTest.class);
        assertTrue(log.contains("plan"));
        assertTrue(log.contains("initialize"));
        assertTrue(log.contains("run"));

    }

}
