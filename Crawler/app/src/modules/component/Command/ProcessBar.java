package modules.component.Command;

import modules.common.EventListener;
import modules.common.Event;
import static modules.common.TypeSmartConvert.FormatNum;
import java.util.List;
import java.util.ArrayList;
import java.text.NumberFormat;


    /**
     * Description: 进度条控件,可以用来呈现任务处理过程的情况.
     *
     * @author: duanduan
     * @date  : 2016-02-25
     *
     */
public class ProcessBar {


    /**
     * Description:进度条的边框样式
     *
     * StyleLeftBorder 左边框
     * StyleRightBorder 右边框
     * StyleTopBorder  上边框
     * StyleBottomBorder 下边框
     * State            状态填充
     * height           高度
     * width            宽度
     */
    private String StyleLeftBorder   = "[";

    private String StyleRightBorder  = "]";

    private String StyleTopBorder    = "";

    private String StyleBottomBorder = "";

    private String Stateatom         = ">";

    private int  height;
    private int  width ;


    /**
     *Description: 存储控件内的事件监听器
     *
     */
    private List<StatusChangeEventListener> lEvent = new ArrayList<StatusChangeEventListener>();
    /**
     * Description: 总共需要处理的数据
     *
     */
     public float TotalData;

     /**
      * Description: 已经处理了的数据
      */

     public float ProcessedData;

     /**
      * Description: 处理进程的百分比
      */
     public float LoadPersent;


     /**
      * Description: 进度条实时状态
      */
     public float ProcessBarState;

     /**
      *Description: 初始化进度条控件
      *@param int width   进度条的宽度
      *@param int height  进度条的高度
      *@param int SumData 需要处理的总数据
      *
      */
     public ProcessBar(int width,int height,int SumData){

         this.height = height;
         this.width  = width;
         this.TotalData = SumData;
     }


     /**
      * Description: 状态条状态改变监听器
      */
     public static  class StatusChangeEventListener extends EventListener{

        /**
          * Description:处理事件
          * @param StatusChangeEvent se 状态改变事件
          */
         public void doAction(StatusChangeEvent el){



         }



     }

     /**
      * Description: 状态改变事件,存储着状态条的信息
      */
     public  static  class StatusChangeEvent{

         /**
          * Description:记录事件的状态
          *
          */

         int  Status;

     }


     /**
      *Description: 重绘进度条
      *
      */
     public void Refresh(){


     }

     /**
      *Description: 绘制进度条
      */
     public void Draw(){

         /**绘制上边框**/
         for(int iwidth = 0;iwidth<= this.width;iwidth++){


                System.out.print(StyleTopBorder);

         }

         System.out.println();

         /**绘制左右边框**/
         for(int iheight = 0;iheight<=this.height;iheight++){


              System.out.print(StyleLeftBorder);
               for(int iwidth_ = 0;iwidth_<=this.width;iwidth_++){

                   if(iwidth_<=this.ProcessBarState*this.width){

                       if(iwidth_ !=0){

                           System.out.print(Stateatom);

                       }

                   }else{

                       System.out.print(" ");
                   }

             }
               System.out.print(StyleRightBorder+"  LoadPersent:"+LoadPersent+"%");

               System.out.println();

         }

        /**绘制下边框**/
        for(int iwidth = 0;iwidth<= this.width;iwidth++){

                System.out.print(StyleBottomBorder);

         }





     }


     /**
       * Description: 为进度条绑定状态改变事件
       * @param StatusChangeEvent se 状态改变事件
       *
       */
     public void setOnStatusChange(StatusChangeEventListener se){

         this.lEvent.add(se);
     }


    /**
     * Description: 通知事件监听器
     * @param StatusChangeEvent e 状态改变事件
     *
     */

     private void handleEventListener(StatusChangeEvent e){




         for(StatusChangeEventListener el:lEvent){

             if(StatusChangeEventListener.class.isInstance(el)){

                 el.doAction(e);
             }
         }

     }



     /**
      * Description:更新进度条
      * @param int CurrentData 实时数据
      */
     public void Load(int CurrentData){

         this.ProcessedData = CurrentData;
         if(ProcessedData !=0){

             this.LoadPersent = this.ProcessedData/this.TotalData;
             //@TODO 设置精度为4以上没有影响
             this.ProcessBarState = FormatNum(LoadPersent,4).floatValue();
             this.LoadPersent = FormatNum(LoadPersent*100,4).floatValue();
             System.out.println(LoadPersent);
         }else{

             this.LoadPersent = 0;

         }

         this.Draw();

         //触发事件
         StatusChangeEvent se = new StatusChangeEvent();
         this.handleEventListener(se);



     }





}
