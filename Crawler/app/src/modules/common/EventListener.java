package modules.common;
import java.util.List;
import java.util.ArrayList;


    /**
     *  Description 事件监听器,对事件行为进行监听
     *  @author: duanduan
     *  @date  : 2016-02-24
     *
     */

public abstract class EventListener implements Listener{


    public String EventListenerState = "";
    /**
     *Description: 被监听事件列表
     */
    private List<Event> EventLists = new ArrayList<Event>();
    /**
     *Description: 无参数构造函数
     *
     */
    public EventListener(){


    }

    /**
     *Decription: 传入事件构建特定的事件监听器
     *
     *@param Participant event 传入的特定的时间
     *
     */
    public EventListener(Event event){

        this.Attach(event);

    }



    /**
     *Decription: 添加监听事件到队列中
     *
     * @param Participant event  监听事件
     *
     */

    public void Attach(Event event){

        EventLists.add(event);

    }

    /**
     * Description:从队列中去除监听事件
     * @param Event event 监听事件
     */
    public void Dettach(Event event){

        if(EventLists.contains(event)){

            EventLists.remove(event);

        }
    }

    /**
     * Description:通知所有的事件
     */

    public void Notify(){

        for(Participant event:EventLists){


            event.Update();


        }



    }


    /**
     * Description: 获取事件监听器的状态
     * @return String State 事件监听器状态
     */
   public String  GetState(){

       return this.EventListenerState;
   }

   /**
    * Description: 设置事件监听器的状态
    *
    * @param String State 事件监听器的状态
    *
    */

   public void SetState(String State){


       this.EventListenerState = State;
   }
}


