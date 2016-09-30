

public class NestTest4{

    public static void main(String[] args){


    Outer03 out = new NestTest4().new Outer03(); //外部类实例
        Outer03.Inner inner = out.new Inner();//实例化内部类对象
        inner.print();


    }

    class Outer03{

         private String name = "Hello 内部类";
         class Inner{

             public void print(){

                  System.out.println("name="+name);

             }

         }

    }




}
