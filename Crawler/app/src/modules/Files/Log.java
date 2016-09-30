package modules.Files;
import modules.Files.FileDecorator;
import modules.Files.File;
import modules.log.LogMessage;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;


/**
 * Description: 日志处理类,对日志进行读写
 * @author: duanduan
 * @date  : 2016-02-26
 * @referenceclass: @see modules.Files.File
 *                  @see modules.Files.FileDecorator(父类)
 *
 */

public class Log extends FileDecorator{

    private LogMessage message;

   /**
     * Description: 日志时间格式,默认格式为:"2008-10-12 06:30:20" 这种格式
     */
    private String LogTimeFormat = "yyyy-MM-dd HH:mm:ss";


    /**
     * Description: 缓存日志信息条数
     *
     */

    /**
     * Description: 日志时间
     */
    private String LogTime;

    /**
     * Description: 存储缓存日志信息
     *
     */
    private List<LogMessage> Cachelogs = new ArrayList<LogMessage>();

    /**
     * Description: 缓存最大的日志信息条数,默认100条
     *
     */


    private int MAX_CACHE_LOGS = 100;

    /**
     * Descripton: 是否缓存标志,默认缓存
     *
     */

    private boolean IS_CACHE = true;

    private FileWriter fw;
    private BufferedWriter bw;

    /**
     * Description: 无参数构造函数,用于子类继承
     */
    public Log(){

    }

    /**
     * Description: 继承父类实现装饰器模式
     * @param @see modules.Files.File 构造函数传入的对象
     * @param boolean is_cache 是否开启缓存,true 开启,false 关闭
     */
    public Log(File f,boolean is_cache){

     super(f);
        try{

            fw   = new FileWriter(f.sfile,true);
            bw   = new BufferedWriter(fw);
        }catch(FileNotFoundException fe){

            System.out.println(f.getFileName()+"文件路径不存在!");

            System.exit(0);
        }catch(IOException ioe){
            System.out.println(f.getFileName()+"文件读写错误!");
            System.exit(0);

        }

     this.IS_CACHE = is_cache;
    }

   /**
     * Description: 继承父类实现装饰器模式
     * @param @see modules.Files.File 构造函数传入的对象
     */

    public Log(File f){
        super(f);
        try{

            fw   = new FileWriter(f.sfile,true);
            bw   = new BufferedWriter(fw);
        }catch(FileNotFoundException fe){

            System.out.println(f.getFileName()+"文件路径不存在!");

            System.exit(0);
        }catch(IOException ioe){
            System.out.println(f.getFileName()+"文件读写错误!");
            System.exit(0);

        }



    }

    /**
     *
     * @param: String Format 日志时间格式,具体格式要求参照Java标准手册中SimpleDateFormat类的详细说明
     */

    public void setLogTimeFormat(String Format){

        this.LogTimeFormat = Format;

    }

    /**
     *
     * Description: 记录时间
     */
    private String getLogTime(){

        //按要求格式化时间

        this.LogTime = new SimpleDateFormat(this.LogTimeFormat).format(System.currentTimeMillis());

        return this.LogTime;

    }


    /**
     * Description: 设置是否开启缓存
     * @param boolean is_cache  true 开启,false 关闭
     * @return boolean  返回之前的状态
     */
    public boolean setCache(boolean is_cache){

        this.IS_CACHE = is_cache;
        return !IS_CACHE;

    }

    /**
     * Description: 查看是否开启缓存
     * @return boolean 返回true已经开启缓存,false缓存关闭
     *
     *
     */
    public boolean IsCache(){

        return this.IS_CACHE;

    }


   /**
     *
     * Description: 记录带有级别的日志消息
     * @param String msg  日志信息
     * @param String level    日志级别
     *
     */

    public void LogMessage(String msg,
            int level) {

        //记录消息信息
        this.message  = new  LogMessage();
        this.message.MESSAGE_LEVEL= level;
        this.message.MESSAGE_TYPE = "NORMAL";
        this.message.MESSAGE_CONTENT = msg;
        this.message.MESSAGE_TIME   = this.getLogTime();

        this.Write();
   }


