package playground.spring;

import org.springframework.stereotype.Component;
import playground.db.DataStore;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by me@liguoliang.com on 3/4/2017.
 */
@Component
@Path("/hello")
public class Endpoint {

    private final Service service;
    DataStore dataStore;

    public Endpoint(Service service, DataStore dataStore) {
        this.service = service;
        System.out.println(dataStore);
    }

    @GET
    public String message() {
        return "Hello " + this.service.message();
    }

}