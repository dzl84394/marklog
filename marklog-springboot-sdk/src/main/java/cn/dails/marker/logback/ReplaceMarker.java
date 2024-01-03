package cn.dails.marker.logback;

import java.util.HashSet;
import java.util.Set;

public class ReplaceMarker extends AbstractMarker{
    private Set<String> fieldset;
    private String keys;

    public ReplaceMarker() {
        this.fieldset = new HashSet<>();
        this.keys = "";
    }

    public Set<String> getFieldset() {
        return fieldset;
    }

    public void setFieldset(Set<String> fieldset) {
        this.fieldset = fieldset;
    }
    public void addFieldset(String string) {
        if (this.fieldset.isEmpty()){
            this.fieldset = new HashSet<>();
        }
        this.fieldset.add(string);
    }

    public String getKeys() {
        return keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }
}
