public class NestTest1{

     private static String name = "javaJohn";
     private String id ="X001";
     static class Person{

         private String address = "swjtu,chenDu,China";
         public String mail = "josserchai@yahoo.com"; //内部类的共有成员
         public void display(){
             System.out.println(name);
             System.out.println("Inner");


     }
     }

     public void printInfo(){

          Person person = new Person();
          person.display();
          System.out.println(person.address);
          System.out.println(person.mail);


     }

     public static void main(String[] args){

         NestTest1 ntest = new NestTest1();
         ntest.printInfo();


     }

}
