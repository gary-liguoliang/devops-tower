package com.ninjadevops.tower.ws;

import com.ninjadevops.tower.service.ConfigService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by me@liguoliang.com on 3/4/2017.
 */
@SpringBootApplication

public class WebServiceApp extends SpringBootServletInitializer {
    public static void main(String[] args) {
        new WebServiceApp().configure(new SpringApplicationBuilder(WebServiceApp.class)).run(args);
    }
}
