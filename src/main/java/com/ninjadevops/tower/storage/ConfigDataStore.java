package com.ninjadevops.tower.storage;

import com.ninjadevops.tower.exception.StorageException;
import com.ninjadevops.tower.model.ConfigObject;
import com.ninjadevops.tower.model.DBConnection;
import com.ninjadevops.tower.model.JobConfig;

import java.io.FileNotFoundException;

/**
 * Created by me@liguoliang.com on 2/26/2017.
 */
public interface ConfigDataStore {
    DBConnection getDBConnectionById(String id) throws StorageException;

    DBConnection saveDBConnection(DBConnection dbConnection);

    JobConfig getJobConfigByID(String id) throws StorageException;

    JobConfig saveJobConfig(JobConfig jobConfig);
}
