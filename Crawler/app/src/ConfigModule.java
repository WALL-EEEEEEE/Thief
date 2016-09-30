/**
 * Description: 配置模块类,用于读取程序配置,管理程序配置文件
 *
 */

import modules.Files.File;
import modules.Files.ConfigFile;
import modules.configure.ConfigFileFormatException;
import java.util.List;
import java.util.Map;
import static modules.DebugTools.Debug.*;
import java.io.IOException;

public class ConfigModule extends ModuleSharedData implements Module{

    //设置默认的程序的主配置文件的位置
    private static String default_conf = "app.conf";
    //设置默认的程序主配置文件模板的位置
    private static String default_conf_template="app/resource/conf/app.conf";
    //配置文件信息
    private ConfigFile configs= null;




    /**
     * Description: 运行模块
     *
     */
    public void run(){


    }


    /**
     * Description: 初始化配置模块
     *
     */
    public void initial(){





    }

    /**
     * Description:程序配置初始化
     */
    public static void AppConfigInitial(){
       //检查文件的主配置文件是否存在,如果存在读取程序主配置文件的配置信息,否则读取默认的程序主配置文件模板的信息
        java.io.File conf_file = new java.io.File(default_conf);

/*        try{*/

            //System.out.println(conf_file.getCanonicalPath());
        //}catch(IOException ioe){

        //}
        //System.out.println(conf_file.exists());


        ConfigFile  appconfs = null;


        if(conf_file.exists()){

            try{

               appconfs = new ConfigFile(new File(default_conf){});


            }catch(ConfigFileFormatException cfe){

                System.out.println(cfe.getMessage());
                System.exit(0);

            }


        }else{

            conf_file = new java.io.File(default_conf_template);
            if(conf_file.exists()){

                try{

                    appconfs= new ConfigFile(new File(default_conf){});
                }catch(ConfigFileFormatException cfe){

                    System.out.println(cfe.getMessage());
                    System.exit(0);
                }

            }else{

                System.out.println("程序配置文件缺失,程序启动失败!");
            }


        }


            //写入模块数据,使得模块间可以共享程序配置信息
            int data_id = ModuleSharedData.register();

            ModuleSharedData.write(appconfs.getConfigs());

            }

    public Map<String,List<String>> getConfigs(){


            return configs.getConfigs();

    }


}
