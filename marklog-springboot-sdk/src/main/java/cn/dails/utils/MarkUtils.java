package cn.dails.utils;

import cn.dails.bean.RegexReplacementVo;
import cn.dails.config.MarkConfig;

import java.util.List;

public class MarkUtils {

    public static String desensitize(String claze , String message){
        if (message.length()>= MarkConfig.markMaxlenght){
            message = message.substring(0,MarkConfig.markMaxlenght)+"...";
        }
        //DENY,NEUTRAL,ACCEPT
        // 默认的比例高,neutral是普通，中立的意思，打过marker标签的日志不进过全局扫描，如果没有打过就需要路过全局扫描
        if("NEUTRAL".equals(MarkConfig.markLevel)){

        }else if("DENY".equals(MarkConfig.markLevel)){//不走所有过滤
            return message;
        }else{//ACCEPT ,所有的都需要过一遍
            handleByRegex(claze,message);
            handleByKey(claze,message);
        }
        return message;
    }

   public static String  handleByRegex(String claze ,String message){
       return message;
   }
    public static String  handleByKey(String clasze ,String message){
        return message;
    }

}
