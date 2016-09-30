
/**
 * Description: 网页抓取器程序入口
 *
 */

import static modules.DebugTools.Debug.*;

public class start{


	public static void main(String[] args){


        //初始化
        app_initial();
        //初始化程序模块加载器;
        ModuleLoader m_loader = new ModuleLoader();
        //初始化运行配置模块
        ConfigModule cm = new ConfigModule();
        cm.initial();
        cm.run();


        //初始化运行日志模块
        LogModule lm = new LogModule();
        lm.initial();
        lm.run();


        //初始化运行网页抓取模块
        WebFetchModule wm = new WebFetchModule();
        wm.initial();
        wm.run();

    }

    /**
     * 初始化程序
     *
     */
    public static void app_initial(){

            //初始化程序配置信息
            ConfigModule.AppConfigInitial();



    }








}
