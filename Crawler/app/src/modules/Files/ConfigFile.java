
package modules.Files;

import modules.Files.FileDecorator;
import modules.Files.FileFormatException;
import modules.Files.File;
import modules.DebugTools.Debug;
import modules.common.Arrayss;
import modules.configure.ConfigFileFormatException;
import modules.configure.ConfigParseMessage;
import java.io.IOException;
import java.io.FileReader;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.nio.CharBuffer;
import java.io.BufferedWriter;
import java.lang.StringBuffer;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Set;



/**
 * Description: 解析配置文件
 * referenceClass: @see modules.Files.FileDecorator
 *                 @see modules.Files.File
 *                 @see modules.configure.ConfigFileFormatException;
 *
 *
 * Details  :    该类是应用程序用来解析配置文件的,配置文件格式说明
 * 1.配置项是由配置项名和配置项值组成,
 *
 * 2.其中每个配置名对应一个或者多个配置项值
 *
 * 3.配置项名在一个配置项文件中只能允许一个,也就是说配置项名具有唯一性
 * 4.配置项名和配置项值之间有相应的分隔符，系统默认分隔符为'=',也可以自己通过setValueNameSymbol()方法进行设置
 *
 * 5.配置项值如果有多个的话就需要将配置项值用相应的配置项分组符包裹起来,默认的项目组分割符是'{}',也可以通过setValueGroupWrapperSymbol()方法进行设置,配置组中的配置值有相应的配置值分割符,默认的配置项分割符为',',也可以通过setGroupValueSperator()进行设置;
 *
 * 6.配置项名和(配置项值/配置项值组)组成一条配置项,配置项和配置项之间通过配置项分割符分割,默认的分割符为空,且配置项要各占一行,用户也可以通过setConfigSperatorSymbol()方法进行设置
 *
 * 7.配置文件要求有指定的后缀文件名,读取配置文件时会先行对配置文件后缀进行判断,如果配置文件后缀名和指定配置文件后缀名不符合,那么程序就不会将其当作配置文件处理,可以通过setConfFileSuffix()方法进行自定义设置,默认的配置文件后缀为.conf,如果指定文件以.conf为后缀,那么程序会直接抛出FileFormatException异常;
 *
 * 8.如果解析配置文件时发现不符合述格式要求,会抛出ConfigFileFormatException异常
 *
 * 9.当前类未进行多线程安全处理
 *
 * 10.分隔符前后都允许出现若干空格
 *
 * 11.配置项值可以用值包裹符包起来,默认的值包裹符是'“”',也可以通过setValueWrapperSymbol()方法进行设置,配置项值可以为空字符串
 *
 * 12.配置值中不能含有Pre_ValueGroupWrapperSymbol和Suff_ValueGroupWrapperSymbol相关字符,如果有程序将抛出ConfigFormatException异常
 *
 *
 *
 */


/*@TODO:进行多线程安全处理*/
/*@TODO:错误行不够精准*/
/*@TODO:配置项和组只能处于同一行,不能同时出现在其他行*/

public class ConfigFile extends FileDecorator{



    // 配置文件名
    private String Config_File_Name ;
    // 配置文件后缀,默认为"conf"
    private String ConfigFile_Suffix = "conf";
    //配置项名和配置项值之间的分隔符,默认为"="
    private String ValueNameSymbol   = "=";
    //配置项值组包裹符,默认为"{}"
    private  String Pre_ValueGroupWrapperSymbol = "\\{";
    private  String Suff_ValueGroupWrapperSymbol= "\\}";
    //配置项值包裹符,默认为"“ ”"
    private  String Pre_ValueWrapperSymbol = "\"";
    private  String Suff_ValueWrapperSymbol= "\"";
    //配置项组中值于值之间的分隔符,默认为","
    private  String GroupValueSperator = ",";

    //配置项之间的分隔符,默认是空
    private  String ConfigSperatorSymbol = "";

    private int    ConfigNums = 0 ;

    //当前文件的行号
    private int   CurLineNumber = 0;
    //当前错误行的概要
    private String CurErrorResume = "";

    private EX_MODE ex_mode   ;

    private ConfigParseMessage cfm;

    private static enum EX_MODE{

        FAILE_FAST(0),FAILE_DELAY(1);

        int ModeFlag;

        EX_MODE(int flag){

            this.ModeFlag = flag;
        }



    }


    private Map<String,List<String>> ConfigGroups = new HashMap<String,List<String>>();



    public ConfigFile(File ifile) throws ConfigFileFormatException{
        super(ifile);
        Config_File_Name = mfile.sfile.getName();
        //设置默认的异常处理模式,延迟处理
        ex_mode = EX_MODE.FAILE_DELAY;
        Read();
    }

    /**
     * Description: 获取配置文件名
     * @return String  当前的配置文件名
     */
    public String getConfigFileName(){


        return Config_File_Name ;
    }

