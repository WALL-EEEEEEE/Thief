package modules.WebTools;

import java.util.Map;
import java.util.HashMap;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.zip.DataFormatException;
import java.lang.StringBuffer;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.Exception;
import java.io.BufferedWriter;
import java.io.FileWriter;
import modules.DebugTools.Debug;

import java.io.File;
public class  ImporviceFile{

	//设置默认的key-value形式文件的分割符
	private String  MAP_SPERATOR = ":";
	
	

	/**读取key-value映射式的文件内容  **/
	public  Map<String,String> ReadMappingFile(File tfile,String sperator){

		HashMap<String,String> mtext = new HashMap<String,String>();

		try{
			FileReader fr = new FileReader(tfile);
			BufferedReader br = new BufferedReader(fr);
			String linetext = "";
			//读取文件内容
			while((linetext = br.readLine())!=null){

				
				String[] maps  = linetext.split(sperator);
				//Debug.DumpArray(maps);
				//判断文件格式是否是key+sperator+value格式,并允许键值对之间有空行
				if(maps.length != 2 && !linetext.contains("\\r") && linetext.length()!=0&&linetext.contains(" ")&&linetext.contains("\t")){

					throw new DataFormatException("文件格式不正确");
				}
				
				
				/** 忽略空行 **/
				if(maps.length == 2){
					mtext.put(maps[0],maps[1]);
				}
			}
			

			//关闭流
			
			br.close();
		
			
			
		}catch(FileNotFoundException fe){
			
			System.out.println("文件"+"不存在!");

		}catch(IOException ie){


			System.out.println("文件读取出错,请确定你有文件的读取权限!");
		}catch(DataFormatException de){
			
			System.out.println("文件格式不正确");

		}catch(Exception e){


			e.printStackTrace();

		}
			
			
		
		return mtext;

	}




	/**写入key-value 映射文件,使用默认的分割符**/
	public void WriteMappingFile(Map<String,String> maps,File tfile){

		
		try{
			BufferedWriter   fw = new BufferedWriter(new FileWriter(tfile));
			
			maps.forEach((e1,e2)->{

				try{
					String linetext = e1+this.MAP_SPERATOR+e2+"\n";
					fw.write(linetext);
					fw.newLine();
				   }catch(IOException ie){

					System.out.println("写入文件失败");
				  
				  }

		});
		
		
		fw.close();
			
		
		}catch(IOException ie){

			System.out.println("写入文件失败!");

		}



	}

	/** 使用分割符写入key-value映射文件 **/
	public void WriteMappingFile(Map<String,String> maps,File tfile,String sperator){

		this.MAP_SPERATOR = sperator;


		this.WriteMappingFile(maps,tfile);


	}



  
	
	


}
