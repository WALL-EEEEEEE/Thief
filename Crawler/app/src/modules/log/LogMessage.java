package modules.log;

import modules.common.Message;

/**
 * Description: 日志消息类,对日志消息格式的进行规范
 * @author    :duanduan
 * Date       : 2016-02-29
 * SuperClass : @see modules.common.Message
 *
 */

public class LogMessage extends Message {


    /**
     * Description: 消息类型
     */
    public String MESSAGE_TYPE;

    /**
     * Description: 消息级别
     */
    public int MESSAGE_LEVEL;


    /**
     * Description:消息体
     */
    public String MESSAGE_CONTENT;


    /**
     * Description: 消息体时间
     */
    public String MESSAGE_TIME;


    /**
     * Description:复写父类Message对LogMessage进行格式化输出
     *
     * @return  String 返回的消息体信息
     */
    @Override
    public  String toString(){

        return MESSAGE_TIME+"  "+MESSAGE_TYPE+"["+MESSAGE_LEVEL+"]: "+MESSAGE_CONTENT;
    }

}
