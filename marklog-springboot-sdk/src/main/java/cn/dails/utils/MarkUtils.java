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
        // 默认的比例高
        if("NEUTRAL".equals(MarkConfig.markLevel)){

        }else if("DENY".equals(MarkConfig.markLevel)){
            return message;
        }else{
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
