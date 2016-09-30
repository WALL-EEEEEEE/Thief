import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.OutputStream;

public class httpUrlConnection {

     private httpUrlConnection(){
	try{

		String pathUrl = "http://www.baidu.com";
		
		//建立连接　
		URL    url = new URL(pathUrl);

		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		
		
		//设置连接属性
		httpConn.setDoOutput(true);//使用URL连接进行输出
		httpConn.setDoInput(true);//使用URL连接进行输入
		httpConn.setUseCaches(false);//忽略缓存
		String requestString = "客户端要以流的方式发送到服务端的数据...";
		

		//设置请求属性
		//获得数据字节数据,请求数据流的编码,必须和下面服务器端请求流的编码一致
		byte[] requestStringBytes = requestString.getBytes("UTF-8");
		httpConn.setRequestProperty("Content-length",""+requestStringBytes.length);
		httpConn.setRequestProperty("Content-Type","application/cotest-stream");
		httpConn.setRequestProperty("Charset","UTF-8");

 
     /*         String name = URLEncoder.encode("黄武艺","UTF-8");*/
		//httpConn.setRequestProperty("Name",name);


       /*         OutputStream outputStream = httpConn.getOutputStream();*/
		//outputStream.write(requestStringBytes);
		//outputStream.close();

		int responseCode = httpConn.getResponseCode();
		
		if(HttpURLConnection.HTTP_OK == responseCode){
			
			StringBuffer sb = new StringBuffer();
			String 	     readLine;
			BufferedReader responseReader;

			responseReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(),"utf-8"));
			
			while((readLine = responseReader.readLine())!=null){
				sb.append(readLine).append("\n");

			
			}

			System.out.println(sb);
			responseReader.close();
			//tv.setText(sb.toString());
		}
	

	}catch(Exception ex){


	ex.printStackTrace();

	}
}


	public static void main(String args[]){

		

		httpUrlConnection http_conn = new httpUrlConnection();






	}














}
