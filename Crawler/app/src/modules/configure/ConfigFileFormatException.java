
package modules.configure;
import modules.Files.FileFormatException;
import modules.Files.File;
import modules.common.Message;

      /**
       * Description: 配置文件格式错误异常类,如果读取配置文件时发现文件格式不正确,则抛出该异常
       * Reference Class:  @see modules.Files.ConfigFile
       *                   @see moduules.Files.FileFormatException
       *
       *
       */

public class ConfigFileFormatException extends FileFormatException{

       private Message parseMessages;
       private File     srcFile;

        /**
         *Description: 构造函数
         *@param File causefile 触发该异常的文件类
         *@param String msg     额外提供的异常信息
         *
         *
         */
        public ConfigFileFormatException(File causefile,String msg){

            super(causefile,msg);

        }


        /**
         * Description: 构造函数
         * @param File causefile 触发该异常的文件类
         */
        public ConfigFileFormatException(File causefile){

            super(causefile);
        }

        /**
         * Description: 构造函数
         * @param String msg 异常信息的详细描述
         *
         */
        public ConfigFileFormatException(String msg){

            super(msg);

        }


        /***
         * Description: 构造函数
         * @param File causefile  触发该异常的类
         * @param Message msgs
         */
        public ConfigFileFormatException(File causefile,Message msgs){
            srcFile = causefile;
            parseMessages = msgs;

        }



        /**
         * Description: 获取解析异常信息
         * @param: String  解析的异常信息类
         *
         */

        public String getMessage(){

            return parseMessages.toString();

        }
}


