public class MainInStaticClass{

    static class Main{

        static void main(){

            new MainInStaticClass().print();

        }

    }

    public static void main(String[] args){

        new MainInStaticClass().print();

    }

    public void print(){

        System.out.println("main in static inner class ");

    }

}


