package modules.test;
import modules.WebTools.WebFetch_class;
import modules.DebugTools.Debug;
import modules.common.TypeSmartConvert;
import modules.WebTools.ImporviceFile;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Iterator;
import java.util.HashMap;
import java.io.File;
import modules.common.Arrayss;
//import modules.test.ConfFile.TestConfFile;
public class Test{

	public void WebFetchTest(){



		//WebFetch_class wf = new WebFetch_class("""http://www.baidu.com");",",

		try{
			String[]  urls = new String[]{
            "http://bj.yihaihome.cn/",
            "http://shop.qhdcm.com",
            "http://www.18yang.com/",
            "http://www.baobeilaojin.com/",
            "http://www.china-techan.cn",
            "http://www.dvmall.com.cn",
            "http://www.haolivshop.com",
            "http://www.jiuxiangfushi.com",
            "http://www.ncphome.com.cn",
            "http://www.shibao1.com/",
            "http://www.tianhego.com/",
            "http://www.yhlzyht.com/shop",
            "http://www.zhenyoufu.cc/",
            "http://yuchai.weilian.cn/shop/",
            "http://erp.lonview.com/",
            "http://shop.bunlap.com/",
            "http://t.tiyulm.com/shop",
            "http://www.789q.com.cn",
            "http://www.bldsc.com",
            "http://www.ctmpe.com/shop/",
            "http://www.enterok.com",
            "http://www.hoogang.com",
            "http://www.jingxiwg.com",
            "http://www.lovesswg.com",
            "http://www.nhlm.wang",
            "http://www.qytjd.com/shop/",
            "http://www.sugonet.com/shop/",
            "http://www.wopi360.com",
            "http://www.yanj.cn/",
            "http://www.youjia020.com",
            "http://www.zaosc.com/",
            "http://youyao.ku72.cn/shop/"

		};

		String[] URL_Querys = new String[]{



		"robots.txt",

		"shop/robots.txt",

		"update.txt",

		"shop/update.txt",

		"readme.txt",

		"shop/readme.txt",

		"cms",

		"circle",

		"microshop",

		"modules/microshop/install/index.php",

		"modules/microshop ",

		"modules/circle/",

		"modules/cms",

		"data/upload/microshop/default_index_banner.jpg",

		"upload/microshop/default_index_banner.jpg",

		"data/upload/circle/logo.png",

		"data/upload/microshop/default_logo_image.png ",

		"upload/microshop/default_logo_image.png",

		"data/upload/cms/cms_default_logo.png",

		"upload/store/default_qrcode.png",

		"mobile/readme/api.html",

		"mobile/readme/sql/mobile.sql",

		"data/upload/store/default_qrcode.png",

		"shop/install/step_2.php",

		"shop/install/step_3.php",

		"install/step_2.php",

		"install/step_3.php",

		"install/images/setting.png",

		"shop/install/data/utf8.sql",

		"install/data/utf8.sql",

		"install/sql/shopnc_utf8.sql",

		"index.php?act=searchsss&cate_id=8",

		"index.php?act=search222&nearby=0&keyword=+",

		"admin/index.php?act=login&op=login",

		"admin/templates/images/sky/shopnc_logo.png",

		"admin/templates/images/mac/shopnc_logo.png"

		};

			List<String> lquerys = TypeSmartConvert.ArrayToList(URL_Querys);
			List<String> lurls = TypeSmartConvert.ArrayToList(urls);



			WebFetch_class wf = new WebFetch_class();

			ImporviceFile fi = new ImporviceFile();
			wf.setURLs(lurls);
			wf.setURLQuerys(lquerys);

			wf.StartFetch();


			//获取抓取结果集
			Map<String,String> fetchResults  = wf.getFetchResults();

			Map<String,String> filterResults = new HashMap<String,String>();

			fetchResults.forEach((e1,e2)->{
				if(e2.contains("ShopNC")){

					filterResults.put(e1,"contains");

				}



			});
			//存取抓取结果集
			File file2 = new File("../../file/pageResult");
			//存取过滤抓取结果集
			File file1 = new File("../../file/filterwordResults");

			if(!file1.exists()){

				file1.createNewFile();

			}

			if(!file2.exists()){

				file2.createNewFile();

			}

			fi.WriteMappingFile(filterResults,file1,":");
			fi.WriteMappingFile(fetchResults,file2,":");


			}catch(Exception ex){

			ex.printStackTrace();





		}






	}



    //public void DumpList(List<?> list){

        //int length = list.size();

        //for(int i = 0;i<length;i++){

            //System.out.println(list.get(i));


        //}








    //}

     //public void RegexTest(String str, String regex){


        //String[] strs = str.split(regex);


        //System.out.println(strs.length);
        //Debug.DumpArray(strs);

   //}



    //public void TestWriteFile(Map<String,String> mappings,File file){




        //ImporviceFile fs = new ImporviceFile();

        //fs.WriteMappingFile(mappings,file);








  //}


  //public void ArraysTest(){

      //String[] str = new String[]{

          //"                          hello",
              //" hello the world        "

      //};

      //Arrayss.trim(str,",");

  //}

   //public void TestReadFile(File file, String sperator){



           //ImporviceFile fs = new ImporviceFile();
           //Map<String,String>  maps = fs.ReadMappingFile(file,sperator);
           //Debug.DumpMap(maps);




  //}



  //public void TestConfFile(){


        //TestConfFile tf = new TestConfFile();

        //tf.test();


  //}













}
