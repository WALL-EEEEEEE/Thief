
package modules.test.EventListen;

import modules.common.Event;
import modules.common.EventListener;

        /**
         * Description: 测试观察者模式
         * @author    : duanduan
         * @date      : 2016-02-25
         *
         */


public class  TestEvent1{



    /**
     * Description:测试入口
     */
    public static void main(String[] args){

        EventListener listener = new EventListener();


        Event       event1 = new Event(listener);
        Event       event2 = new Event(listener);


        listener.Attach(event1);
        listener.Attach(event2);
        listener.SetState("事件xxx发生了!");

        listener.Notify();

        System.out.println("事件通知后!");
        System.out.println(event1.GetState());
        System.out.println(event2.GetState());


    }




}
