package com.ninjadevops.tower.storage;

import com.ninjadevops.tower.model.DBConnection;
import com.ninjadevops.tower.model.JobConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

/**
 * Created by me@liguoliang.com on 3/4/2017.
 */
public class ConfigDataStoreFileTest {

    private ConfigDataStoreFile configDataStoreFile;

    @Before
    public void setUp() throws Exception {
        configDataStoreFile = new ConfigDataStoreFile();
        configDataStoreFile.setDbConnectionsSource(new File(getClass().getClassLoader().getResource("db-connections.json").getFile()).getAbsolutePath());
        configDataStoreFile.setConfigJobsSource(new File(getClass().getClassLoader().getResource("job-configs.json").getFile()).getAbsolutePath());
    }

    @Test
    public void getDBConnectionById() throws Exception {
         DBConnection dbConnection = configDataStoreFile.getDBConnectionById("db-sit2");
         Assert.assertEquals("db-sit2", dbConnection.getId());
    }

    @Test
    public void getJobConfigByID() throws Exception {
        JobConfig jobConfig = configDataStoreFile.getJobConfigByID("get-env-name");
        Assert.assertEquals("get-env-name", jobConfig.getId());
    }
}