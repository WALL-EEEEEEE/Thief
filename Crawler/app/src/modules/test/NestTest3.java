
public class NestTest3{

    public static void main(String[] args){

        new  NestTest3().new Outer02().fun();






    }

    class Outer02{

         private String name = "Hello 内部类";

         public void fun(){

              new Inner02(this).print();

         }

         public String getName(){

              return this.name;

         }

    };


    class Inner02{

        private Outer02 out;

        public Inner02(Outer02 out){

            this.out = out;



        }

        public void print(){

             System.out.println("name = "+this.out.getName());

        }
    }

}
