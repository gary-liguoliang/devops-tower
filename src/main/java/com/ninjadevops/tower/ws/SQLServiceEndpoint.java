package com.ninjadevops.tower.ws;

import com.ninjadevops.tower.model.DBConnection;
import com.ninjadevops.tower.service.ConfigService;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by me@liguoliang.com on 3/5/2017.
 */
@Component
@Path("/sql")
public class SQLServiceEndpoint {
    private ConfigService configService;
    public SQLServiceEndpoint(ConfigService configService) {
        System.out.println(configService);
        this.configService = configService;
    }

    @GET
    public String message() {
        String result = "";
        try {
            DBConnection dbConnection = configService.getDBConnectionById("db-sit2");
            result += dbConnection.getConnectionString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Please use POST: " + result;
    }

}
