package modules.junit;

/***
 * Description: 配置文件测试类
 * @author: duanduan
 * date   : 2016-03-01
 *
 *
 */
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import java.io.IOException;
import modules.configure.ConfigFileFormatException;
import modules.Files.ConfigFile;
import modules.Files.File;
import static modules.DebugTools.Debug.*;

public class TestConfigFile{



    @Before
    public void initialize(){


    }

    @After
    public void free(){

    }


    @Test
    public void TestConfig() throws IOException{


        try{


        ConfigFile  conf = new ConfigFile(new File("conf/testconf1.conf"){});

        System.out.println("获得的配置数据......");
        DumpArray(conf.getConfigValues("appName"));
        DumpArray(conf.getConfigValues("logpath"));
        DumpArray(conf.getConfigValues("time"));
        DumpArray(conf.getConfigValues("data"));
        DumpArray(conf.getConfigValues("name"));

        }catch(ConfigFileFormatException cfe){

            System.out.println("文件解析错误!"+cfe.getMessage());



        }




    }







}
