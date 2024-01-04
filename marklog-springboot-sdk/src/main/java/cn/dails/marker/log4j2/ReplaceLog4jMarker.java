package cn.dails.marker.log4j2;

import java.util.HashSet;
import java.util.Set;

public class ReplaceLog4jMarker extends AbstractLog4jMarker {


    private Set<String> fieldset;
    private String keys;

    public ReplaceLog4jMarker(String name, Set<String> set) {
        super(name, set);
    }
    public ReplaceLog4jMarker() {
        this.keys = "";
        this.fieldset = new HashSet<String>();
    }

    public Set<String> getFieldset() {
        return fieldset;
    }
    public void addFieldset(String string) {
        if (this.fieldset.isEmpty()){
            this.fieldset = new HashSet<>();
        }
        this.fieldset.add(string);
    }
    public void setFieldset(Set<String> fieldset) {
        this.fieldset = fieldset;
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}
