package playground.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/message")
public class JerseyHelloWorld {
    @GET
    public String getMsg()
    {
        return "Hello World from Jersey 2";
    }
}
