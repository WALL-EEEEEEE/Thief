package modules.test.ConfFile;


import java.io.FileNotFoundException;
import modules.Files.ConfigFile;
import modules.Files.File;
import java.io.IOException;
import modules.DebugTools.Debug;

public class TestConfFile{


    public void  test(){

        try{
        File       fl  = new File("../../app.conf"){};
        ConfigFile cf = new ConfigFile(fl);


        cf.ReadOperation();

        String[] values = cf.getConfigValues("search_site");
        Debug.DumpArray(values);

        }catch(FileNotFoundException fe){
                    fe.printStackTrace();
        }catch(IOException ioe){

           System.out.println( ioe.getMessage());

        }

    }





}
