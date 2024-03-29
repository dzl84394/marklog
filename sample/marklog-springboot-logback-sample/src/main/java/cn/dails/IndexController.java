package cn.dails;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cn.dails.marker.logback.*;

import static cn.dails.marker.logback.LogbackMarker.SEC;

@RestController
@Slf4j
public class IndexController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/hello")
    public String home(@RequestParam(value = "name", defaultValue = "屌丝") String name) {
        SEC.addFieldset("mo");
        log.info(port+"："+name);
        return port+"："+name;
    }
}
