package com.ai92.cooljunit;
import java.util.Arrays;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;



@RunWith(Parameterized.class)
public class TestWithParam{
    @Parameterized.Parameters
    public static List<Object[]> data(){

        return Arrays.asList(new Object[][]{

            {0,0},{1,1},{2,1},{3,2},{4,3},{5,5},{6,8},{10,55}

        });

    }

    private int fInput;
    private int fExpected;
    public  TestWithParam(int input,int expected){

        fInput = input ;
        fExpected = expected;

    }
    @Test
    public void test(){

         assertEquals(fExpected,Fibonacci.compute(fInput));
    }

    private static class Fibonacci{

        public static int compute(int input){

             if(input==0){

                 return 0;

             }else if(input == 1){

                  return 1;
             }else if(input==2){

                  return 1;
             }else
                 return compute(input -1) + compute(input -2);
        }
    }



}

