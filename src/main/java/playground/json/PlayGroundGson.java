package playground.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ninjadevops.tower.model.DBConnection;
import com.ninjadevops.tower.model.JobConfig;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by me@liguoliang.com on 2/27/2017.
 */
public class PlayGroundGson {

    public static void main(String[] args) {
        String json = "{\"id\":\"db-sit\", \"connectionString\": \"dbc:h2:mem:test\"}";
        Gson gson = new Gson();
        System.out.println(gson.fromJson(json, DBConnection.class));

        json = "{\"id\":\"query-get-env-name\", \"command\": \"SELECT 'SIT'\"}";
        System.out.println(gson.fromJson(json, JobConfig.class));

        json = "[ {\"id\":\"db-sit\", \"connectionString\": \"dbc:h2:mem:test\"}, " +
                "{\"id\":\"db-sit2\", \"connectionString\": \"dbc:h2:mem:test\"}]";


        Type listType = new TypeToken<ArrayList<DBConnection>>() {}.getType();

        List<DBConnection> dbConnections = new Gson().fromJson(json, listType);
        System.out.println(dbConnections);
    }


}
