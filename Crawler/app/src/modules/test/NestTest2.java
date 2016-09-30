public class NestTest2{

     public static int outer_x = 100;
     public static class Inner{
         public int y = 10;
         private int z = 9;
         int     m  = 5;
         public static  void display(){

              System.out.println("display outer_x"+outer_x);


         }

         private void display2(){

              System.out.println("display outer_x:"+outer_x);

         }
     }

     void test(){
          Inner inner = new Inner();
          inner.display();
          inner.display2();
          //静态类访问
          Inner.display();

          System.out.println("Inner y:"+inner.y); //可以访问
          System.out.println("Inner z:"+inner.z);//可以访问
          System.out.println("Inner m:"+inner.m);
          InnerTwo innerTwo = new InnerTwo();
          innerTwo.show();




     }

     class InnerTwo{

         Inner innerx = new Inner();

         public void show(){

             innerx.display();
             innerx.display2();
             System.out.println(innerx.y);
             System.out.println(innerx.z);
             System.out.println(innerx.m);


         }

     }

     public static void main(String args[]){

         NestTest2 nt2= new NestTest2();
         nt2.test();



     }


}
