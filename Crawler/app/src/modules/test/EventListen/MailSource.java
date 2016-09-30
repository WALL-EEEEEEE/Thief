import java.util.Enumeration;

import java.util.Vector;

public class MailSource{

    public Vector<MailListener> ve  = new Vector<MailListener>();

    MailListener mailListener;

    public void addMailListener(MailListener listener){

        ve.addElement(listener);
    }

    public void notifyMailEvent(){

        Enumeration en = ve.elements();

        while(en.hasMoreElements()){

            mailListener = (MailListener)en.nextElement();
            mailListener.doEvent(new MailEvent(this));
        }

    }


}
