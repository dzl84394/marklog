package cn.dails.utils;

import cn.dails.bean.RegexReplacementVo;
import cn.dails.config.MarkConfig;
import cn.dails.marker.logback.ReplaceMarker;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MarkUtils {

    /**
     * noMark
     * @param claze
     * @param message
     * @return
     */
    public static String desensitize(String claze , String message, ReplaceMarker marker){
        if (message.length()>= MarkConfig.markMaxlenght){
            message = message.substring(0,MarkConfig.markMaxlenght)+"...";
        }
        //DENY,NEUTRAL,ACCEPT
        // 默认的比例高,neutral是普通，中立的意思，打过marker标签的日志不进过全局扫描，如果没有打过就需要路过全局扫描
        if("NEUTRAL".equals(MarkConfig.markLevel)){

        }else if("DENY".equals(MarkConfig.markLevel)){//不走所有过滤
            message = handleByRegex(claze,message,marker.getFieldset());
            message =handleByKey(claze,message,marker.getKeys());
            message = handleByAllKey(claze,message);
            return message;
        }else{//ACCEPT ,所有的都需要过一遍
            message = handleByALLRege(claze,message);
            message = handleByAllKey(claze,message);
        }
        return message;
    }

    public static String  handleByALLRege(String claze ,String message){
        Map<String,RegexReplacementVo> vos = MarkConfig.markReplaceMap;
        for (Map.Entry<String, RegexReplacementVo> entry : vos.entrySet()) {
            String key = entry.getKey();
            RegexReplacementVo vo = entry.getValue();
            String regex = vo.getRegex();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(message);
            if (matcher.find()){
                message = message.replaceAll(regex,vo.getReplacement());
            }
        }
        return message;
    }

   public static String  handleByRegex(String claze , String message, Set<String> set){
       for (String e : set) {
           RegexReplacementVo vo = MarkConfig.markReplaceMap.get(e);
           String regex = vo.getRegex();
           Pattern pattern = Pattern.compile(regex);
           Matcher matcher = pattern.matcher(message);
           if (matcher.find()) {
               message = message.replaceAll(regex, vo.getReplacement());
           }
       }
       return message;
   }
    public static String  handleByAllKey(String clasze ,String message){
        String keys = MarkConfig.markKeys;
        String regex = "("+keys+")(\"|')(:|=)(\\[\"|)(=|=\\[|\\\"|\\\\\\\"|\\\\\\\\\\\"|:)(.*)(\\]|\\\"|\\\\\\\"|\\\\\\\\\\\"|,)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(message);
        if (matcher.find()) {
            message = message.replaceAll(regex, "$1$2***$4");
        }

        return message;
    }
    public static String  handleByKey(String clasze ,String message,String keys){
        String regex = "("+keys+")(\"|')(:|=)(\\[\"|)(=|=\\[|\\\"|\\\\\\\"|\\\\\\\\\\\"|:)(.*)(\\]|\\\"|\\\\\\\"|\\\\\\\\\\\"|,)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(message);
        if (matcher.find()) {
            message = message.replaceAll(regex, "$1$2***$4");
        }

        return message;
    }

}