    /**
     * Description: 获取配置文件的绝对路径文件名
     * @param String 当前配置文件的绝对路径
     */
    public String getAbsoluteConfigFileName(){

        return sfile.getAbsolutePath();

    }
    /**
     *
     * Descripton:
     *            检查文件是否是以Conf结尾的配置文件
     * @return boolean true 配置文件是以.conf结尾,false 配置文件不是以.conf结尾
     * */
    private boolean  isConf(){

            if(getSuffixName()!="conf"){

                return false;

            }

            return true;

    }

    /**
     * Description:
     *           设置配置文件的后缀名,如果配置文件不是以该配置文件的后缀名结尾的话,那么将不会别识别
     */
    public void setConfFileSuffix(String suffix){

         this.ConfigFile_Suffix = suffix;

    }
    /**
     * Description: 获取文件的后缀
     * @return String  文件后缀名
     */
    private String getSuffixName(){

            int last_point_index = Config_File_Name.lastIndexOf(".");

            return  Config_File_Name.substring(last_point_index,Config_File_Name.length());


    }



    /**
     * Description: 设置配置项值组的包裹符号,如果配置项值不是一个而是多个的话就由该包裹符号包裹起来
     * @param String wrapper 包裹符号
     */
    public void setValueGroupWrapperSymbol(String prewrap,String suffwrap){

        Pre_ValueGroupWrapperSymbol  = prewrap;
        Suff_ValueGroupWrapperSymbol = suffwrap;

    }


    /**
     * Description: 设置配置项之间的分隔符,单条配置项之间必须用该符号分隔开
     * @param     String separator
     *
     */

    public void setConfigSperatorSymbol(String sperator){

        ConfigSperatorSymbol =  sperator;

    }


    /**
     *
     * Description: 利用正则表达是解析配置文件字符串,如果配置文件字符串不符合相关格式,就抛出ConfigFileFormatException
     * @param String 配置文件字符串
     * @exception:  ConfigFileFormatException @see modules.Files.ConfigFileFormatException
     * @return Map<String,String> 解析完成后的配置项
     *
     *
     * */
    private Map<String,List<String>>ConfigParser(String[] configStrings) throws ConfigFileFormatException{


        /**
         * 用来解析配置文件的正则表达式[\u4E00-\u9FBF]是中文文字集的unicode码范围,\u0020是Space空格的unicode码
         *
         */

        //匹配配置项名的正则表达式
        String regex_vname  =  "^"+"\\s*"+"([\\w|\\u4E00-\\u9FBF]+)"+"\\s*"+ValueNameSymbol+"\\s*";
        //匹配配置项值的正则表达式
        String regex_v      =  Pre_ValueWrapperSymbol+"(?:[^"+Pre_ValueWrapperSymbol+Suff_ValueWrapperSymbol+"]*)"+Suff_ValueWrapperSymbol;
        //匹配配置项组的正则表达式
        String regex_vgroup =  Pre_ValueGroupWrapperSymbol+"\\s*"+"(?:"+"(?:"+regex_v+")"+"\\s*"+GroupValueSperator+"\\s*"+")*?"+"(?:"+regex_v+")"+"\\s*"+Suff_ValueGroupWrapperSymbol;
        //匹配单个配置项值的正则表达式
        String regex_sv     =  "\\s*"+regex_v;

        //验证配置格式的解析正则表达式,形如: name={"value1","value2",....} 或者name="value";
        String regex_check  = regex_vname+"(?:(?:"+regex_vgroup+")|(?:"+regex_sv+"))"+"\\s*"+"$";
        //提取配置项中的值的正则表达式
        String regex_extv= "\"([^"+Pre_ValueWrapperSymbol+Suff_ValueWrapperSymbol+"]*)\"";




        //存放解析后的配置项的键值对
        HashMap<String,List<String>> confMaps   =  new HashMap<String,List<String>>();

         configStrings = Arrayss.trimEmpty(configStrings);


        if(configStrings.length!=0){


            boolean  DELAY_FLAG = false;

            cfm = new ConfigParseMessage();
            //分别解析字符串
            for(int i=0;i<configStrings.length;i++){

                String conf = configStrings[i];

                //获取当前解析行
                CurLineNumber = i;

                List<String> values = new ArrayList<String>();
                String confName  = "";
                Pattern rc_p = Pattern.compile(regex_check);
                Matcher rc_m = rc_p.matcher(conf);




                if(rc_m.matches()){

                    Pattern ev_p = Pattern.compile(regex_extv);
                    Matcher ev_m = ev_p.matcher(conf);

                    //保存配置名
                    confName = rc_m.group(1);

                    //遍历解析配置值
                    while(ev_m.find()){

                            values.add(ev_m.group(1));

                    }


                    confMaps.put(confName,values);

                    //如果解析出错的话,就将对解析错误进行处理
                }else{

                        ConfigParseMessage.ErrorMessage  em = cfm.CreateErrorMessage(Config_File_Name,CurLineNumber+1,configStrings[CurLineNumber]);
                        cfm.add(em);

                        switch(ex_mode){

                            //解析文件时,遇到解析异常(ConfigFileFormatException)立即将异常抛出
                            case  FAILE_FAST:

                                throw new ConfigFileFormatException(mfile,cfm);

                            //解析文件时,遇到解析异常(ConfigFileFormatException)延缓抛出,直到文件读取完才将异常抛出
                            case  FAILE_DELAY:

                                DELAY_FLAG = true;

                                break;


                            default:
                                break;



                        }


            }
                        if(DELAY_FLAG&&i == (configStrings.length-1)){


                              throw new ConfigFileFormatException(mfile,cfm);

                        }
        }
     }
                   return confMaps;


    }


