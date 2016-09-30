import java.util.EventListener;

public interface MailListener extends EventListener{

    //此方法定义接受到MailEvent事件之后应该怎么办
    public void doEvent(MailEvent event);


}