    /**
     * Description: 记录程序中的良好状态日志信息
     * @param String Message 消息体
     */

    public void fine(String msg) {

        this.message  = new LogMessage();
        //记录消息信息
        this.message.MESSAGE_TYPE = "Fine";
        this.message.MESSAGE_CONTENT      = msg;
        this.message.MESSAGE_TIME = this.getLogTime();
        //加入缓存消息信息队列中
        this.Write();



    }





    /**
     * Description: 记录异常信息
     * @param String msg 消息体
     *
     */
    public void throwing(String msg) {

        this.message  = new LogMessage();
        //记录消息信息
        this.message.MESSAGE_TYPE = "Exception";
        this.message.MESSAGE_CONTENT      = msg;
        this.message.MESSAGE_TIME = this.getLogTime();

        this.Write();

    }





    /**
     * Description: 记录警告日志信息
     *
     *
     */
    public void warnning(String msg) {
       this.message  = new LogMessage();
        //记录信息
       this.message.MESSAGE_CONTENT = msg;
       this.message.MESSAGE_TYPE = "WARNNING";
       this.message.MESSAGE_TIME= getLogTime();
       this.Write();


      }





    /**
     * Description: 读取文件操作
     */
    @Override
    protected void Read(){

    }


    /**
     * Description: 写入文件操作
     *
     */

    @Override
    protected void Write(){


        try{

            //如果有缓存的话
            if(IS_CACHE){


                    LogCacheSchedule();

            }else{

                   bw.write(this.message.toString()+"\n");



            }

        }catch(IOException ioe){

            System.out.println(mfile.getFileName()+"日志文件写入错误!");
            System.exit(0);

        }




    }

    /**
     * Description: 清空日志消息缓存
     *
     *
     */
    private void ClearLogCaches(){


        Cachelogs.clear();

    }

    /**
     * Description:写入缓存日志消息,并清除缓存
     *
     */
    private void WriteLogCaches() throws IOException {

        String wstring = "";

        //System.out.println("-----"+Cachelogs.size());
        if(Cachelogs.size()!=0){

            for(LogMessage lg : Cachelogs){

                wstring+=lg.toString()+"\n";

            }

            bw.write(wstring);
        }

        ClearLogCaches();


    }

    /**
     * Description: 日志消息缓存控制,如果缓存日志条数未超过最大缓存日志条数的时候不将日志信息写入文件中，直到缓存条数超过设置的最大缓存日志条数,才将日志信息写入日志文件中,提高性能
     *
     */

    private void LogCacheSchedule() throws IOException{

            String wstring = "";

            if(Cachelogs.size()>=0 &&Cachelogs.size()<MAX_CACHE_LOGS)
            {

                    Cachelogs.add(message);

            }else{




                     WriteLogCaches();
                     Cachelogs.add(message);
                }





    }

    /**
     * Description:释放相关文件资源,并将缓存内容写入文件中
     */
    public void close() throws IOException{

        if(Cachelogs.size()!=0){

            WriteLogCaches();
        }

        if(bw!=null){

            bw.close();

        }





    }
    /**
     * Description: 读取后做的操作
     */
    @Override
    protected void ReadAfterOperation(){

    }


    /**
     * Description: 读取前做的操作
     **/

    @Override
    protected void ReadBeforeOperation(){

    }


    /**
     * Description: 写文件之前作的操作
     */
    @Override
    protected void WriteBeforeOperation(){


        try{

            if(bw!=null){

                bw.close();
            }

            if(fw!=null){

                fw.close();
            }
        }catch(IOException ie){

            System.out.println(mfile.getFileName()+"日志文件写入失败!");
        }
    }

    /**
     * Description: 写操作之前作的操作
     */
    @Override
    protected void WriteAfterOperation(){

    }
}




