package com.ninjadevops.tower.ws;

import com.ninjadevops.tower.model.DBConnection;
import com.ninjadevops.tower.model.JobConfig;
import com.ninjadevops.tower.model.runtime.JobInstance;
import com.ninjadevops.tower.service.ConfigService;
import com.ninjadevops.tower.service.JobExecutor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

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

}
