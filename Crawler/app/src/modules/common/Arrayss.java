package  modules.common;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import modules.DebugTools.Debug;


public  class Arrayss {

   /* 去除字符串前后的相同字符串*/
    public static  String[] trim(String[] array,String trimmedstr){

                String reg ="^\\"+trimmedstr+"*((?:[^\\"+trimmedstr+"]*).*?(?:[^\\"+trimmedstr+"]*))"+trimmedstr+"*$";


                Pattern trim_p = Pattern.compile(reg);
                Arrays.setAll(array,(i)->{

                    if(trimmedstr == " "){

                        return array[i].trim();
                    }else{
                        Matcher trim_m =trim_p.matcher(array[i]);

                        if(trim_m.matches()){

                           return trim_m.group(1);

                        }else{

                            return array[i];

                        }
                    }


                });

                return array;

    }

    /*去除字符串前后的不同字符串*/
    public  static String[] trim(String[] array, String pre_trimmedstr,String suf_trimmedstr){


          String reg ="^"+pre_trimmedstr+"*((?>[^"+pre_trimmedstr+"]*).*?(?>[^"+suf_trimmedstr+"]*))"+suf_trimmedstr+"*$";
          Pattern trim_p = Pattern.compile(reg);

          Arrays.setAll(array,(i)->{

              //去掉相关字符

              if(pre_trimmedstr.equals(" ")&&suf_trimmedstr.equals(" ")){

                      return array[i].trim();

              }else{

                  Matcher trim_m = trim_p.matcher(array[i]);

                     if(trim_m.matches()){

                          return trim_m.group(1);

                      }else{

                          return array[i];

                      }

             }


          });


          return array;
    }

    /***
     * Description: 移除指定数组中的元素
     * @param String[] src   源数组
     * @param int      index 要删除的元素索引值
     * @param String[] dest  操作后的新数组
     *
     */

    public static String[] remove(String[] src,int index){

        int length      = src.length;
        String[] dest   = new String[length-1];


        for(int i = 0;i<length;i++){

               //考虑数组的边界问题
               int j = (i<index)?i:i-1;

               if(i != index){


                    dest[j] = src[i];


                }

       }

        return dest;
    }

    /***
     * Description: 移除指定数组中和指定字符串相等的字符串
     * @param String[] src  源数组
     * @param String equalString  要移除的字符串
     * @param String[]     返回的新数组
     */
    public static String[] remove(String[] src,String equalString){

        int length = src.length;
        String[] dest       = new String[length-1];

        for(int i = 0;i<length;i++){

            if(!src[i].equals(equalString)){

                dest[i] = src[i];

            }

        }

        return dest;

    }

    /**
     * Description: 去掉字符串数组中的字符串为空的元素,去除的字符串包含任意一个(制表符或空格符或者换行符或者回车符或者空字符)
     * @param   String[]  srcArray 要去除元素的源数组
     *
     */
    public static String[] trimEmpty(String[] srcArray){


        String[] destArray  =  null;
        String regex = "[\\s|\\u0000]*";

        if(srcArray.length!=0){


            for(int i = 0;i<srcArray.length;i++){



                if(srcArray[i].matches(regex)){

                    srcArray = remove(srcArray,i);

                }

            }


        }

        destArray = srcArray;


        return destArray;
    }


    //测试
    public static class Main{


       public static void main(){


                String[] str = new String[]{

                    ",,,,,,,h,,,,,elo,,,,,,,,",
                    ",,,,,,world,,,,,,,,",
                    " "
                };





        }

    }
}

