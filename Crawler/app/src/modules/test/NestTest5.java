public class NestTest5{


     public static void main(String[] args){

         Outer04.Inner inner = new Outer04.Inner();//实例化

         inner.print();

     }





}


class Outer04{

     private static String name = "Hello 内部类";

     static class Inner{
          public void print(){

               System.out.println(" name= " + name );


          }


     }


}
