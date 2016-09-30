package modules.Files;

import modules.Files.File;
import java.io.IOException;

/***
 * Description: 日志文件,被用于日志操作器使用
 *
 *
 */

public class LogFile extends File{

    /**
     * Description: 初始化一个日志文件
     *
     */
    public LogFile(String fname){

                    sfile = new java.io.File(fname);
                    this.fileName = sfile.getName();
                    if(!sfile.exists()){

                        try{

                            sfile.createNewFile();

                        }catch(IOException ioe){

                            System.out.println("新建日志文件 "+getFileName()+"失败");
                            System.exit(0);
                        }

                    }




    }


}



