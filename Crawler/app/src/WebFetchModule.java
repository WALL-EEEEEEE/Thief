/**
 * Description:网页抓取模块类,用于对程序网页抓取进行管理
 *
 */
import modules.WebTools.WebFetch_class;
import modules.Files.ConfigFile;
import modules.configure.ConfigFileFormatException;
import modules.Files.MapFile;
import modules.Files.File;
import static modules.DebugTools.Debug.*;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Arrays;
import java.io.IOException;
import java.util.Map.Entry;



public class WebFetchModule extends ModuleSharedData implements Module {


    /**
     * 要抓取的urls
     */

    String   data_path = null;
    String   res_path =  null;
    String   search_words_path = null;
    String   cache_path = null;
    String[] swords = null;
    WebFetch_class wf = null;
    Map<String,String> results = new HashMap<String,String>();

    /**
     * Description: 运行网页模块
     */
    public void run(){

        //开始抓取网页
        try{

            wf.StartFetch();
        }catch(Exception ce){

            ce.printStackTrace();
            System.exit(0);

        }
        //获取抓取结果
        results = wf.getFetchResults();

        //存入目标结果
        java.io.File  rf = new java.io.File(cache_path);
        if(!rf.exists()){

            try{

                rf.createNewFile();

            }catch(IOException ioe){

                System.out.println(rf.getAbsolutePath()+"创建失败!");
                ioe.printStackTrace();
            }
        }

        //抓取网页数据,并将对应的网页数据缓存到指定的缓存文件中

        MapFile mf = new MapFile(new File(cache_path){});
        mf.setMapWriteValues(results);
        mf.Write();

        //从抓取的数据中分析数据,并生成结果,并将结果写入文件
        Map<String,String> finalResults = new HashMap<String,String>();

        //搜索关键字,如果存在任何关键字信息,输出contains = true
        if(results.size()!=0){

            boolean  flag = false;
            for(Entry e:results.entrySet()){

                for(String kword:swords){

                     if(e.getValue().toString().contains(kword)){

                         flag = true;

                      }

                }


                finalResults.put(e.getKey().toString(),Boolean.toString(flag));


         }


        }

        //将最终结果存入文件中
        java.io.File frf = new java.io.File(res_path);

        if(!frf.exists()){

            try{
                frf.createNewFile();
            }catch(IOException ioe){

                System.out.println("创建"+frf.getAbsolutePath()+"失败!");
                ioe.printStackTrace();
                System.exit(0);

            }
        }



        MapFile fmf = new MapFile(new File(res_path){});
        fmf.setMapWriteValues(finalResults);
        fmf.Write();








    }

    /**
     * Description:初始化模块
     *
     */
    public void initial(){

        //根据配置文件获取要抓取的网页urls文件
        int i = Datas.size()-1;
        data_path=Datas.get(i).get("urls_data").get(0);
        cache_path= Datas.get(i).get("cache_dir").get(0);
        search_words_path=Datas.get(i).get("search_data").get(0);
        res_path  = Datas.get(i).get("out_dir").get(0);
        ConfigFile furls = null;
        ConfigFile fsws  = null;

        if(data_path.length() == 0 || res_path.length() == 0 || search_words_path.length() ==0 || res_path.length() == 0){

            System.out.println("程序配置出错!");
            System.exit(0);
        }


        //获取搜索抓取的url数据信息,和搜索关键字信息

        try{

            furls = new ConfigFile(new File(data_path){});
            fsws  = new ConfigFile(new File(search_words_path){});

        }catch(ConfigFileFormatException cfe){

           System.out.println(cfe.getMessage());
           System.exit(0);

        }

        //获取urls
        List<String> ulists = Arrays.asList(furls.getConfigValues("urls"));

        //获取querywords
        List<String> klists = Arrays.asList(furls.getConfigValues("querywords"));

        //获取搜索关键字
        swords= fsws.getConfigValues("keywords");

        if(wf==null){
            //初始网页抓取器
            try{
                wf = new WebFetch_class();
                wf.setURLs(ulists);
                wf.setURLQuerys(klists);
            }catch(Exception e){

                System.out.println("初始化网页抓取器失败!");
                e.printStackTrace();
                System.exit(0);
            }
        }




    }


}
