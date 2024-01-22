package cn.dails.config;

public enum MarkEnum {
    SAFE("safe","",""),
    ID_CAED15("idcard15","",""),
    ID_CAED18("idcard18","",""),
    MOBILE("mobile","",""),
    TEL("tel","",""),
    ADRESS("address","",""),
    EMAIL("email","",""),
    CHINESENAME("chineseName","",""),
    BANKCARD("bankcard","",""),
    PLANTNUM("plantnum","",""),
    VIN("vin","","")
    ;
    private String sn;
    private String regex;
    private String replacement;
    MarkEnum (String sn,String regex,String replacement){
        this.sn = sn;
        this.regex = regex;
        this.replacement = replacement;

    }

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
