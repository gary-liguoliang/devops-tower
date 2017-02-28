package playground.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * Created by me@liguoliang.com on 2/28/2017.
 */

@EnableAutoConfiguration
public class SBApp {

    public static void main(String[] args) {
        SpringApplication.run(SBApp.class, args);
    }
}
