public class TestListener{

    public static void main(String[] args){

        MailSource ms = new MailSource();

        ms.addMailListener(new MailListener(){

            @Override
            public void doEvent(MailEvent event){

                System.out.println("doEvent");

            }
        }
        );

        ms.notifyMailEvent();
    }


    }


