package cn.dails.marker.log4j2;

import org.apache.logging.log4j.Marker;

import java.util.Set;

public class AbstractLog4jMarker implements Marker {

    private Set<String> fieldset;
    private String keys;
    
    private  String name;
    private  Set<String> set;

    public AbstractLog4jMarker(String keys, Set<String> set) {
        this.name = keys;
        this.set = set;
    }

    public AbstractLog4jMarker() {
    }

    @Override
    public Marker addParents(Marker... markers) {
        return null;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Marker[] getParents() {
        return new Marker[0];
    }

    public Set<String> getSet() {
        return set;
    }



    @Override
    public boolean remove(Marker reference) {
        return false;
    }

    @Override
    public Marker setParents(Marker... markers) {
        return null;
    }

    @Override
    public boolean hasParents() {
        return false;
    }

    @Override
    public boolean isInstanceOf(Marker marker) {
        return false;
    }

    @Override
    public boolean isInstanceOf(String name) {
        return false;
    }

//    @Override
//    public boolean contains(Marker other) {
//        return false;
//    }
//
//    @Override
//    public boolean contains(String name) {
//        return false;
//    }
//
//    @Override
//    public Marker add(Marker reference) {
//        return null;
//    }
}