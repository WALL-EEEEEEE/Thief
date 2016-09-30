import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Regex2{

    public static void main(String[] args){


            test_matcher12();


    }

    public static void test_matcher1(){

        Pattern p = Pattern.compile("(123)\\1");
        Matcher m = p.matcher("ad123def123123grr");
        System.out.println("模式(123)\\1");
        while(m.find()){

            System.out.println(m.group());

        }


    }


    public static void test_matcher2(){

        Pattern p = Pattern.compile("(?:123)123");
        Matcher m = p.matcher("ad123dfe123123grr");
        System.out.print("模式(?:123)123");
        while(m.find()){
            System.out.println(m.group());
        }

    }


    public static void test_matcher3(){

        Pattern p = Pattern.compile("(?i)(?u)say6");
        Matcher m = p.matcher("This is test say6 hello.\\n"+"Wello say6 \\nello?");
        System.out.println("參数为(?i)(?u)");
        while(m.find()){

            System.out.println(m.group());

        }



    }


    public static void test_matcher4(){
        Pattern  p = Pattern.compile("(?s).ello");
        Matcher  m = p.matcher("This is a test say hello.\\n"+"Wello say \\nello");
        System.out.println("参数为(?s)");
        while(m.find()){

            System.out.println(m.group());

        }


    }

    public static void test_matcher5(){

        Pattern  p = Pattern.compile("(?d)(?m).ello.$");
        Matcher  m = p.matcher("This is a test say hello.\n"+"Wello say \nello?");
        System.out.println("参数为(?d)");
        while(m.find()){

            System.out.println(m.group());

        }


    }

    public static void test_matcher6(){

        Pattern p = Pattern.compile("(?m).ello");
        Matcher m = p.matcher("This is a test say hello.\n"+"Wello say\nello");
        System.out.println("参数为(?m)");
        while(m.find()){

             System.out.println(m.group());
        }

    }


    public static void test_matcher7(){

        Pattern p = Pattern.compile("a(?=b)");
        Matcher m = p.matcher("aacdabaaeabdaBh");
        System.out.println("a(?=b)");
        while(m.find()){
           System.out.println(m.group()+":start"+m.start()+",end="+m.end());

        }

    }

    public static void test_matcher8(){

        Pattern p = Pattern.compile("a(?!b)");
        Matcher m = p.matcher("aacdabaaeabdaBh");
        System.out.println("a(?!b)");
        while(m.find()){

            System.out.println(m.group()+":start="+m.start()+",end="+m.end());

        }

    }

    public static void test_matcher9(){

        Pattern p = Pattern.compile("(?<=b)a");
        Matcher m = p.matcher("aacdabaaeabdaBh");
        System.out.println("(?<=b)a");
        while(m.find()){

             System.out.println( m.group()+":start="+m.start()+",end="+m.end());
        }

    }


    public static void test_matcher10(){

         Pattern p = Pattern.compile("(?<!b)a");
         Matcher m = p.matcher("aacdabaaeabdaBh");
         System.out.println("(?<!b)a");

         while(m.find()){
             System.out.println(m.group()+":start="+m.start()+",end="+m.end());

         }
    }


    public static void test_matcher11(){

        Pattern p = Pattern.compile("\\b(?>integer|insert|in)\\b");
        Matcher m = p.matcher("test integer and insert of in it");
        System.out.println("\\b(?>integer|insert|in)\\b");
        while(m.find()){

            System.out.println(m.group()+":start="+m.start()+",end="+m.end());

        }



    }


    public static void test_matcher12(){

        Pattern p = Pattern.compile("\\b(?>in|integer|insert)\\b");
        Matcher m = p.matcher("test integer and insert of in it");
        while(m.find()){

            System.out.println(m.group()+":start="+m.start()+",end="+m.end());

        }


    }
}











