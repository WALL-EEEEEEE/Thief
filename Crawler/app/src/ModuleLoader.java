/**
 * Description: 模块加载类,用来加载模块功能类
 */


import java.util.List;
import java.util.ArrayList;
public class ModuleLoader{

    //模块数组,用来存储加载的模块
       private  List<Module> modules = new ArrayList<Module>() ;


       /**
        * Description: 加载模块
        * @param: Module m 需要加载的模块
        *
        */
       public void load(Module m){

           modules.add(m);

       }


       /**
        * Description: 运行模块
        *
        */

       public void run(){


           for(Module module:modules){

               module.run();

           };

       }












}
