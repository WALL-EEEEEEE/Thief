package modules.test.EventListen;

import java.util.EventObject;




/**
  *
  * 事件对象的定义
  */

public class DemoEvent extends EventObject{

    private static final long serialVersionUID = 1L;

    public DemoEvent(Object source){

        super(source);

    }
}


