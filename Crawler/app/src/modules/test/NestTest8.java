public class NestTest8{

     public static void main(String[] args){

          new X().fun2();


     }




}


interface A{

     public void fun();

}



class B implements A{

    public void fun(){

         System.out.println("Hello 准备匿名类");

    }

}


class X{

     public void fun1(A a){

         a.fun();

     }

     public void fun2(){

          this.fun1(new B());

     }

}
