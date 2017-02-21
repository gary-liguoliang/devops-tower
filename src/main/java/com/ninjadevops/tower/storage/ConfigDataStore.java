package com.ninjadevops.tower.storage;

import com.ninjadevops.tower.model.ConfigObject;
import com.ninjadevops.tower.model.DBConnection;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by me@liguoliang.com on 2/20/2017.
 */
public class ConfigDataStore {
    Map<String, ConfigObject> objectsRepo;

    public ConfigDataStore() {
        objectsRepo = new HashMap<>();
    }

    public void setObjectsRepo(Map<String,ConfigObject> objectsRepo) {
        this.objectsRepo = objectsRepo;
    }

    public ConfigObject getConfigObjectById(String id) {
        return objectsRepo.get(id);
    }

    public ConfigObject saveConfigObject(ConfigObject newConfigObject) {
        objectsRepo.put(newConfigObject.getId(), newConfigObject);
        return newConfigObject;
    }
}
