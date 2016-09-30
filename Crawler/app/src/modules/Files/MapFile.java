package modules.Files;
import  modules.Files.File;
import  static modules.common.TypeSmartConvert.*;
import  java.io.FileReader;
import  java.io.BufferedReader;
import  java.io.BufferedWriter;
import  java.io.FileWriter;
import  java.io.FileNotFoundException;
import  java.util.Map;
import  java.util.HashMap;
import  java.io.IOException;
import  java.util.regex.Matcher;
import  java.util.regex.Pattern;
import  java.util.Map.Entry;


        /**
         * @author      : duanduan
         * date         : 2016-02-21
         * superclass   : @see modules.Files.FileDecorator
         * description  : 读取一对一的简单的键值对文件(value<=>value),例如有文件名为bian.txt(其中文件内容为"name@@bian***sex:man")
         *
         * MapFile 格式规范:
         *
         *         1. 一行只有一对键值 (形如"key value",像"key value value2"等是不可以的)
         *
         *         2. 键于值之间必须要有空格隔开(形如"keyvalue"是不行的)
         *         3. 键值前可以有任意个空格字符(形如"\s\s\s\s...key value")
         *         4. 键值后面可以有任意个空格字符(形如"key values \s\s\s\s")
         *         5. 键值行和键值行使可以允许又空行
         *
         *         6. 支持中文
         * mark:其中的@为键于值之间的的分割符#为两个键值之间的分割符
         */

public class MapFile extends FileDecorator {
        /**
         * <title>Field List:</title>
         *
         *       <title>Fields inherits from SuperClass</title>
         *
         *              FileDecorator's Fields:
         *
         *                  protected @see modules.Files.File <span>mfile</span>
         *
         *              File's Fields:
         *                  protected @see java.io.File    <span>sfile</span>
         *
         * <title>Methods List:</title>
         *       <title>Methods inherit from  SuperClass</title>
         *              FileDecorator's Methods:
         *                  public  void  @see modules.Files.FileDecorator#WriteOperation()
         *                  public  void  @see modules.Files.FileDecorator#ReadOperation()
         */

        /**
         *
         * Decription:  保存从文件中解析出来的键值对
         *
         */
        private Map<String,String> MapReadValues = new HashMap<String,String>();

        /**
         *Decription:  键值对的个数
         *
         *
         */
        private int     MAP_VALUES_NUM;

        /**
         * 缓存文件内容
         */
        private String  FileContents="";

       /**
         *
         *Description: 检查格式正则字符串
         *
         */
        private String  PARSE_REGEX="(^\\s*?([\\w|\\u4E00-\\u9FBF]+)\\s+([\\w|\\u4E00-\\u9FBF]+)\\s*)|(?:^\\s*\\r*$)";

        /**
         *Decriptiion:  需要写入文件的键值对数据
         *
         */
        private Map<String,String> MapWriteValues = new HashMap<String,String>();

    /** Decription: 无参数构造函数
     */
        public MapFile(){

        }


     /** Decription: 构造函数
       * Method MapFile(File{@see modules.Files.File})
       * @param  @see modules.Files.File ifile
       **/


        public MapFile(File ifile){

            super(ifile);
        }



        /**
         *
         * Decription: 清空保存的文件内容
         *
         */
        public void ClearFileContents(){

            this.FileContents = null;

        }

        /**
         * Decription: 设置需要写入文件中的数据
         * @param  Map<String,String> MapValues 需要写入文件的数据
         */

        public  void setMapWriteValues(Map<String,String> MapValues){
            this.MapWriteValues = MapValues;


        }

        /**
         * Decription: 设置需要写入文件中的数据
         * @param String[] Keys 需要写入文件键
         * @param String[] Values 需要写入文件的值
         */


        public  void setMapWriteValues(String[] Keys,String[] Values){

            GenMap(Keys,Values,MapWriteValues);


        }

        /**
         * Decription:  <span>提取文件内容并将内容以字符串的形式存起来</span>
         * @param  java.io.File  文件
         * @param   boolean  IS_TEMP true缓存文件内容,false不缓存
         * @return String  返回保存了文件内容的字符串
         * @exception IOException @see java.io.IOException
         *
         *
         */

