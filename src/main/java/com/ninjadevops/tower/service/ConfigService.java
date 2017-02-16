package com.ninjadevops.tower.service;

import com.ninjadevops.tower.model.ConfigObject;

/**
 * Created by me@liguoliang.com on 2/16/2017.
 * ConfigService handles all ConfigObject CRUD.
 */
public class ConfigService {

    public ConfigObject getConfigObjectById(String id) {
        return new ConfigObject(id);
    }
}
