package exception;

public class TestException{

    public TestException(){

    }

    boolean testEx() throws Exception{

        boolean ret = true;
        try{
            ret = testEx1();
            System.out.println("---test"+ret);
            return ret;
        }catch(Exception e){

            System.out.println("testEx,catch exception ");
            ret = false;
            throw e;
        }finally{

            System.out.println("testEx,finally;return value="+ret);
        }

    }

    boolean testEx1() throws Exception{

         boolean ret = true;

         try{
              ret = testEx2();
              if(!ret){

                   return false;

              }
              System.out.println("testEx1,at the end of try");
              return ret;
         }catch(Exception e){

               System.out.println("testEx1,catch exception");
               ret = false;
               throw e;
         }finally{

                System.out.println("testEx1 ,finally,return value="+ret);
         }

    }


    boolean testEx2() throws Exception{

        boolean ret = true;

        try{

             int b = 12;
             int c;
             for(int i=2;i>=-2;i--){

                 c= b/i;
                 System.out.println("i="+i);
             }

             System.out.println("hello");
             return true;

        }catch(Exception e){
             System.out.println("testEx2,catch excepiton ");
             ret = false;
             e.printStackTrace();
             throw new Exception("test");

        }finally{

            System.out.println("testEx2,finally;return value= "+ret);

        }
    }


    public static void main(String[] args){

        TestException testException1 = new TestException();
        try{

             testException1.testEx();
        }catch(Exception e){

             e.printStackTrace();
        }

    }
}
