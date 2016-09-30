package modules.common;


public abstract class Event implements Participant{


    public EventListener elisten;
    /**
     * Description: 事件状态
     */
    public String EventState = "";


    /**
     *
     *
     */
    public Event(EventListener el){

        this.elisten = el;
    }

    /**
     * Description: 更新事件状态
     */
    @Override
    public void Update(){


        this.SetState();

    }

    /**
     * Description: 设置事件状态
     *
     */
    public void SetState(){

        this.EventState = this.elisten.GetState();

    }

    /**
     * Description: 获取事件状态
     * @return String State  返回事件状态
     */

    public String GetState(){

        return this.EventState;
    }

}

