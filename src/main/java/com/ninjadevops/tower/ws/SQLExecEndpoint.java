package com.ninjadevops.tower.ws;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ninjadevops.tower.model.ConfigObject;
import com.ninjadevops.tower.model.DBConnection;
import com.ninjadevops.tower.model.JobConfig;
import com.ninjadevops.tower.model.runtime.JobInstance;
import com.ninjadevops.tower.service.ConfigService;
import com.ninjadevops.tower.service.JobExecutor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.UUID;

/**
 * Created by me@liguoliang.com on 3/5/2017.
 */
@Component
@Path("/sql-exec")
public class SQLExecEndpoint {
    private ConfigService configService;
    private JobExecutor jobExecutor;

    public SQLExecEndpoint(ConfigService configService, JobExecutor jobExecutor) {
        System.out.println(configService);
        this.configService = configService;
        this.jobExecutor = jobExecutor;
    }

    @GET
    public String getResult(@QueryParam("conn") @NotNull String conn, @QueryParam("sql-job-id") @NotNull String sqlJobId) {
        String result = "";
        try {
            DBConnection dbConnection = configService.getDBConnectionById(conn);

            result += jobExecutor.execute(new JobInstance(configService.getJobConfigById(sqlJobId), dbConnection)).toJson();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @POST
    public String executeAdhocSql(String request) {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, String>>(){}.getType();
        Map<String, String> requestMap = gson.fromJson(request, type);

        String env = requestMap.get("env");
        String sql = requestMap.get("query");

        String result = "";
        JobConfig jobConfig = JobConfig.newInstance("adhoc-" + UUID.randomUUID().toString(), sql);
        try {
            JobInstance jobInstance = new JobInstance(jobConfig, configService.getDBConnectionById(env));
            result += jobExecutor.execute(jobInstance).toJson();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

}
