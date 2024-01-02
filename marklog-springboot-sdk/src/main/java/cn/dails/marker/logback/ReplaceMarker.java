package cn.dails.marker.logback;

import java.util.HashSet;
import java.util.Set;

public class ReplaceMarker extends AbstractMarker{
    private Set<String> sensitiveTYpes;
    private String mark;

    public ReplaceMarker() {
        this.sensitiveTYpes = new HashSet<>();
        this.mark = "";
    }

    public Set<String> getSensitiveTYpes() {
        return sensitiveTYpes;
    }

    public void setSensitiveTYpes(Set<String> sensitiveTYpes) {
        this.sensitiveTYpes = sensitiveTYpes;
    }
    public void addSensitiveTYpes(String sensitiveTYpe) {
        if (this.sensitiveTYpes.isEmpty()){
            this.sensitiveTYpes = new HashSet<>();
        }
        this.sensitiveTYpes.add(sensitiveTYpe);
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }
}
