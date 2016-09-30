
import java.util.Scanner;

class Controller{


    public ICallBack callBackObject = null;//引用回调对象

    Scanner input = new Scanner(System.in);//读取命令行的输入
    public Controller(ICallBack obj){

        this.callBackObject  = obj;


    }

    public void Begin(){

        while(input.next() !=null){

            callBackObject.run();
        }

    }



}
