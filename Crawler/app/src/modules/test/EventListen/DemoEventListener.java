package modules.test.EventListen;

import java.util.EventListener;
/**
 * DemoEvent事件监听器接口
 */

interface DemoEventListener extends EventListener{


    public void processEvent(DemoEvent demoEvent);

}
