package modules.test.EventListen;
/**
 *
 * 第一个具体的事件监听器
 */

public class FirstEventListener implements DemoEventListener{


    @Override
    public void processEvent(DemoEvent demoEvent){

        System.out.println("First event listener process event...");

    }


}