    /**
     * Description: 提取文件内容,并将其分割成一个个的配置项字符串
     * @param  BufferedReader filebr  要提取文件内容的缓存读取器句柄
     * @return String[] 解析后的配置项字符串数组
     *
     */
    private  String[] ExtractConfigString(BufferedReader filebr) throws IOException{

        StringBuffer  fcontents = new StringBuffer();

            if(filebr!=null){

                char[] wbytes = new char[1024];
                while((filebr.read(wbytes))!=-1){

                    fcontents.append(String.valueOf(wbytes));


                }

            }

        return SplitConfigStrings(fcontents.toString());


    }


    /**
     * Description: 将配置字符串分割成一条条配值项字符串
     * @param String confString 包含配置字符串
     * @return String[] 分割后的配置项字符串数组
     **/
    private String[] SplitConfigStrings(String confString){




        String[] SplitedStrings = null;
        /**
         * 分割后的配置项字符串数组
         */
        if(confString!=null){

            String   splite_reg = "[\\s|\\u0020]*"+"\\n";

            Pattern  splite_p   = Pattern.compile(splite_reg);
            SplitedStrings      = splite_p.split(confString);




        }




        return SplitedStrings;


        }



    protected void Read() throws ConfigFileFormatException{

           BufferedReader br = null;

           try{

                   br = new BufferedReader(new FileReader(mfile.sfile));
                   String[] configStrings =  ExtractConfigString(br);

                   ConfigGroups = ConfigParser(configStrings);





            }catch(ConfigFileFormatException cfe){

                   throw cfe;


            }catch(IOException ioe){

                System.out.println(Config_File_Name+"文件读取错误!");
                System.exit(0);


            }finally{

                    if(br!=null){

                        try{

                            br.close();
                        }catch(IOException ioe){

                            System.out.println("文件关闭异常!");
                            ioe.printStackTrace();
                        }
                    }

            }



    }


    /**
     * Descripton:获取相应的配置项的值
     * @param String ConfName 配置项名称
     * @return String[] 返回的相应的配置项的值,如果配置项不存在,就返回空字符串数组
     **/
    public String[]  getConfigValues(String ConfName){

        if(ConfigGroups.size()!=0){


            Iterator lit = ConfigGroups.keySet().iterator();


            //存在配置项返回配置项值
            while(lit.hasNext()){

                Object conf_key = lit.next();



                if(conf_key.equals(ConfName)){

                    List<String> values = ConfigGroups.get(conf_key);
                    return values.toArray(new String[]{});
                }

            }

        }
            //不存在该配置项就返回空
            return new String[]{};


    }

    /**
     * Description: 获取配置项的配置名
     * @return  String[] 返回存在的配置项数组,如果配置项不存在返回空数组
     *
     */
    @SuppressWarnings("unchecked")
    public String[]  getConfigNames(){

        String[] names = null;

        if(!ConfigGroups.isEmpty()){

            Set valuesSet = ConfigGroups.entrySet();

            names  = (String[])valuesSet.toArray(new String[0]);



        }

        return names;

    }

    /**
     * Description:返回配置的Map值
     *
     */

    public Map<String,List<String>> getConfigs(){

        return this.ConfigGroups;

    }



    /**
     *  Description: 判断指定配置项是否存在
     *  @return    boolean  返回true存在,返回false就不存在
     */

    public boolean  isExist(String names){

        boolean flag = false;

        if(!ConfigGroups.isEmpty()){

            flag = ConfigGroups.containsKey(names);

        }

        return flag;

    }

    /***
     * Description: 返回配置项的个数
     * @return int  返回配置项的个数
     */
    public int  count(){

        if(!ConfigGroups.isEmpty()){

            return  ConfigGroups.size();

        }

        return 0;

    }


   /**
     * Description: 文件读取前进行的操作,通过文件后缀名判断是否是配置文件
     */
    protected void ReadBeforeOperation(){


            this.isConf();
    }


    /**
     * Description:文件读取后的操作
     *
     */
    protected void ReadAfterOperation() throws IOException{


    }



    protected void Write(){

    }


    protected void WriteBeforeOperation(){

        this.isConf();


    }

    protected void WriteAfterOperation(){


    }
}



