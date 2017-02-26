package com.ninjadevops.tower.storage;

import com.ninjadevops.tower.model.ConfigObject;

/**
 * Created by me@liguoliang.com on 2/26/2017.
 */
public interface ConfigDataStore {
    ConfigObject getConfigObjectById(String id);

    ConfigObject saveConfigObject(ConfigObject newConfigObject);
}
