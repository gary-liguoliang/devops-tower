package com.ninjadevops.tower.feature;

import com.ninjadevops.tower.model.DBConnection;
import com.ninjadevops.tower.model.JobConfig;
import com.ninjadevops.tower.model.runtime.JobInstance;
import com.ninjadevops.tower.model.runtime.JobRunResult;
import com.ninjadevops.tower.service.ConfigService;
import com.ninjadevops.tower.service.JobExecutor;
import com.ninjadevops.tower.storage.ConfigDataStore;
import com.ninjadevops.tower.storage.ConfigDataStoreInMemory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SQLFeatureTest {

    public static final String DB_CONNECTION = "db-connection-1";
    public static final String JOB_GET_APP_NAME = "get-app-name";
    private ConfigDataStore configDataStoreInMemory;
    private ConfigService configService;

    @Before
    public void setUp() throws Exception {
        configDataStoreInMemory = new ConfigDataStoreInMemory();

        configDataStoreInMemory.saveDBConnection(DBConnection.newInstance(DB_CONNECTION, "jdbc:h2:mem:test"));
        configDataStoreInMemory.saveJobConfig(JobConfig.newInstance(JOB_GET_APP_NAME, "SELECT 'DevOpsTower'"));

        configService = new ConfigService();
        configService.setConfigDataStore(configDataStoreInMemory);
    }

    @Test
    public void getAndExecuteSQLJob() throws Exception {
        JobInstance jobInstance = new JobInstance(configService.getJobConfigById(JOB_GET_APP_NAME), configService.getDBConnectionById(DB_CONNECTION));
        JobExecutor executor = new JobExecutor();
        JobRunResult result = executor.execute(jobInstance);

        assertEquals("DevOpsTower", result.getValue());
    }
}