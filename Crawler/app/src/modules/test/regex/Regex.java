package modules.test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Regex{

    public static void main(String[] args){

        /*Pattern pattern = Pattern.compile("b*g");*/
        /*Matcher matcher = pattern.matcher("bbg");*/
        //System.out.println(matcher.matches());
        //System.out.println(pattern.matches("b*g","bbg"));
        ////验证邮政编码
        //System.out.println(pattern.matches("[0-9]{6}","200038"));
        //System.out.println("hello");
        /*System.out.println(pattern.matches("[0-9]{3,4}\\-?[0-9]+","021789898799"));*/
        //getDate("Nov 10,2009");
        //charReplace();
        //验证身份证:判断一个字符串是不是身份证号码,即是否是15或18位数字.
        //System.out.println(pattern.matches("^\\d{15}|\\d{18}$","1234567890098761"));

        //getString("D:/dir1/test.txt");
        //getChinese("welcome to china,江西奉新,welcome,你!");
        //validateEmail("luosijin123@163.com");
          //assert_test();
          //test_matcher();
          //test_matcher3();
            test_matcher4();
    }

            /* 日期提取:提取出月份来*/

    public static void getDate(String str){
          String regEx = "([a-zA-Z]+)|\\s+[0-9]{1,2},\\s*[0-9]{4}";
          Pattern pattern = Pattern.compile(regEx);
          Matcher matcher = pattern.matcher(str);

          if(!matcher.find()){

               System.out.println("日期格式错误!");
               return;

          }
          System.out.println(matcher.groupCount());
          System.out.println(matcher.group(1));//分组索引值从1开始的,所取第一分组的方法是m.group(1)而不是m.group(0).

          }

            /*字符替换:本实例为将一个字符串中的所有包含一个或
             * 多个连续的"a"的地方都替换成"A".*/
            public static void charReplace(){

                String regex = "a+";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher("okaaa LetmeAseeaaa aa booa");
                String  s = matcher.replaceAll("A");
                System.out.println(s);

            }


            /*字符串提取*/
            public static void getString(String str){

                String regex = ".+/(.+)$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(str);
                if(!matcher.find()){
                    System.out.println("文件路径格式不正确!");
                    return;

                }

                System.out.println(matcher.group(1));

            }


            /*中文提取*/
            public static void getChinese(String str){

                String regex = "[\\u4E00-\\u9FFF]+";//[//u4E00-//u9FFF]为汉字
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(str);
                StringBuffer  sb = new StringBuffer();
                while(matcher.find()){

                    sb.append(matcher.group());
                }
                System.out.println(sb);

            }

            /*验证Email*/
            public static void validateEmail(String email){

                String regex = "[0-9a-zA-Z]+@[0-9]+\\.[0-9a-zA-Z]+";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(email);
                if(matcher.matches()){

                    System.out.println("这是合法的Email");

                }else{

                    System.out.println("这是非法的Email");
                }


            }

            /*验证先行断言和后行断言*/
            public static void assert_test(){

                String regex1 = "^((?<!that).)*this((?<!that).)*$";
                String regex2 = "^(.(?!that))*this(.(?!that))*$";

                String regex3 ="^(.(?<!that))*this(.(?<!that))*$";
                String regex4 ="^(.(?<!that))*this((?!that).)*$";
                String regex5 ="^((?!that).)*this(.(?<!that))*$";
                String regex6 = "^((?!that).)*this((?!that).)*$";
                String match_str1 = "this is the case,not that";

                Pattern patter1 = Pattern.compile(regex1);
                Pattern patter2 = Pattern.compile(regex2);
                Pattern patter3 = Pattern.compile(regex3);
                Pattern patter4 = Pattern.compile(regex4);
                Pattern patter5 = Pattern.compile(regex5);
                Pattern patter6 = Pattern.compile(regex6);

                Matcher matcher1 = patter1.matcher(match_str1);
                Matcher matcher2 = patter2.matcher(match_str1);
                Matcher matcher3 = patter3.matcher(match_str1);
                Matcher matcher4 = patter4.matcher(match_str1);
                Matcher matcher5 = patter5.matcher(match_str1);
                Matcher matcher6 = patter6.matcher(match_str1);

                if(matcher3.matches()){

                    System.out.println("pattern1 匹配成功");


                }else{
                    System.out.println("patter1 匹配不成功!");
                }

                if(matcher4.matches()){

                    System.out.println("patter2 匹配成功!");

                }else{

                    System.out.println("pattern2 匹配不成功!");

                }




            }

            public static void test_matcher(){


                Pattern p = Pattern.compile("(\\d+)(?:\\.?)(?:\\d+)([￥$])$");
                String  str = "8899￥";
                Matcher m = p.matcher(str);
                if(m.matches()){

                    System.out.println("货币金额:"+m.group(1));
                    System.out.println("货币种类:"+m.group(2));
                }


            }

            public static void test_matcher1(){
                    Pattern  p = Pattern.compile("a(?=b)");
                    Matcher  m = p.matcher("aacabab");
                    while(m.find()){

                        System.out.println(m.group()+",start="+m.start()+",end="+m.end());

                    }

            }

            public static void test_matcher2(){

                   Pattern p = Pattern.compile("\\b(?>integer|insert|in)\\b");
                   String match_str = "insert";
                   Matcher m = p.matcher(match_str);

                   if(m.matches()){

                       System.out.println("匹配成功!");
                   }else{

                       System.out.println("匹配失败!");
                   }




            }

            public static void test_matcher3(){

                Pattern p = Pattern.compile("\\b(?>integer|insert|in)\\b");
                Matcher m = p.matcher("test integer and insert of in it");
                System.out.println("\\b(?>integer|insert|in)\\b");
                while(m.find()){

                    System.out.println(m.group()+":start="+m.start()+",end="+m.end());

                }



            }

            public static void test_matcher4(){

                Pattern p = Pattern.compile("\\b(?>in|integer|insert)\\b");
                Matcher m = p.matcher("test integer and insert of in it");

                System.out.println("\\b(?>in|integer|insert)\\b");

                while(m.find()){

                    System.out.println(m.group()+":start="+m.start()+",end="+m.end());

                }



            }
}

