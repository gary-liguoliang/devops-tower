package com.ninjadevops.tower.service;

import com.ninjadevops.tower.model.ConfigObject;
import com.ninjadevops.tower.model.DBConnection;
import com.ninjadevops.tower.model.JobConfig;
import com.ninjadevops.tower.model.runtime.JobInstance;
import com.ninjadevops.tower.model.runtime.JobRunResult;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by me@liguoliang.com on 2/18/2017.
 */
public class JobExecutorTest {
    JobExecutor testingJobExecutor;
    JobInstance jobInstance;

    DBConnection dbConnection;
    JobConfig sqlJobConfig;


    @Before
    public void setUp() throws Exception {
        testingJobExecutor = new JobExecutor();
        JobConfig jobConfig = null;
        ConfigObject configObject = null;
        jobInstance = new JobInstance(jobConfig, configObject);

        dbConnection = new DBConnection("db-connection-1");
        dbConnection.setConnectionString("jdbc:h2:mem:test");

        sqlJobConfig = new JobConfig();
        sqlJobConfig.setCommand("SELECT 'LI'");
    }

    @Test
    public void executeSQLJobTest() {
        jobInstance = new JobInstance(sqlJobConfig, dbConnection);

        JobRunResult result = null;
        try {
            result = testingJobExecutor.execute(jobInstance);
        } catch (JobExecutor.JobExecutionException e) {
            e.printStackTrace();
        }
        assertEquals("LI", result.getValue());
    }

    @Test(expected = JobExecutor.JobExecutionException.class)
    public void executeSQLJobNegativeTest() throws JobExecutor.JobExecutionException {
        JobConfig sqlJobConfigWithSyntaxError = new JobConfig();
        sqlJobConfigWithSyntaxError.setCommand("SELEC 'LI'");
        jobInstance = new JobInstance(sqlJobConfigWithSyntaxError, dbConnection);

        testingJobExecutor.execute(jobInstance);
    }

}