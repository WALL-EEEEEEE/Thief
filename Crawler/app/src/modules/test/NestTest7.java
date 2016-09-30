public class NestTest7{


     public static void main(String[] args){

         new Outer06().fun(20);

     }



}

class Outer06{

     private static String name = "Hello 内部类";

     public void fun(final int temp){

          class Inner{

               public void print(){

                    System.out.println("temp="+temp);
                    System.out.println("name="+name);

               }

          }

          new Inner().print();
     }



}
