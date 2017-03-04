package com.ninjadevops.tower.storage;

import com.ninjadevops.tower.model.ConfigObject;
import com.ninjadevops.tower.model.DBConnection;
import com.ninjadevops.tower.model.JobConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by me@liguoliang.com on 2/20/2017.
 */
public class ConfigDataStoreInMemory implements ConfigDataStore {
    Map<String, ConfigObject> objectsRepo;

    public ConfigDataStoreInMemory() {
        objectsRepo = new HashMap<>();
    }

    public void setObjectsRepo(Map<String,ConfigObject> objectsRepo) {
        this.objectsRepo = objectsRepo;
    }

    @Override
    public DBConnection getDBConnectionById(String id) {
        return (DBConnection) objectsRepo.get(id);
    }

    @Override
    public DBConnection saveDBConnection(DBConnection newConfigObject) {
        objectsRepo.put(newConfigObject.getId(), newConfigObject);
        return newConfigObject;
    }

    @Override
    public JobConfig getJobConfigByID(String id) {
        return (JobConfig) objectsRepo.get(id);
    }

    @Override
    public JobConfig saveJobConfig(JobConfig jobConfig) {
        objectsRepo.put(jobConfig.getId(), jobConfig);
        return jobConfig;
    }
}
