
import java.util.EventObject;


public class MailEvent extends EventObject{

    Object obj;

    public MailEvent(Object source){

        super(source);
        obj = source;

    }


    /**
     *
     */
    private static final long serialVersionUID = -1L;
    @Override
    public Object getSource(){

        return obj;


    }


}
