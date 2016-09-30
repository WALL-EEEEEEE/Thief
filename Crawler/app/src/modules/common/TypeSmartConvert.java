package modules.common;

import java.util.List;
import java.util.Arrays;
import java.text.ParseException;
import java.text.NumberFormat;
import java.lang.Number;
import java.lang.IllegalArgumentException;
import java.util.Map;


public class TypeSmartConvert{






	//Array转List
       /* public static <T>  ArrayList<T> ArrayToList(T arr){*/


		//ArrayList<T> ls = (ArrayList<T>) Arrays.asList(arr);

		//return ls;


	//}



		public static <T>  List<T> ArrayToList(T[] arr){


			 return Arrays.asList(arr);

	}

        /**
         * Description:将键值对数组转换成Map格式
         * @param  String[] Keys 键数组
         * @param  String[] Values 值数组
         * @param  Map<String,String> 生成的Map
         *
         */
        public static void  GenMap(String[] Keys,String[] Values,Map<String,String> maps) throws IllegalArgumentException{


            if(Keys.length==0||Values.length==0||Values.length!=Keys.length){

                throw new IllegalArgumentException("键与值的个数相等,并且不能为空!");

            }

            //将键值对整合Map格式
            for(int i=0;i<Keys.length;i++){

                maps.put(Keys[i],Values[i]);
            }

        }



        /**
         * Description:格式化数字
         * @param  Number num 需要转换的数字
         * @param  int    integer 小数位保留的数字
         * @return  Number 格式化后的数字
         *
         */
        public static Number FormatNum(Number num,int Fraction){

            NumberFormat nf = NumberFormat.getInstance();
            Number  formattedNumber = 0;
            nf.setMaximumFractionDigits(Fraction);
            nf.setMinimumFractionDigits(Fraction);


        try{
                formattedNumber =  nf.parse(nf.format(num));
            }catch(ParseException pe){

                System.out.println("数据转换出错!");
                System.exit(0);

            }

            return formattedNumber;
        }












}
