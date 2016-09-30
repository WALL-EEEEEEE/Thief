
/* Debug:调试*/
package  modules.DebugTools;


import java.util.Map;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;

public class Debug{



	//处理unchecked警告
	@SuppressWarnings("unchecked")
	private static <T> T cast(Object obj){



		return (T) obj;


	}

	public static void  DumpMap(Map<? extends Object, ? extends Object> dmap){



		Iterator<Map.Entry<? extends Object,? extends Object>> it = cast(dmap.entrySet().iterator());

		System.out.printf("{ ");
		it.forEachRemaining(e->{ System.out.println("\""+e.getKey()+"=>\" "+e.getValue()+"\",");});
		System.out.printf("} ");


	}

	public static void DumpArray(Object[] arr){


        if(arr.length!=0){



            System.out.println(" { ");
            for( int i = 0 ;i< arr.length;i++){

                System.out.print("\t"+arr[i]);
                if(i != arr.length - 1){

                    System.out.println(",");

                }



            }
                System.out.println(" \n }");


    }

    }






/**调试输出List **/
    public static void DumpList(List<? extends Object> list){



		DumpArray(list.toArray());




	}



    /*测试正则表达式的匹配情况
     * Matcher m @传入需要输出的正则表达式匹配的信息的匹配器
     */
    public static void RegexInfo(Matcher m){

          //重置匹配器的位置
            System.out.println("Regex string:"+m.pattern()+";");

            System.out.println("Matcher Groups:"+m.groupCount()+";");
            System.out.println("Groups matches info:\n{");

            if(m.matches()){
                for(int i =0;i<=m.groupCount();i++){

                    System.out.println("\tMatchString:  "+m.group(i)+" ,start_position: "+m.start(i)+" ,end_position: "+m.end(i)+";");
                }
            }

            System.out.println("}");


    }






}
