
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import static modules.DebugTools.Debug.*;

/**
 * Description: 模块建数据类,用于共享模块建的数据
 *
 *
 */
public class ModuleSharedData{

    /**
     * Description:无参构造函数,用于子类继承
     *
     */
    private static  int curID = 0;
    public ModuleSharedData(){

    }

    /**
     * Description:用于模块共享交流的数据
     *
     */
    protected static Map<Integer,Map<String,List<String>>> Datas = new HashMap<Integer,Map<String,List<String>>>();



    /**
     * Description:申请分配模块数据
     * @return int  存储数据所需的id
     */
    public  static int register(){

        int curID = Datas.size();


        return curID;

    }


    /**
     * Description: 写入模块数据
     * @param String[] 需要写入的模块的数据
     *
     */
    public static void write(Map<String,List<String>> data){

         Datas.put(curID,data);


    }
}
