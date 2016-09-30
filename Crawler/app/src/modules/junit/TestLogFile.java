package modules.junit;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import modules.Files.LogFile;
import modules.Files.Log;
import modules.Files.File;
import java.io.IOException;




    /**
     * Description: 测试日志文件操作类
     * @author: duanduan
     * date   : 2016-02-29
     *
     */
public class TestLogFile{

    public String logfile = "log.txt";
    public String logfile2 = "log2.txt";
    public String logfile3 = "log3.txt";
    public String logfile4 = "log4.txt";
    public String logfile5 = "log5.txt";
    public String logfile6 = "log6.txt";
    public String logfile7 = "log7.txt";
    public String logfile8 = "log8.txt";
    public String logfile9 = "log9.txt";
    public String logfile10 = "log10.txt";
    public String logfile11 = "log11.txt";
    public String logfile12 = "log12.txt";
    public Log lf;
    @Before
    public void  intialize(){


    }


    @After
    public void free(){

        if(lf !=null){

            lf = null;
        }

    }


    /**
     * Description:测试日志文件操作类中LogMessage
     */
    @Test
    public void TestLogMessage() throws IOException{
        //初始化资源
        lf = new Log(new LogFile(logfile){},false);


        lf.LogMessage("test Log1",1);
        lf.LogMessage("test Log1",1);
        lf.LogMessage("test Log1",1);

        lf.LogMessage("",1);
        lf.LogMessage("",2);
        lf.LogMessage("",3);

        lf.close();

    }


    @Test
    public void TestLogMessage2() throws IOException{

        lf = new Log(new LogFile(logfile2){

        },true);
        lf.LogMessage("test Log2",2);
        lf.LogMessage("test Log2",2);
        lf.LogMessage("test Log2",2);

        lf.LogMessage("",1);
        lf.LogMessage("",2);
        lf.LogMessage("",3);

        lf.close();



    }

    @Test
    public void TestLogMessage3() throws IOException{

        lf = new Log(new LogFile(logfile3){

        },true);

        for(int i =0;i<=101;i++){

            lf.LogMessage("test Log3",i);

        }

        lf.close();



    }

    @Test
    public void TestLogMessage4() throws IOException {
             lf = new Log(new LogFile(logfile4){

                },true);

        lf.LogMessage("test Log1",1);
        lf.LogMessage("test Log1",1);
        lf.LogMessage("test Log1",1);

        lf.LogMessage("",1);
        lf.LogMessage("",2);
        lf.LogMessage("",3);

        lf.LogMessage("test Log2",2);
        lf.LogMessage("test Log2",2);
        lf.LogMessage("test Log2",2);

        lf.LogMessage("",1);
        lf.LogMessage("",2);
        lf.LogMessage("",3);



        for(int i =0;i<=101;i++){

            lf.LogMessage("test Log3",i);

        }

        lf.close();





    }


    @Test

    public void Testfine() throws IOException {
        lf = new Log(new LogFile(logfile5){

                },true);

        lf.fine("test Log1");
        lf.fine("test Log1");
        lf.fine("test Log1");

        lf.fine("");
        lf.fine("");
        lf.fine("");

        lf.fine("test Log2");
        lf.fine("test Log2");
        lf.fine("test Log2");

        lf.fine("");
        lf.fine("");
        lf.fine("");



        for(int i =0;i<=101;i++){

            lf.fine("test Log3");

        }

        lf.close();



    }

    @Test
    public void TestFine2() throws IOException {
        lf = new Log(new LogFile(logfile6){

                },false);

        lf.fine("test Log1");
        lf.fine("test Log1");
        lf.fine("test Log1");

        lf.fine("");
        lf.fine("");
        lf.fine("");

        lf.fine("test Log2");
        lf.fine("test Log2");
        lf.fine("test Log2");

        lf.fine("");
        lf.fine("");
        lf.fine("");



        for(int i =0;i<=101;i++){

            lf.fine("test Log3");

        }

        lf.close();




    }


    @Test
    public void TestWarning() throws IOException {
        lf = new Log(new LogFile(logfile7){

                },false);

        lf.warnning("test Log1");
        lf.warnning("test Log1");
        lf.warnning("test Log1");

        lf.warnning("");
        lf.warnning("");
        lf.warnning("");

        lf.warnning("test Log2");
        lf.warnning("test Log2");
        lf.warnning("test Log2");

        lf.warnning("");
        lf.warnning("");
        lf.warnning("");



        for(int i =0;i<=101;i++){

            lf.warnning("test Log3");

        }

        lf.close();




    }


    @Test
    public void TestWarning2() throws IOException {
        lf = new Log(new LogFile(logfile8){

                },true);

        lf.warnning("test Log1");
        lf.warnning("test Log1");
        lf.warnning("test Log1");

        lf.warnning("");
        lf.warnning("");
        lf.warnning("");

        lf.warnning("test Log2");
        lf.warnning("test Log2");
        lf.warnning("test Log2");

        lf.warnning("");
        lf.warnning("");
        lf.warnning("");



        for(int i =0;i<=101;i++){

            lf.warnning("test Log3");

        }

        lf.close();




    }

    @Test
    public void TestThrowning() throws IOException {
        lf = new Log(new LogFile(logfile9){

                },true);

        lf.throwing("test Log1");
        lf.throwing("test Log1");
        lf.throwing("test Log1");

        lf.throwing("");
        lf.throwing("");
        lf.throwing("");

        lf.throwing("test Log2");
        lf.throwing("test Log2");
        lf.throwing("test Log2");

        lf.throwing("");
        lf.throwing("");
        lf.throwing("");



        for(int i =0;i<=101;i++){

            lf.throwing("test Log3");

        }

        lf.close();




    }


    @Test
    public void TestThrowing2() throws IOException {
        lf = new Log(new LogFile(logfile10){

                },false);

        lf.throwing("test Log1");
        lf.throwing("test Log1");
        lf.throwing("test Log1");

        lf.throwing("");
        lf.throwing("");
        lf.throwing("");

        lf.throwing("test Log2");
        lf.throwing("test Log2");
        lf.throwing("test Log2");

        lf.throwing("");
        lf.throwing("");
        lf.throwing("");



        for(int i =0;i<=101;i++){

            lf.throwing("test Log3");

        }

        lf.close();




    }


    @Test
    public void TestDateFormat() throws IOException{
        lf = new Log(new LogFile(logfile11){

                },false);

        lf.setLogTimeFormat("yyyy-MM-dd HH:mm:ss z");
        lf.throwing("test Log1");
        lf.throwing("test Log1");
        lf.throwing("test Log1");

        lf.throwing("");
        lf.throwing("");
        lf.throwing("");

        lf.throwing("test Log2");
        lf.throwing("test Log2");
        lf.throwing("test Log2");

        lf.throwing("");
        lf.throwing("");
        lf.throwing("");



        for(int i =0;i<=101;i++){

            lf.throwing("test Log3");

        }

        lf.close();




    }



    @Test
    public void TestSetCache() throws IOException{

        lf = new Log( new LogFile(logfile12));
        System.out.println(lf.IsCache());
        System.out.println(lf.setCache(false));

        System.out.println(lf.IsCache());



    }
}

