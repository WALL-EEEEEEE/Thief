package modules.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;


public class AppendFile{
    public static void method1(String file,String content){
        BufferedWriter out = null;
        try{
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,true)));
            out.write(content);

        }catch(Exception e){

            e.printStackTrace();
        }finally{

              try{
                   if(out!=null){

                       out.close();
                   }

              }catch(IOException e){

                  e.printStackTrace();

              }

        }


    }

    public static void method2(String fileName,String content){

        FileWriter writer = null;
        try{
            writer = new FileWriter(fileName,true);
            writer.write(content);

        }catch(IOException e){

            e.printStackTrace();
        }finally{
            try{
                if(writer!=null){

                    writer.close();
                }
            }catch(IOException e){
                e.printStackTrace();

            }

            }

        }

    public static void method3(String fileName,String content){

        RandomAccessFile randomFile = null;
        try{

            //打开一个随机访问文件流,按读写方式
            randomFile = new RandomAccessFile(fileName,"rw");
            //文件长度,字节数

            long filelength = randomFile.length();
            //将写文件指正移动到文件尾部.
            randomFile.seek(filelength);
            randomFile.writeBytes(content);



        }catch(IOException e){
            e.printStackTrace();

        }finally{

            if(randomFile!=null){

                try{
                    randomFile.close();

                }catch(IOException e){

                    e.printStackTrace();
                }
            }

        }




    }


    public static void main(String[] args){

        try{
            File file = new File("text.txt");
            if(file.createNewFile()){

                System.out.println("Create file successed");

            }

            method1("text.txt","123");
            method2("text.txt","123");
            method3("text.txt","123");
        }catch(Exception e){

            System.out.println(e);
        }

    }





    }







