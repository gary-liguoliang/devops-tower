package com.ninjadevops.tower.service;

import com.ninjadevops.tower.model.ConfigObject;
import com.ninjadevops.tower.model.DBConnection;
import com.ninjadevops.tower.storage.ConfigDataStore;

/**
 * Created by me@liguoliang.com on 2/16/2017.
 * ConfigService handles all ConfigObject CRUD.
 */
public class ConfigService {
    ConfigDataStore configDataStore;

    public void setConfigDataStore(ConfigDataStore configDataStore) {
        this.configDataStore = configDataStore;
    }

    public ConfigObject getConfigObjectById(String id) {
        return configDataStore.getConfigObjectById(id);
    }
}
