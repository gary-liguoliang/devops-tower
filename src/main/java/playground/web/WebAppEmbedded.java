package playground.web;

import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.plus.webapp.EnvConfiguration;
import org.eclipse.jetty.plus.webapp.PlusConfiguration;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.Configuration;
import org.eclipse.jetty.webapp.FragmentConfiguration;
import org.eclipse.jetty.webapp.JettyWebXmlConfiguration;
import org.eclipse.jetty.webapp.MetaInfConfiguration;
import org.eclipse.jetty.webapp.WebAppContext;
import org.eclipse.jetty.webapp.WebInfConfiguration;
import org.eclipse.jetty.webapp.WebXmlConfiguration;

import java.io.File;

/**
 * Created by guoliang on 2/13/2017.
 * http://www.eclipse.org/jetty/documentation/9.4.x/embedded-examples.html
 */
public class WebAppEmbedded {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8081);

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/");
        File warFile = new File("target/devops-tower-1.0-SNAPSHOT.war");
        webAppContext.setWar(warFile.getAbsolutePath());
        webAppContext.setConfigurations(new Configuration[]
                {
                        new AnnotationConfiguration(),
                        new WebInfConfiguration(),
                        new WebXmlConfiguration(),
                        new MetaInfConfiguration(),
                        new FragmentConfiguration(),
                        new EnvConfiguration(),
                        new PlusConfiguration(),
                        new JettyWebXmlConfiguration()
                });

        server.setHandler(webAppContext);

        server.start();
        server.join();
    }
}
