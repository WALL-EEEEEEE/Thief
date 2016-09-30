package modules.WebTools;
/**
 *
 * 类功能:网页抓取
 *
 */
import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.lang.Runnable;
public class WebFetch_class implements Runnable{



	//存放网址
	private List<String>  url_domains = new ArrayList<String>();

    private	List<String>  url_Querys = new ArrayList<String>();

	private List<String>  urls  = new ArrayList<String>();
	private HashMap<String,String> fetch_Results = new HashMap<String,String>();
	private	static boolean FETCH_MODE= false;
	private HttpURLConnection http_con;

	//指定开辟的线程数目
	private static final int Thread_nums = 8;


	//获取网址
 	public List<String> getURLs(){

		return urls;


	}




	/*单线程抓取网页*/
public void Fetch(List<String> furls){


	//依次抓取网页
	for(int i = 0;i<furls.size();i++){

		try{



			URL url = new URL(furls.get(i));

			System.out.println("正在抓取<"+url+">\t"+(i+1));
			http_con = (HttpURLConnection) url.openConnection();

			//设置http连接选项
			setOption();

			int Status_Code = http_con.getResponseCode();


			if(Status_Code == HttpURLConnection.HTTP_OK){

				System.out.println("Status: OK"+"  抓取成功");



				StringBuffer str_b = new StringBuffer();
				InputStream in_str= http_con.getInputStream();

				BufferedReader br = new BufferedReader(new InputStreamReader(in_str));

				String str = null; while((str =  br.readLine())!=null){

					str_b.append(str).append("\n");


				}


				br.close();


				//System.out.println(str_b);

				/*将网页抓取的结果存取起来*/
				saveFetchResults(furls.get(i),str_b.toString());



			}else{

				System.out.println("Status: false  抓取失败!");
			}

				http_con.disconnect();

	}catch(Exception ex){



			saveFetchResults(furls.get(i),"failed");
			ex.printStackTrace();

	}
}
}




	public void MultiThreadFetch() throws Exception{


		int URL_Size = getURLs().size();
		int SubURL_Size = URL_Size/Thread_nums;

		for(int i = 0;i<=Thread_nums;i++){

			ArrayList<String> SubURLs = (ArrayList<String>)url_domains.subList(i*SubURL_Size,(i+1)*SubURL_Size);
			WebFetch_class  sfetch = new WebFetch_class();
			sfetch.setMode(0);
			sfetch.setURLs(SubURLs);
			sfetch.setURLQuerys(url_Querys);
			new Thread(sfetch).run();

		}


	}




	/* 将URL拼接成完整URL   */
	private void GenEntireURL(List<String> Domains,List<String> QueryPortions){


		int Domains_size = Domains.size();

		int QueryPortions_size = QueryPortions.size();

		if(Domains_size != 0){


			for(int i = 0;i<Domains_size;i++){


				if(QueryPortions_size == 0){


					urls.add(Domains.get(i));


				}else{



					for(int j =0;j<QueryPortions_size;j++){

						urls.add(Domains.get(i)+"/"+QueryPortions.get(j));

					}


				}


			}





		}


	}



      /*抓取网页,默认为单例抓取 */

       public void  StartFetch() throws Exception {
		//不允许,网页抓取列表为空
		if(url_domains.isEmpty()){


			throw new Exception("要抓取的网页列表不能为空!");
		}


			//单例模式
		if(FETCH_MODE == false){

			Fetch(urls);

		}else{


			MultiThreadFetch();
		}


	}


     //设置连接属性
      private void  setOption(){



		http_con.setDoInput(true);
		http_con.setUseCaches(false);
		http_con.setConnectTimeout(3000);
		//准许重定向
		HttpURLConnection.setFollowRedirects(true);

     }





     //设置抓取模式,0一般模式,1多线程模式
      private void setMode(int mode){


		FETCH_MODE=(mode == 0)?false:true;



	}



     //设置搜索关键字,返回关键字组的大小
     public int setURLQuerys(List<String> query_strs) throws Exception{



		if(query_strs.size()== 0){

				throw new Exception("传入网址qeuerySection部分为空!");


		}
		url_Querys.addAll(query_strs);

		//拼接网址
		GenEntireURL(url_domains,url_Querys);



		return url_Querys.size();



    }


   public void setURLs(List<String> surl_domains) throws Exception{


		if(!url_domains.isEmpty()){


			if(surl_domains.isEmpty())
			{


				throw new Exception("不能设置空的url_domains");


			}


			url_domains.clear();



		}



		url_domains.addAll(surl_domains);



  }



	//设置单个URL
	public void setURL(String url) throws Exception{


		if(!url_domains.isEmpty()){

			url_domains.clear();


		}

		if(url.length()!=0){

			url_domains.add(url);

		}else{



			throw new Exception("网址不能为空!");

		}

	}


	 //存取抓取结果,返回结果集大小
private int saveFetchResults(String url_domains,String results) {

			fetch_Results.put(url_domains,results);

			return fetch_Results.size();


}

//获得抓取结果

public Map<String,String> getFetchResults(){




		return fetch_Results;




	}


	/*多线程处理方法 */
	public void run(){



		Fetch(urls);

	}



}


