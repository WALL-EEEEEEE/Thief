package modules.Files;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.io.FileReader;
import modules.common.Component;

public abstract class File  extends Component{


        protected java.io.File sfile;

        protected String fileName;

        public File(String fname){


                    sfile = new java.io.File(fname);
                    if(!sfile.exists()){

                        System.out.println(sfile.getAbsolutePath()+"  文件不存在,请给出正确的文件路径!");
                        System.exit(0);


                    }

            }

        public File() {


        }


        public void Operation(){

        }


        /**
         * Description: 获取文件的绝对路径名称
         * @return String 路径名称
         *
         */
        protected String getFileName(){

            return sfile.getAbsolutePath();
        }


        /**
         * Descrption: 添加文件内容至文件内容末尾
         */

        public void append(){




        }


}
