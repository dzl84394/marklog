package cn.dails.config;

import cn.dails.bean.RegexReplacementVo;
import com.google.common.base.Strings;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.awt.datatransfer.StringSelection;
import java.util.List;
import java.util.Map;

@Component
@Configuration
@ConfigurationProperties(prefix = "mark")
public class MarkConfig {
    private String keys;
    private String level;
    private int maxlenght;
    private boolean hit;
    private List<RegexReplacementVo> replaceList;

    public static String markKeys = "";
    public static String markLevel ="NEUTRAL";// DENY,NEUTRAL,ACCEPT
    public static int markMaxlenght = 4096;
    public static boolean markhit = false;
    public static Map<String,RegexReplacementVo> markReplaceMap;

    @PostConstruct
    public void  init(){
        if (Strings.isNullOrEmpty(keys)){
            markKeys = this.keys;
        }
        if (Strings.isNullOrEmpty(level)){
            markLevel = this.level;
        }
        if (maxlenght!=0){
            markMaxlenght= this.maxlenght;
        }
        if (hit){
            markhit = true;
        }
        if(replaceList!=null){
            replaceList.forEach(e->{
                markReplaceMap.put(e.getSn(),e);
            });

        }

    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getMaxlenght() {
        return maxlenght;
    }

    public void setMaxlenght(int maxlenght) {
        this.maxlenght = maxlenght;
    }

    public boolean isHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    public List<RegexReplacementVo> getReplaceList() {
        return replaceList;
    }

    public void setReplaceList(List<RegexReplacementVo> replaceList) {
        this.replaceList = replaceList;
    }
}
