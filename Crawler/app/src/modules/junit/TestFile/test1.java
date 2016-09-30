package modules.junit.testFile;
import  modules.Files.MapFile;
import  modules.Files.File;
import  org.junit.Test;
import  static  org.junit.Assert.*;
import  org.junit.After;
import  org.junit.Before;
import  java.io.BufferedWriter;
import  java.io.FileWriter;
import  java.io.IOException;



public class test1{

    public String filecontent = "     Key    Value \n name   bianjian\n sex    nan";
    public static String filename;
    private File  file = null;

    private String testFilePath = "/home/duanduan/WorkPlace/Java/Crawler_Web/app/src/modules/junit/TestFile/source/file/";

    @Before public void initialize(){

            java.io.File  file_handle = new java.io.File("source/file/test1.file");
            this.filename = file_handle.getAbsoluteFile().toString();


            if(!file_handle.exists()){

                try{

                    file_handle.createNewFile();

                }catch(IOException ioe){

                    System.out.println("新建文件出现错误!");
                    ioe.printStackTrace();
                    System.exit(0);
                }

                try{
                     BufferedWriter file_bw = new BufferedWriter(new FileWriter(file_handle));

                     file_bw.write(filecontent,0,filecontent.length());

                     file_bw.close();
                    }catch(IOException ioe){

                        System.out.println("写入文件出错!");
                        ioe.printStackTrace();
                        System.exit(0);
            }


    }




            }

   /**
     *
     *   单元测试modules.Files.MapFile.isMapFile()
     *
     */
    @Test  public void TestIsMap(){

            MapFile  mapf = new  MapFile(new File(filename){
            });

            assertEquals(true,mapf.isMapFile());

    }

    @Test public void TestIsMap_en_criterion1(){

            String fname = "en_criterion1.txt";
            fname = testFilePath+fname;
            MapFile  mapf = new  MapFile(new File(fname){
            });

            assertEquals(true,mapf.isMapFile());




    }

    @Test public void TestIsMap_en_criterion2(){
        String fname = "en_criterion2.txt";
        fname  = testFilePath+fname;
        MapFile  mapf = new  MapFile(new File(fname){
            });

            assertEquals(true,mapf.isMapFile());



    }

    @Test public void TestIsMap_en_criterion3(){
        String fname = "en_criterion3.txt";
        fname = testFilePath+fname;

        MapFile  mapf = new  MapFile(new File(fname){
            });

            assertEquals(true,mapf.isMapFile());




    }


    @Test public void TestIsMap_en_criterion4(){
        String fname = "en_criterion4.txt";
        fname = testFilePath+fname;

        MapFile  mapf = new  MapFile(new File(fname){
            });

            assertEquals(true,mapf.isMapFile());




    }
    /**
     *
     * 单元测试同上isMapFile()的中文格式支持情况
     *
     *
     */
    @Test public void TestIsMap_ch_criterion1(){

        String fname = "ch_criterion1.txt";
        fname  = testFilePath+fname;
        MapFile mapf = new MapFile(new File(fname){


        });

        assertEquals(true,mapf.isMapFile());

    }

    @Test public void TestIsMap_ch_criterion2(){

            String fname = "ch_criterion2.txt";
            fname  = testFilePath+fname;
            MapFile mapf = new MapFile(new File(fname){


            });

            assertEquals(true,mapf.isMapFile());

        }


    @Test public void TestIsMap_ch_criterion3(){

            String fname = "ch_criterion3.txt";
            fname  = testFilePath+fname;
            MapFile mapf = new MapFile(new File(fname){


            });

            assertEquals(true,mapf.isMapFile());

        }

    @Test public void TestIsMap_ch_criterion4(){

            String fname = "ch_criterion4.txt";
            fname  = testFilePath+fname;
            MapFile mapf = new MapFile(new File(fname){


            });

            assertEquals(true,mapf.isMapFile());

        }


}
