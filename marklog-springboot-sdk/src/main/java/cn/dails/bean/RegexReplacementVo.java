package cn.dails.bean;

import java.io.Serializable;

public class RegexReplacementVo implements Serializable {
    private String sn;
    private String regex;
    /**
     * 替换正则
     */
    private String replacement;

//    public String format(final String msg) {
//        return regex.matcher(msg).replaceAll(replacement);
//    }


    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

    public String getReplacement() {
        return replacement;
    }

    public void setReplacement(String replacement) {
        this.replacement = replacement;
    }

}