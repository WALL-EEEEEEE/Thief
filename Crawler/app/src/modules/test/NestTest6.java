public class NestTest6{


     public static void main(String[] args){

          new Outer05().fun();

     }


}


class Outer05{

     private static String name ="Hello 内部类";

     public void fun(){
         class Inner{
             public void print(){

                  System.out.println("name="+name);

             }

         }

          new Inner().print();

     }


}
