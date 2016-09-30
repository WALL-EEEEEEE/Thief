package modules.Files;

import java.lang.Exception;

    /**
     * Description : 文件格式异常类,读取文件时,发现与指定文件的文件格式不相同,则抛出文件格式异常
     * Reference Classes:  @see java.lang.Exception;
     *
     */

public class FileFormatException extends Exception{

    private static final  long serialVersionUID = 1L;
    private String msg = null;

    /**
     * Description: 无参构造函数,用于子类继承
     *
     */
    public FileFormatException(){

    }
    /**
     * Description:构造函数
     * @param: File causefile 触发异常的文件类
     */
    public FileFormatException(File causefile){

        msg = causefile.getFileName()+"解析错误!";

    }

    /**

     * Description:构造函数
     * @param: File causefile 触发异常的文件类
     * @param: Strng message  额外的信息描述
     *
     */

    public FileFormatException(File causefile,String message){

       msg = causefile.getFileName()+"解析错误!:\n"+message;
    }

    /**
     * Description:构造函数
     * @param: String message 额外的信息描述
     *
     */
    public FileFormatException(String message){

        msg = message;

    }

    /**
     * Description: 返回异常相关信息
     */
    public String getMessage(){

        if(msg!=null){

            return msg;
        }

        return "";

    }

}
