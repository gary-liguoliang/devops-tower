package playground.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Created by me@liguoliang.com on 3/4/2017.
 */
@SpringBootApplication
public class SampleJerseyApplication extends SpringBootServletInitializer{
    public static void main(String[] args) {
        new SampleJerseyApplication()
                .configure(new SpringApplicationBuilder(SampleJerseyApplication.class))
                .run(args);
    }
}
