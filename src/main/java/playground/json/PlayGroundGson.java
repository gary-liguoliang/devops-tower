package playground.json;

import com.google.gson.Gson;
import com.ninjadevops.tower.model.DBConnection;
import com.ninjadevops.tower.model.JobConfig;

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
    }


}
