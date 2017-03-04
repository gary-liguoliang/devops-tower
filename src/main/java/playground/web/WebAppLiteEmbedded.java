package playground.web;


import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.glassfish.jersey.servlet.ServletContainer;


/**
 * Created by guoliang on 2/13/2017.
 * http://www.eclipse.org/jetty/documentation/9.4.x/embedded-examples.html
 */
public class WebAppLiteEmbedded {

    public void startWebApp() throws Exception {
        Server server = new Server(8081);

        ServletContextHandler contextHandler = new ServletContextHandler(ServletContextHandler.NO_SESSIONS);
        contextHandler.setContextPath("/");
        server.setHandler(contextHandler);

        ServletHolder servletHolder = contextHandler.addServlet(org.glassfish.jersey.servlet.ServletContainer.class, "/rest/*");
        servletHolder.setInitParameter("jersey.config.server.provider.packages", "playground.web");
        servletHolder.setInitOrder(1);

        contextHandler.addServlet(HelloWorldServlet.class, "/");

        server.start();
        server.join();
    }

    public static void main(String[] args) throws Exception {
        WebAppLiteEmbedded app = new WebAppLiteEmbedded();
        app.startWebApp();

    }


}
