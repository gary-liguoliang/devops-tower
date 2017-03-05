package com.ninjadevops.tower.service;

import com.ninjadevops.tower.exception.StorageException;
import com.ninjadevops.tower.model.ConfigObject;
import com.ninjadevops.tower.model.DBConnection;
import com.ninjadevops.tower.model.JobConfig;
import com.ninjadevops.tower.storage.ConfigDataStore;
import com.ninjadevops.tower.storage.ConfigDataStoreInMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by me@liguoliang.com on 2/16/2017.
 * ConfigService handles all ConfigObject CRUD.
 */
@Component
public class ConfigService {
    @Autowired
    ConfigDataStore configDataStore;

    public void setConfigDataStore(ConfigDataStore configDataStore) {
        this.configDataStore = configDataStore;
    }

    public DBConnection getDBConnectionById(String id) throws Exception {
        return configDataStore.getDBConnectionById(id);
    }

    public JobConfig getJobConfigById(String id) throws StorageException {
        return configDataStore.getJobConfigByID(id);
    }
}
