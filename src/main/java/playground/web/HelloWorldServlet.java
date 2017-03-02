package playground.web;

import org.springframework.beans.factory.annotation.Autowired;
import playground.db.DataStore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalTime;

/**
 * Created by guoliang on 2/13/2017.
 */
@WebServlet(urlPatterns = {"/hi"})
public class HelloWorldServlet extends HttpServlet {

    protected String message;

    public void init() throws ServletException
    {
        // Do required initialization
        message = "Hello World";
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException
    {
        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1><hr />" + request.getRequestURI() + " @" + LocalTime.now().toString());
        out.print("Result: <hr /> ");
        try {
            out.print(DataStore.getDummyResult());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void destroy()
    {
        // do nothing.
    }
}