package modules.test.EventListen;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * 定义事件源
 */

public class EventSource{

    private List<DemoEventListener> listeners = new ArrayList<DemoEventListener>();

    public EventSource(){

    }

    public void addDemoListener(DemoEventListener demoListener){

        listeners.add(demoListener);
    }

    public void notifyDemoEvent(){

        for(DemoEventListener eventListener:listeners){

            DemoEvent demoEvent = new DemoEvent(this);
            eventListener.processEvent(demoEvent);

        }
    }

}