        private String  ExtractFileContents(java.io.File file,boolean IS_TEMP) throws IOException{

               FileReader   file_r = null;
               String   file_conts = "";
               String   tconts;


              try{

                    file_r   = new FileReader(file);
                  }catch(FileNotFoundException fe){

                    System.out.println("文件不存在!"+fe.getMessage());
                    System.exit(0);

                }

              BufferedReader file_br  = new BufferedReader(file_r);

                      //读取文件内容
               try{
                    while((tconts=file_br.readLine())!=null){

                        file_conts.join(file_conts,tconts);

                     }

                    if(file_conts.length()==0){

                            System.out.println("配置文件内容为空!请重新指定有效的配置文件!");
                            System.exit(0);



                    }
                    //将文件内容保存起来
                    if(IS_TEMP){

                        FileContents = file_conts;
                    }

              }catch(IOException ioe){

                System.out.println("文件读取错误!"+ioe.getMessage());
                System.exit(0);

           }finally{
               //释放相关资源
               if(file_br!=null){

                 try{
                    file_br.close();
                   }catch(IOException ioe){

                        throw new IOException("关闭文件失败!"+ioe.getMessage());


                   }


               }


                return file_conts;



       }
}

       /**
         * Decription:  判断文件是否是MapFile格式
         * @return  boolean            如果文件是MapFile格式的文件,就返回true,如果不是就返回false
         *
         *
         */
        private boolean isMapFile(){

            boolean  flag = false;

            try{

                flag  = isMapFile(mfile.sfile);
            }catch(IOException ioe){

                System.out.println("判断"+mfile.getFileName()+"文件是否是Map文件失败!");
                System.exit(0);

            }


            return flag;


        }
        /**
         * Decription:  判断文件是否是MapFile格式
         * @param   @see(java.io.File) file_handle
         * @return  boolean       如果文件是MapFile格式的文件,就返回true,如果不是就返回false
         *
         *
         */

        public boolean isMapFile(java.io.File file) throws IOException{

               String   file_conts  = "";
               //解析文件
               if(FileContents!=null)
               {
                    file_conts = FileContents;
               }else{

                   try{

                       file_conts = ExtractFileContents(file,true);
                   }catch(IOException ioe){

                       System.out.println("读取"+mfile.getFileName()+"失败");
                       System.exit(0);

                   }
               }




               return isMapString(file_conts);




        }


        /**
         * Decription: 判断字符串中是否是Map_Value格式
         *
         * @param String MapString 键值对字符串
         * @return boolean         如果返回值为true,说明符合,反之不符合
         *
         *
         */
        public boolean isMapString(String MapString){

            boolean check_flag = true;
            //分割键值字符串

            String[] lines = MapString.split("\\r");

            if(lines.length==0){

                return false;

            }else{

                //一行一行的解析字符串
                for( int i =0;i<=lines.length;i++){

                      //正则匹配字符串
                      if(!lines[i].matches(PARSE_REGEX))

                            check_flag= false;

                    }
                }

            return check_flag;
            }




        /**
         * Description: 对MapFile文件进行读取解析操作,以及对解析的文件的信息的提取
         *
         *
         */
        @Override
        protected void Read(){


            //读取解析MapFile文件
            try{

            String FileContents = ExtractFileContents(this.mfile.sfile,true);
            }catch(IOException ioe){

                System.out.println("读取"+mfile.getFileName()+"内容失败");
                System.exit(0);

            }
            MapReadValues =  parseValues(FileContents);

            //提取MapReadValues的相关信息
            this.MAP_VALUES_NUM = MapReadValues.size();

        }


        /**
         * 从指定文件中读取MapValues到指定的Maps
         * @param java.io.File file  指定的文件
         * @param Map<String,String> maps 指定的Map
         * @param boolean  true读取成功,false读取失败
         *
         *
         */
        public boolean Read(java.io.File file,Map<String,String> maps){

            String FileContents = null;
            try{

                FileContents = ExtractFileContents(file,false);

            }catch(IOException ioe ){

                System.out.println("读取"+mfile.getFileName());
                System.exit(0);

            }
            maps  = parseValues(FileContents);


            return true;

        }

       /**
         * 从指定字符串中读取MapValues到指定的Maps
         * @param String MapValuesString 指定的文件
         * @param Map<String,String> maps 指定的Map
         * @param boolean  true读取成功,false读取失败
         *
         *
         */

        public boolean Read(String MapValuesString,Map<String,String> maps){

            maps = parseValues(MapValuesString);

            return true;


        }
        /**
         *
         * Decription:写入MapValue文件
         *
         */
        public void  Write(){

            if(MapWriteValues.size()==0){

                System.out.println("写入的内容不能为空!");
                System.exit(0);
            }

            Write(MapWriteValues,this.mfile.sfile);



        }


        /**
         *
         * Decription: 写入MapValue文件
         * @param  String[] Keys  提供写入Map文件中的键信息
         * @param  String[] Values 提供写入Map文件中的值信息
         * @param  java.io.File file  写入文件的文件名
         * @return boolean      如果返回true,就是写入成功,返回false,就是写入失败
         *
         */
        public boolean Write(String[] Keys,String[] Values,java.io.File file){

            if(file==null){

                System.out.println("文件参数错误!");

                return false;
            }
            Map<String,String> maps = new HashMap<String,String>();

            GenMap(Keys,Values,maps);

            return Write(maps,file);


        }

