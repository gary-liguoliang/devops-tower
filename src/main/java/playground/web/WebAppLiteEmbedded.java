package playground.web;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;


/**
 * Created by guoliang on 2/13/2017.
 * http://www.eclipse.org/jetty/documentation/9.4.x/embedded-examples.html
 */
public class WebAppLiteEmbedded {

    public static void main(String[] args) throws Exception{
        Server server = new Server(8081);
        ServletHandler servletHandler = new ServletHandler();
        server.setHandler(servletHandler);

        servletHandler.addServletWithMapping(HelloWorldServlet.class, "/");
        server.start();
        server.join();
    }

}
