
//测试类

public class testMain{

    public static void main(String[] args){

        //使用普通功能类
        Target concreteTarget = new ConcreteTarget();
        concreteTarget.request();

        //使用特殊功能类,及适配类

        Target adapter = new Adapter();
        adapter.request();
    }

}
