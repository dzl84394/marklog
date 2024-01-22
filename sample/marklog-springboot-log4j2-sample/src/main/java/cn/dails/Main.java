package cn.dails;

import org.apache.logging.log4j.MarkerManager;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import static cn.dails.marker.log4j2.Log4jMarker.SEC2;

public class Main {
    public static void main(String[] args) {
        Marker myMarker = MarkerManager.getMarker("MY_MARKER");
        SEC2.addFieldset("");
        SEC2.setKeys("abc|name");
        System.out.println("Hello world!");
    }
}