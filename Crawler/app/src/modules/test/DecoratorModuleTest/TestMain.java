public class TestMain{


    public static void main(String[] args){

        Component1 cp1 = new Component1();
        Decorator1 dt1 = new Decorator1(cp1);
        dt1.operator();


    }


}

