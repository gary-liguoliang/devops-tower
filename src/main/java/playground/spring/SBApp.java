package playground.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import playground.db.DataStore;
import playground.web.WebAppLiteEmbedded;

/**
 * Created by me@liguoliang.com on 2/28/2017.
 */

@SpringBootApplication
public class SBApp {

    @Autowired
    DataStore dataStore;

    public static void main(String[] args) throws Exception {
        final SpringApplication app = new SpringApplication(SBApp.class);
        app.run();
//        WebAppLiteEmbedded webAppLiteEmbedded = new WebAppLiteEmbedded();
//        webAppLiteEmbedded.startWebApp();

    }
}
