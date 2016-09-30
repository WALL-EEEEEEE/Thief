import java.io.File;
import modules.Files.Log;
import modules.Files.LogFile;
import static modules.DebugTools.Debug.*;

/**
 * Description: 日志模块类,对程序日志进行管理
 *
 */

public class LogModule extends ModuleSharedData implements Module {



    String logpath = null;
    Log log = null;
    /**
     * Description: 运行日志模块
     *
     */

    public void run(){

        log.LogMessage("Application start",0);

    }

    /**
     * Description: 初始化日志模块
     */
    public void initial(){


        //获取配置信息中的日志文档存储路径
        logpath =Datas.get(0).get("log_dir").get(0);
        //并初始化日志记录器
        LogFile lf  = new LogFile(logpath);
        log = new  Log(lf,false);
    }



}
