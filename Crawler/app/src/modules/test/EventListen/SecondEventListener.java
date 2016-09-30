package modules.test.EventListen;


/**
 * 第二个具体的事件监听器
 */
public class SecondEventListener implements DemoEventListener{

    @Override
    public void processEvent(DemoEvent demoEvent){


        System.out.println("Second event listener process event..");
    }




}
