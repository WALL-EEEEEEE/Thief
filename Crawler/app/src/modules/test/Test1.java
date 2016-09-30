package modules.test;

public class Test1{

    public LogMessage lm ;
    public Test1(){
        lm = new LogMessage();
        lm.Message = "hello";

    }
    public static void main(String args[]){

        Test1 t1 = new Test1();
        System.out.println(t1.lm);


    }


}


class  LogMessage{
    protected String Message ;

    public String toString(){

        return Message;

    }


}
