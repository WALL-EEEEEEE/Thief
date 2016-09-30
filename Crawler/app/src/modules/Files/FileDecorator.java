
package modules.Files;
import modules.Files.File;
import java.io.IOException;

      /*
       * @author: duanduan
       * @date  : itime
       * @function: 文件处理类(采用了装饰器模式)的基类,对各种各样的文件进行读写处理类提供标准。
       * @subclass: ConfigFile
                    MapFile
       */
public abstract class FileDecorator extends File {

    protected File mfile ;

    public FileDecorator(){

    }

    public FileDecorator(File ifile){

        this.mfile = ifile;

    }

    public final void  ReadOperation() throws FileFormatException{

         try{
            this.ReadBeforeOperation();
            mfile.Operation();
            Read();
            this.ReadAfterOperation();
         }catch(IOException ioe){

             System.out.println("文件io读取异常!");
             ioe.printStackTrace();
         }


    };

    public final void  WriteOperation() throws IOException{

            this.WriteBeforeOperation();
            mfile.Operation();
            Write();
            this.WriteAfterOperation();



    };

    protected abstract void Read() throws FileFormatException;
    protected abstract void Write() throws IOException;

    protected abstract void ReadBeforeOperation();
    protected abstract void ReadAfterOperation() throws IOException;

    protected abstract void WriteBeforeOperation();
    protected abstract void WriteAfterOperation();


}




