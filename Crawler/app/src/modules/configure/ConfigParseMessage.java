package modules.configure;


import modules.common.Message;
import java.util.List;
import java.util.ArrayList;
import java.lang.CloneNotSupportedException;
import static modules.DebugTools.Debug.*;


/**
 * Description: 解析配置文件消息类,用来存放解析文件时相关文件信息和错误信息
 * ReferenceClass:
 *             Message
 *
 *
 */

public class ConfigParseMessage extends Message{

    //定义错误消息的格式
    public class ErrorMessage{

            //报错的文件名
            String E_FNAME;
            //报错的行
            int E_LINE;
            //报错的列
            int E_ROW;
            //报错的概要
            String E_RESUME;

            //构造消息体
            ErrorMessage(String fname,int line,String resume){

                E_FNAME = fname;
                E_LINE =  line;
                E_RESUME = resume;
            }

            public String toString(){

                String omsgs = ">>>>>>>"+E_FNAME+"(行:"+E_LINE+")  <<<"+E_RESUME+">>>";

                return omsgs;

            }




      }


    //保存的解析配置信息的相关信息字符串
    private List<ErrorMessage>  msgs = new ArrayList<ErrorMessage>();
    /***
     * Description:初始化构造函数
     *
     */
    public ConfigParseMessage(){


    }

    public ErrorMessage CreateErrorMessage(String fname,int line,String resume){

        ErrorMessage em = new ErrorMessage(fname,line,resume);

        return em;

    }
    /**
     * Description: 增加配置解析信息
     * @param:  String msg  信息详情
     *
     */
    public void add(ErrorMessage error){

        msgs.add(error);

    }

    /**
     *Description: 清除配置中的解析信息
     *
     */
    public void clear(){

        msgs.clear();
    }

    /**
     * Description:将消息类的相关信息转换成字符串
     *
     */
    @Override
    public String toString(){

        String outmsgs = "\n";


        for(ErrorMessage msg: msgs){

            outmsgs = outmsgs.concat(msg.toString()+"\n");
        }


        return outmsgs;
    }
}