        /**
         * Decription:写入MapValue文件
         * @param  Map<String,String> 提供写入文件的键值信息
         * @param  java.io.File file  提供需要写入的文件
         *
         */
        public boolean Write(Map<String,String> maps,java.io.File file){


            if(maps.size()==0){

                System.out.println("Map 不能为空!");
                return false;

            }

            BufferedWriter  file_br = null;



          try{

                file_br = new BufferedWriter(new FileWriter(file));


                for(Entry me:maps.entrySet()){

                    String temp = me.getKey()+" "+me.getValue();

                    try{
                        file_br.write(temp);
                    }catch(IOException ioe){
                        System.out.println(mfile.getFileName()+"写入失败");
                        System.exit(0);

                    }

                }



               }catch(FileNotFoundException fe){

                System.out.println(file.getAbsolutePath()+"文件不存在!"+fe.getMessage());
                System.exit(0);
            }catch(IOException ioe){


                System.out.println(file.getAbsolutePath()+"文件写入出错!"+ioe.getMessage());
                System.exit(0);

            }finally{

                if(file_br!=null){

                    try{

                        file_br.close();
                    }catch(IOException ioe){

                        System.out.println("关闭"+file.getAbsoluteFile()+"异常");
                        System.exit(0);
                    }
                }

                return true;
            }




        }


        /**
         * Decription:写入MapValue文件
         * @param  Map<Object,Object> 提供写入文件的键值信息
         * @param  String filename  提供需要写入的文件名
         * @param  boolean FLAG_CREATE  如果文件不存在的话是否新建文件,true新建,false不新建
         *
         * @return boolean  true写入成功,false写入失败
         *
         */
        public boolean Write(Map<String,String> maps,String filename,boolean FLAG_CREATE) {

            java.io.File  file =  new java.io.File(filename);

            if(!file.exists()){

                if(FLAG_CREATE){

                    try{

                        file.createNewFile();
                    }catch(IOException ioe){

                        System.out.println("新建"+file.getAbsoluteFile()+"失败");
                        System.exit(0);
                    }

                }else{

                    System.out.println(file.getAbsoluteFile()+"文件不存在!");
                    return false;

                }




            }
          return    Write(maps,file);


        }

        /**
         * Decription:写入MapValue文件
         * @param  String Keys  提供写入Map文件中的键信息
         * @param  String Values 提供写入Map文件中的值信息
         * @param  String filename  提供需要写入的文件名
         * @param  boolean FLAG_CREATE 当FLAG_CREATE=true时,文件不存在的话就重建,否则不重建
         * @return boolean true写入成功,false写入失败
         *
         */
        public boolean Write(String Keys[],String Values[],String filename,boolean FLAG_CREATE){

            if(filename==null){

                System.out.println("文件参数错误!");

                return false;
            }
            Map<String,String> maps = new HashMap<String,String>();

            GenMap(Keys,Values,maps);


            Write(maps,filename,FLAG_CREATE);

            return true;

        }

        @Override
        /**
         * Decription:复写自其父类FileDecorator @see{modules.Files.FileDecorator}读取文档前对文档的先行处理,例如:对文档格式进行判断
         * Method  ReadAfterOperation()
         *
         *
         *
         *
         *
         */
        protected void ReadBeforeOperation(){

                if(!isMapFile()){

                        System.out.println(mfile.getFileName()+"格式不正确");
                        System.exit(0);

            }

        }


        /**
         * Description:  从字符串中解析出键值对
         * @param String FileContents  键值对字符串
         * @return Map<String,String>  返回解析的键值对
         *
         *
         */
        public  Map<String,String> parseValues(String MapReadValuesString){

            Map<String,String>  map_values = new HashMap<String,String>();
            if(FileContents.length()==0){

                return null;

            }

            String   regex = "";
            Pattern  pattern = Pattern.compile(regex);

            //一行一行的匹配
            String[] lineContents = FileContents.split("\\r");

            for(int i = 0;i<lineContents.length;i++){


                Matcher matcher = pattern.matcher(lineContents[i]);
                if(matcher.matches()){

                    map_values.put(matcher.group(1),matcher.group(2));


                }




            }

            return map_values;


        }


        @Override
        protected void ReadAfterOperation(){

            //清空读取文件内容缓存
            this.ClearFileContents();
        }

        @Override
        protected void WriteAfterOperation(){
            //清空写入数据缓存
            this.MapWriteValues = null;
        }

        @Override
        protected void WriteBeforeOperation(){ }

}

